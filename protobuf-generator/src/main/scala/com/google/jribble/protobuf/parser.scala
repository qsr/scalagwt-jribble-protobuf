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

import java.io.File

import scala.util.parsing.combinator.RegexParsers

case class NodeDeclaration(id: String,
                           params: List[Parameter],
                           extension: Option[String],
                           abstracted: Boolean)

object SimpleAstParser extends RegexParsers {
  val ID = """[a-zA-Z]+""".r
  
  def ast = nodeDeclaration*

  def nodeDeclaration = opt("abstract ") ~ ID ~ opt(params) ~ opt(extension) ^^
      { case a~b~c~d =>
        NodeDeclaration(b,
                        c.getOrElse(Nil),
                        d.map(e => Some(e)).getOrElse(None),
                        a.map(_ => true).getOrElse(false))
      }

  def extension = "extends" ~> ID ^^ 
      { case a => a }

  def params = "(" ~> param ~ (("," ~> param)*) <~ ")" ^^
      { case a~b =>  a :: b }

  def param = (ID <~ ":") ~ typeDeclaration ^^
      { case a~b => Parameter(a, b) }

  def typeDeclaration: Parser[Type] = tupleType |
                                           optionType |
                                           setType |
                                           listType |
                                           simpleType

  def simpleType: Parser[Type] = ID ^^
      { case a => UndefinedType(a) }

  def tupleType: Parser[Type] = "(" ~> typeDeclaration ~ ((", " ~> typeDeclaration)*) <~ ")" ^^
      { case a~b => TupleType(a :: b) }

  def optionType: Parser[Type] = "Option[" ~> typeDeclaration <~ "]" ^^
      { case a => OptType(a) }

  def setType: Parser[Type] = "Set[" ~> typeDeclaration <~ "]" ^^
      { case a => SetType(a) }

  def listType: Parser[Type] = "List[" ~> typeDeclaration <~ "]" ^^
      { case a => ListType(a) }

  def defineType(m: Map[String, Node])(t: Type): Type = {
    t match {
      case UndefinedType(name) =>
        name match {
          case "String" => StringType
          case "Boolean" => BooleanType
          case "Char" => CharType
          case "Double" => DoubleType
          case "Float" => FloatType
          case "Int" => IntType
          case "Long" => LongType
          case value => {
            if(m.contains(value))
              RefType(m(value))
            else
              throw new RuntimeException("Unable to parse simple type: " + t)
          }
        }
      case _ => t.map(defineType(m))
    }
  }

  def getData(file: File): List[Node] = {
    val defs = ({
      for(line <- scala.io.Source.fromFile(file).getLines) yield { parseAll(nodeDeclaration, line) match {
        case Success(decl, _) => Some(decl)
        case _ => System.err.println("Unable to parse: " + line); None
      }}
    } toList) flatten
    val nodeMap = Map[String, Node]() ++ { for(nd <- defs) yield (nd.id, Node(nd.id, nd.abstracted)) }
    for(nd <- defs) {
      for(node <- nodeMap.get(nd.id);
          parent <- nd.extension;
          parentNode <- nodeMap.get(parent)) {
        parentNode.sons = node :: parentNode.sons
        node.parent = Some(parentNode)
        node.params = { for(param <- nd.params) yield param.map(defineType(nodeMap)) } toList
      }
    }
    nodeMap.values.toList.sortBy(_.name)
  }
}

