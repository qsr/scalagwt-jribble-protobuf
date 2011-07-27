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

abstract class Type {
  def map(f: Type => Type): Type
}

case class UndefinedType(name: String) extends Type {
  def map(f: Type => Type) = this
}

abstract class SimpleType extends Type {
  def protoBufType: String
  def packedString: String
  def map(f: Type => Type) = this
}
object SimpleType {
  def unapply(simpleType: SimpleType) = Some(simpleType.protoBufType)
}
abstract class PrimitiveType(val protoBufType: String) extends SimpleType {
  val packedString = " [packed=true]"
  val castString = ""
}
object PrimitiveType {
  def unapply(primitiveType: PrimitiveType) = Some(primitiveType.protoBufType)
}
case object StringType extends PrimitiveType("string") {
  override val packedString = ""
}
case object BooleanType extends PrimitiveType("bool")
case object CharType extends PrimitiveType("int32") {
  override val castString = ".asInstanceOf[Char]"
}
case object DoubleType extends PrimitiveType("double")
case object FloatType extends PrimitiveType("float")
case object IntType extends PrimitiveType("int32")
case object LongType extends PrimitiveType("int64")
case class RefType(node: Node) extends SimpleType {
  lazy val protoBufType = node.head.name
  val packedString = ""
}

case class TupleType(types: List[Type]) extends Type {
  def map(f: Type => Type) = TupleType(types.map(f))
}
case class OptType(typ: Type) extends Type {
  def map(f: Type => Type) = OptType(f(typ))
}

trait CollectionType extends Type {
  def typ: Type
  def toConcreteMethod(elementsType: String): String
}

object CollectionType {
  def unapply(collectionType: CollectionType) = Some(collectionType.typ)
}

case class ListType(typ: Type) extends CollectionType {
  def map(f: Type => Type) = ListType(f(typ))
  def toConcreteMethod(elementsType: String) = "toList"
}
case class SetType(typ: Type) extends CollectionType {
  def map(f: Type => Type) = SetType(f(typ))
  def toConcreteMethod(elementsType: String) = "toSet[" + elementsType + "]"
}

case class Parameter(name: String, typ: Type) {
  def map(f: Type => Type) = Parameter(name, f(typ))
}

case class Node(name: String) {
  var sons: List[Node] = Nil
  var parent: Option[Node] = None
  var params: List[Parameter] = Nil
  
  lazy val level: Int = parent match {
    case None => 1
    case Some(node) => 1 + node.level
  }

  lazy val head: Node = parent match {
    case None => this
    case Some(node) => node.head
  }
  def map(f: Type => Type): Node = {
    val result = Node(name)
    result.sons = sons.map(_.map(f))
    result.parent = parent
    result.params = params.map(_.map(f))
    result
  }

}
