/*
 * Copyright 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.jribble.protobuf

import java.io._
import scala.sys.process.Process

object Generator {
  private val astPackage = "com.google.jribble.ast"
  private val protoPackage = "com.google.jribble.ast"
  private val protoClass = "JribbleProtos"
  private val protoFQCN = protoPackage + "." + protoClass

  def printToFile(file: File, value: Any) {
    val pw = new PrintWriter(file)
    pw.print(value.toString)
    pw.close
  }

  def decapitalize(str: String): String =
    if (str == null) null
    else if (str.length == 0) ""
    else {
      val chars = str.toCharArray
      chars(0) = chars(0).toLower
      new String(chars)
    }

  def getProto(nodes: List[Node]): String = {
    val proto = new StringBuilder

    proto.append("// Generated file.  DO NOT EDIT!.\n")
    proto.append("package jribble;\n")
    proto.append("\n")
    proto.append("option java_package = \"" + protoPackage + "\";\n")
    proto.append("option java_outer_classname = \"" + protoClass + "\";\n")
    proto.append("\n")

    val heads = nodes.filter(_.parent == None)

    for(head <- heads) {
      val subHead = nodes.filter(n => n.head == head && n != head && ! n.abstracted)
      proto.append("message " + head.name + " {\n")
      proto.append("  extensions 1000 to max;\n")
      proto.append("  enum MessageType {\n")
      for((subNode,index) <- subHead.zipWithIndex) {
        proto.append("    " + subNode.name + " = " + (index + 1) + ";\n")
      }
      proto.append("  }\n")
      proto.append("  required MessageType type = 1;\n")
      proto.append("}\n")
      proto.append("\n")

      for((node,sonIndex) <- subHead.filter(!_.params.isEmpty).zipWithIndex) {
        proto.append("message " + node.name + " {\n")
        proto.append("  extend " + head.name + " {\n")
        proto.append("    required " + node.name + " " + decapitalize(head.name) + " = " + (1000 + sonIndex) + ";\n")
        proto.append("  }\n")
        for((param, index) <- node.params.zipWithIndex) {
          param.typ match {
            case SimpleType(protoBufType) =>
              proto.append("  required " + protoBufType + " " + param.name + " = " + (2 + index) + ";\n")
            case OptType(typ: SimpleType) =>
              proto.append("  optional " + typ.protoBufType + " " + param.name + " = " + (2 + index) + ";\n")
            case CollectionType(typ) => {
              typ match {
                case typ: SimpleType =>
                  proto.append("  repeated " + typ.protoBufType + " " + param.name + " = " + (2 + index) + typ.packedString + ";\n")
                case TupleType(types) =>
                  proto.append("  repeated group " + param.name.capitalize + " = " + (2 + index) + " {\n")
                  for((subType, subIndex) <- types.zipWithIndex) {
                    subType match {
                      case typ: SimpleType =>
                        proto.append("    required " + typ.protoBufType + " t" + subIndex + " = " + (12 + 10 * subIndex + index) + ";\n")
                      case _ => throw new RuntimeException("I do not know how to handle " + param)
                    }
                  }
                  proto.append("  }\n")
                case OptType(SimpleType(protoBufType)) =>
                  proto.append("  repeated group " + param.name.capitalize + " = " + (2 + index) + " {\n")
                  proto.append("    optional " + protoBufType + " t = " + (12 + index) + ";\n")
                  proto.append("  }\n")
                case _ => throw new RuntimeException("I do not know how to handle " + param)
              }
            }
          }
        }
        proto.append("}\n")
        proto.append("\n")
      }

    }
    proto.toString
  }

  def simpleTypeToMessage(simpleType: SimpleType, path: String): String = {
    simpleType match {
      case RefType(node) => "convert" + node.head.name + "ToMessage(" + path + ")"
      case PrimitiveType(_) => path
    }
  }

  def extractValue(simpleType: SimpleType, path: String, index: String = "", subGetter: String = ""): String = {
    simpleType match {
      case RefType(node) => "read" + node.head.name + "Message(finalMessage.get" +
                            path.capitalize + "(" + index + ")" + subGetter  + ").asInstanceOf[" +
                            astPackage + "." + node.name + "]"
      case p@PrimitiveType(_) => "finalMessage.get" + path.capitalize + "(" + index + ")" + subGetter + p.castString
    }
  }

  def getReader(nodes: List[Node]) = {
    val reader = new StringBuilder

    reader.append("// Generated file.  DO NOT EDIT!.\n")
    reader.append("package " + astPackage + "\n")
    reader.append("\n")
    reader.append("object JribbleProtoReader {\n")
    reader.append("\n")
    reader.append("  val registry = com.google.protobuf.ExtensionRegistry.newInstance()\n")
    reader.append("  JribbleProtos.registerAllExtensions(registry)\n")
    reader.append("\n")

    val heads = nodes.filter(_.parent == None)

    for(head <- heads) {
      for(input <- List("com.google.protobuf.ByteString",
                        "scala.Array[Byte]",
                        "java.io.InputStream",
                        "com.google.protobuf.CodedInputStream")) {
        reader.append("  def read" + head.name + "Message(message: " + input + "): " + astPackage + "." + head.name + " = {\n")
        reader.append("   read" + head.name + "Message(JribbleProtos." + head.name + ".parseFrom(message, registry))\n")
        reader.append("  }\n");
      }
      reader.append("  def read" + head.name + "Message(message: " + protoFQCN + "." + head.name + "): " + astPackage + "." + head.name + " = {\n")
      val subHead = nodes.filter(n => n.head == head && !n.abstracted)
      reader.append("    message.getType() match {\n")
      for(node <- subHead) {
        reader.append("      case " + protoFQCN + "." + head.name + ".MessageType." + node.name + " =>\n")
        if(node.params.isEmpty) {
          reader.append("        " + astPackage + "." + node.name + "\n")
        } else {
          reader.append("        val finalMessage = message.getExtension(" + protoFQCN + "." + node.name + "." + decapitalize(head.name) + ")\n")
          for(param <- node.params) {

            param.typ match {
              case s: SimpleType =>
                reader.append("        val " + param.name + " = " + extractValue(s, param.name) + "\n")
              case OptType(typ: SimpleType) =>
                reader.append("        val " + param.name + " = if(finalMessage.has" + param.name.capitalize + "()) Some("
                              + extractValue(typ, param.name) + ") else None\n")
              case lt@CollectionType(typ: SimpleType) =>
                reader.append("        val " + param.name + " = for(index <- (0 until finalMessage.get"+ param.name.capitalize + "Count())." + lt.toConcreteMethod("Int") + ") yield " + extractValue(typ, param.name, "index") + "\n")
              case ListType(TupleType(types)) =>
                reader.append("        val " + param.name + " = for(index <- (0 until finalMessage.get"+ param.name.capitalize + "Count()).toList) yield ")
                val allValues = for((typ, index) <- types.zipWithIndex) yield {
                  typ match {
                    case s: SimpleType =>
                      extractValue(s, param.name, "index", ".getT" + index + "()")
                    case _ => throw new RuntimeException("I do not know how to handle " + param)
                  }
                }
                reader.append("(" + allValues.reduceLeft(_ + ", " + _) + ")\n")
              case ListType(OptType(typ: SimpleType)) =>
                reader.append("        val " + param.name + " = for(index <- (0 until finalMessage.get"+ param.name.capitalize + "Count()).toList) yield ")
                reader.append("if(finalMessage.get"+ param.name.capitalize + "(index).hasT()) Some(" + extractValue(typ, param.name, "index", ".getT") + ") else None\n")
              case _ => throw new RuntimeException("I do not know how to handle " + param)
            }
          }
          reader.append("        " + node.name + "(" + node.params.map(_.name).reduceLeft(_ + ", " + _) + ")\n")
        }
      }
      reader.append("    }\n")
      reader.append("  }\n")
    }

    reader.append("}\n")
    reader.toString
  }

  def getWriter(nodes: List[Node]) = {
    val writer = new StringBuilder

    writer.append("// Generated file.  DO NOT EDIT!.\n")
    writer.append("package " + astPackage + "\n")
    writer.append("\n")
    writer.append("object JribbleProtoWriter {\n")

    for(node <- nodes) {
      if(node.parent == None) {
        def subNode = nodes.filter(n => n.head == node && !n.abstracted)
        writer.append("  def convert" + node.name + "ToMessage(element: " + astPackage + "." + node.name + "): " + protoFQCN + "." + node.head.name + " = {\n")
        writer.append("    element match {\n")
        for(subNode <- subNode) {
          if(subNode.params.isEmpty) {
            writer.append("      case " + astPackage + "." + subNode.name + " => convert" + subNode.name + "ToMessageBuilder().build()\n")
          } else {
            writer.append("      case subElement: " + astPackage + "." + subNode.name + " => convert" + subNode.name + "ToMessageBuilder(subElement).build()\n")
          }
        }
        writer.append("    }\n")
        writer.append("  }\n")
      } else if(!node.abstracted) {
        val head = node.head
// Start
        if(node.params.isEmpty) {
          writer.append("  private def convert" + node.name + "ToMessageBuilder() = {\n")
          writer.append("    val message = " + protoFQCN + "." + head.name + ".newBuilder()\n")
          writer.append("    message.setType(" + protoFQCN + "." + head.name + ".MessageType." + node.name + ")\n")
          writer.append("    message\n");
          writer.append("  }\n")
        } else {
          writer.append("  private def convert" + node.name + "ToMessageBuilder(element: " + astPackage + "." + node.name + ") = {\n")
          writer.append("    val message = " + protoFQCN + "." + node.name + ".newBuilder()\n")
          for(param <- node.params) {
            param.typ match {
              case s: SimpleType =>
                writer.append("    message.set" + param.name.capitalize + "(" + simpleTypeToMessage(s, "element." + param.name) + ")\n")
              case OptType(typ: SimpleType) =>
                writer.append("    if(element." + param.name + " != None) message.set" + param.name.capitalize + "(" + simpleTypeToMessage(typ, "element." + param.name + ".get") + ")\n")
              case CollectionType(typ: SimpleType) =>
                writer.append("    for(subElement <- element." + param.name + ") {\n")
                writer.append("      message.add" + param.name.capitalize + "(" + simpleTypeToMessage(typ, "subElement") + ")\n")
                writer.append("    }\n")
              case ListType(TupleType(types)) =>
                writer.append("    for(subElement <- element." + param.name + ") {\n")
                writer.append("      val subMessage = "+ protoFQCN + "." + node.name + "." + param.name.capitalize + ".newBuilder()\n")
                for((subType, index) <- types.zipWithIndex) {
                  subType match {
                    case s: SimpleType =>
                      writer.append("      subMessage.setT" + index + "(" + simpleTypeToMessage(s, "subElement._" + (index+1)) + ")\n")
                    case _ => throw new RuntimeException("I do not know how to handle " + param)
                  }
                }
                writer.append("      message.add" + param.name.capitalize + "(subMessage.build())\n")
                writer.append("    }\n")
              case CollectionType(OptType(typ: SimpleType)) =>
                writer.append("    for(subElement <- element." + param.name + ") {\n")
                writer.append("      val subMessage = "+ protoFQCN + "." + node.name + "." + param.name.capitalize + ".newBuilder()\n")
                writer.append("      if(subElement != None) {\n")
                writer.append("        subMessage.setT(" + simpleTypeToMessage(typ, "subElement.get") + ")\n")
                writer.append("      }\n")
                writer.append("      message.add" + param.name.capitalize + "(subMessage.build())\n")
                writer.append("    }\n")
            }
          }
          writer.append("    val headMessage = " + protoFQCN + "." + head.name + ".newBuilder()\n")
          writer.append("    headMessage.setType(" + protoFQCN + "." + head.name + ".MessageType." + node.name + ")\n")
          writer.append("    headMessage.setExtension(" + protoFQCN + "." + node.name + "." + decapitalize(head.name) +", message.build())\n")
          writer.append("    headMessage\n")
          writer.append("  }\n")
        }
      }
    }
    writer.append("}\n")

    writer.toString
  }

  def generate(astFile: File, protoDir: File, javaSrc: File, scalaSrc: File) {
    val nodes = SimpleAstParser.getData(astFile)

    val heads = nodes.filter(_.parent == None)

    val scalaSubdir = new File(scalaSrc, astPackage.replace(".", "/"))
    protoDir.mkdirs
    javaSrc.mkdirs
    scalaSubdir.mkdirs

    // Protobuf generation
    val protoFile = new File(protoDir, "jribble.proto")
    printToFile(protoFile, getProto(nodes))
    val protocProcess = Process("protoc",
             List("--proto_path=" + protoDir.getCanonicalPath,
                  "--java_out=" + javaSrc.getCanonicalPath,
                  protoFile.getCanonicalPath))
    if ((protocProcess !) != 0) {
      println("Unable to generate java class from protobuf file.")
      sys.exit(1)
    }

    // Serializer/Deserializer generation
    printToFile(new File(scalaSubdir, "JribbleProtoWriter.scala"), getWriter(nodes))
    printToFile(new File(scalaSubdir, "JribbleProtoReader.scala"), getReader(nodes))
  }

  def main(args: Array[String]) {
    assert(args.length == 2)
    val astFile = new File(args(0))
    val scalaSrc = new File(args(1), "src/main/scala")
    val javaSrc = new File(args(1), "src/main/generated")
    val protoDir = new File(args(1), "src/main/protobuf")
    generate(astFile, protoDir, javaSrc, scalaSrc)
  }
}
