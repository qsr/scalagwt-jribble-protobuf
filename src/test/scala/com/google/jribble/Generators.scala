/*
 * Copyright 2010 Google Inc.
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
package com.google.jribble

import com.google.jribble.ast._
import org.scalacheck.{Arbitrary, Gen}

object Generators {

  private case class ExprDepth(x: Int) {
    def map(f: Int => Int) = ExprDepth(f(x))
  }
  private case class StmtDepth(x: Int) {
    def map(f: Int => Int) = StmtDepth(f(x))
  }

  //todo (grek): jribble identifiers (names) allow more characters than those generated by standard Gen.identifier
  def identifier = {
    def isValid(x: String) = !(Parsers.reserved contains x)
    for (v <- Gen.resize(7, Gen.identifier) if isValid(v)) yield v
  }

  def pkg: Gen[Package] = for(x <- identifier; xs <- Gen.resize(2, Gen.listOf(identifier))) yield
    Package(x + (xs.map("/" + _) mkString))

  def ref: Gen[Ref] = {
    implicit val arbPackage = Arbitrary(pkg)
    for(name <- identifier; p <- Arbitrary.arbitrary[Option[Package]]) yield Ref(p, name)
  }

  def primitive: Gen[Primitive] =
    for (name <- Gen.oneOf("Z", "B", "C", "D", "F", "I", "J", "S")) yield Primitive(name)

  def array: Gen[Array] = for (t <- typ) yield Array(t)

  def typ: Gen[Type] = Gen.frequency(2 -> ref, 4 -> primitive, 1 -> Gen.lzy(array))

  def paramsDef: Gen[List[ParamDef]] = {
    val paramDef: Gen[ParamDef] = for (n <- identifier; t <- typ) yield ParamDef(n, t)
    Gen.resize(4, Gen.listOf(paramDef))
  }

  def params(implicit depth: ExprDepth): Gen[List[Expression]] = Gen.resize(4, Gen.listOf(expression))

  //todo (grek): implement generation of all literals
  def literal: Gen[Literal] = {
    import Arbitrary._
    //todo (grek): once parsing of escaped is implemented we should switch to broader domain of strings
    val stringLiteral = for (x <- Gen.listOf(Gen.alphaNumChar)) yield StringLiteral(x mkString)
    //TODO(grek): figure out what's the biggest subset of Chars that is supported in jribble or implement
    //support for encoding all chars
    val charLiteral = for (x <- Gen.alphaNumChar) yield CharLiteral(x)
    val booleanLiteral = for (x <- arbitrary[Boolean]) yield BooleanLiteral(x)
    val intLiteral = for (x <- arbitrary[Int]) yield IntLiteral(x)
    val longLiteral = for (x <- arbitrary[Long]) yield LongLiteral(x)
    val floatLiteral = for (x <- arbitrary[Float]) yield FloatLiteral(x)
    val doubleLiteral = for (x <- arbitrary[Double]) yield DoubleLiteral(x)
    stringLiteral | charLiteral | booleanLiteral | intLiteral | longLiteral | floatLiteral | doubleLiteral | NullLiteral
  }
  def varRef = identifier.map(VarRef)
  def signature(name: Gen[String]): Gen[Signature] = for {
    on <- ref
    n <- name
    paramTypes <- Gen.listOf(typ)
    r <- returnType
  } yield Signature(on, n, paramTypes, r)

  val methodSignature = signature(identifier)
  
  def newCall(implicit depth: ExprDepth): Gen[NewCall] =  for (c <- thisConstructorCall) yield NewCall(c)

  def methodCall(implicit depth: ExprDepth): Gen[MethodCall] = for {
    on <- expression if isDotTarget(on)
    s <- methodSignature
    p <- params
  } yield MethodCall(on, s, p)

  def staticMethodCall(implicit depth: ExprDepth): Gen[StaticMethodCall] =
    for (c <- ref; s <- methodSignature; p <- params) yield StaticMethodCall(c, s, p)
  def conditional(implicit depth: ExprDepth): Gen[Conditional] = for {
    condition <- expression
    typ <- typ
    then <- expression
    elsee <- expression
  } yield Conditional(condition, typ, then, elsee)

  def instanceOf(implicit depth: ExprDepth): Gen[InstanceOf] =
    for (on <- expression if isDotTarget(on); t <- typ) yield InstanceOf(on, t)

  def cast(implicit depth: ExprDepth): Gen[Cast] =
    for (on <- expression if isDotTarget(on); t <- typ) yield Cast(on, t)

  def clazzOf: Gen[ClassOf] = for (t <- typ) yield ClassOf(t)

  def arrayInitializer(implicit depth: ExprDepth): Gen[ArrayInitializer] =
    for (t <- typ; elements <- Gen.resize(3,Gen.listOf(expression))) yield ArrayInitializer(t, elements)

  def fieldRef(implicit depth: ExprDepth): Gen[FieldRef] =
    for (on <- expression if isDotTarget(on); t <- typ; n <- identifier) yield FieldRef(on, t, n)

  def staticFieldRef: Gen[StaticFieldRef] = for (on <- ref; n <- identifier) yield StaticFieldRef(on, n)

  def binaryOp(implicit depth: ExprDepth): Gen[BinaryOp] = {
    val op = Gen.oneOf[(Expression, Expression) => BinaryOp](Multiply, Divide, Modulus, Minus, Plus, Equal, NotEqual,
      And, Or, Greater, GreaterOrEqual, Lesser, LesserOrEqual, BitLShift, BitRShift, BitUnsignedRShift, BitAnd,
      BitXor, BitOr)
    for (o <- op; lhs <- expression; rhs <- expression) yield o(lhs, rhs)
  }

  def unaryOp(implicit depth: ExprDepth): Gen[UnaryOp] = {
    val op = Gen.oneOf[Expression => UnaryOp](Not, UnaryMinus, BitNot)
    for (o <- op; e <- expression) yield o(e)
  }

  def arrayRef(implicit depth: ExprDepth): Gen[ArrayRef] =
    for (on <- expression; index <- expression) yield ArrayRef(on, index)

  def newArray(implicit depth: ExprDepth): Gen[NewArray] = for {
    t <- primitive | ref
    val exprOpt = Arbitrary.arbOption(Arbitrary(expression)).arbitrary
    dims <- Gen.resize(3, Gen.listOf(exprOpt)) if !dims.isEmpty
  } yield NewArray(t, dims)

  def arrayLength(implicit depth: ExprDepth): Gen[ArrayLength] = for (on <- expression) yield ArrayLength(on)

  def expression(implicit depth: ExprDepth): Gen[Expression] = {
    val nonRecursive = Gen.frequency((5, literal), (1, varRef), (1, Gen.value(ThisRef)), (1, staticFieldRef),
      (1, Gen.value(SuperRef)), (1, clazzOf))
    val newDepth = depth.map(_+1)
    val recursive = Gen.oneOf(Gen.lzy(newCall(newDepth)), Gen.lzy(methodCall(newDepth)),
      Gen.lzy(staticMethodCall(newDepth)), Gen.lzy(conditional(newDepth)), Gen.lzy(instanceOf(newDepth)),
      Gen.lzy(cast(newDepth)), Gen.lzy(arrayInitializer(newDepth)), Gen.lzy(fieldRef(newDepth)),
      Gen.lzy(binaryOp(newDepth)), Gen.lzy(arrayRef(newDepth)), Gen.lzy(newArray(newDepth)),
      Gen.lzy(unaryOp(newDepth)), Gen.lzy(arrayLength(newDepth)))

    Gen.frequency((3*(depth.x+1), nonRecursive), (1, recursive))
  }

  def varDef: Gen[VarDef] = for {
    t <- typ
    n <- identifier;
    v <- Arbitrary.arbOption(Arbitrary(expression(ExprDepth(0)))).arbitrary
  } yield VarDef(t, n, v)

  def assignment: Gen[Assignment] = {
    implicit val depth = ExprDepth(0)
    val lhs: Gen[Expression] = Gen.oneOf(varRef, staticFieldRef, fieldRef)
    for (l <- lhs; r <- expression) yield Assignment(l, r)
  }

  def ifStatement(implicit depth: StmtDepth): Gen[If] = for {
    condition <- expression(ExprDepth(0));
    then <- block;
    elsee <- Arbitrary.arbitrary[Option[Block]]
  } yield If(condition, then, elsee)

  def tryStatement(implicit depth: StmtDepth): Gen[Try] = for {
    b <- block
    val catchGen = for (r <- ref; n <- identifier; b <- block) yield (r, n, b)
    catches <- Gen.resize(2, Gen.listOf(catchGen))
    finalizer <- Arbitrary.arbitrary[Option[Block]]
    if (!(catches.isEmpty && finalizer.isEmpty))
  } yield Try(b, catches, finalizer)

  def whileStatement(implicit depth: StmtDepth): Gen[While] = for {
    label <- Arbitrary.arbOption(Arbitrary(identifier)).arbitrary
    condition <- expression(ExprDepth(0))
    b <- block
  } yield While(label, condition, b)

  def continueStatement: Gen[Continue] = for {
    label <- Arbitrary.arbOption(Arbitrary(identifier)).arbitrary
  } yield Continue(label)

  def breakStatement: Gen[Break] = for {
    label <- Arbitrary.arbOption(Arbitrary(identifier)).arbitrary
  } yield Break(label)

  def switchStatement(implicit depth: StmtDepth): Gen[Switch] = {
    def group: Gen[(Literal, Block)] = for (l <- literal; b <- block) yield (l, b)
    for {
      e <- expression(ExprDepth(0))
      gs <- Gen.resize(3, Gen.listOf(group))
      default <- Arbitrary.arbOption(Arbitrary(block)).arbitrary
    } yield Switch(e, gs, default)
  }

  def returnStatement: Gen[Return] = for {
    e <- Arbitrary.arbOption(Arbitrary(expression(ExprDepth(0)))).arbitrary
  } yield Return(e)

  def throwStatement: Gen[Throw] = for { e <- expression(ExprDepth(0)) } yield Throw(e)

  def methodStatement(implicit depth: StmtDepth): Gen[Statement] = {
    val nonRecursive = Gen.frequency(
      (15, Gen.oneOf(varDef, assignment, expression(ExprDepth(0)))),
      (1, continueStatement),
      (1, breakStatement),
      (1, returnStatement),
      (1, throwStatement))
    val newDepth = depth.map(_+1)
    val recursive = Gen.oneOf(Gen.lzy(ifStatement(newDepth)), Gen.lzy(tryStatement(newDepth)),
      Gen.lzy(whileStatement(newDepth)), Gen.lzy(switchStatement(newDepth)), Gen.lzy(block(newDepth)))
    Gen.frequency((3*(depth.x+1), nonRecursive), (1, recursive))
  }
  def methodStatements(implicit depth: StmtDepth): Gen[List[Statement]] =
    Gen.resize(3, Gen.listOf(methodStatement))

  def superConstructorCall: Gen[ConstructorCall] =
    for (s <- signature("super"); p <- params(ExprDepth(0))) yield ConstructorCall(s.copy(returnType = Void), p)
  def thisConstructorCall(implicit depth: ExprDepth): Gen[ConstructorCall] =
    for (s <- signature("this"); p <- params) yield ConstructorCall(s.copy(returnType = Void), p)
  //we shuffle the list because in jribble there is no requirement that super constructor call is
  def constructorBody: Gen[Block] = for {
      s <- Gen.resize(1, Gen.listOf(superConstructorCall | thisConstructorCall(ExprDepth(0))))
      ss <- methodStatements(StmtDepth(0))
    } yield Block(scala.util.Random.shuffle(s ::: ss))
  def constructor: Gen[Constructor] = {
    val modifs = Gen.listOf(Gen.oneOf("private", "protected", "public")).map(_.toSet).filter(!_.isEmpty)
    for (m <- modifs; p <- paramsDef; b <- constructorBody) yield Constructor(m, "this", p, b)
  }

  def block(implicit depth: StmtDepth): Gen[Block] = methodStatements map (Block(_))
  def methodBody: Gen[Block] = block(StmtDepth(0))
  def returnType = typ | Void
  def methodModifiers: Gen[Set[String]] = {
    val modif = Gen.oneOf("public", "final", "static", "private", "protected", "abstract")
    Gen.resize(3, Gen.listOf(modif)).map(_.toSet)
  }
  def methodDef: Gen[MethodDef] = for {
    m <- methodModifiers
    t <- returnType
    n <- identifier
    p <- paramsDef
    b <- Arbitrary.arbOption(Arbitrary(methodBody)).arbitrary
  } yield MethodDef(m, t, n, p, b)

  def fieldDef: Gen[FieldDef] = {
    def modifiers: Gen[Set[String]] = {
      val modif = Gen.oneOf("public", "final", "static", "private", "protected")
      Gen.resize(3, Gen.listOf(modif)).map(_.toSet)
    }
    import Arbitrary._
    for (m <- modifiers; t <- typ; n <- identifier; v <- arbitrary[Option[Expression]]) yield FieldDef(m, t, n, v)
  }

  def classModifiers: Gen[Set[String]] = {
    val modif = Gen.oneOf("public", "final", "abstract")
    Gen.resize(2, Gen.listOf(modif)).map(_.toSet)
  }

  def interfaceModifiers: Gen[Set[String]] = {
    val modif = Gen.oneOf("public", "abstract")
    Gen.resize(2, Gen.listOf(modif)).map(_.toSet)
  }

  def classBody: Gen[List[ClassBodyElement]] = for {
    cs <- Gen.resize(3, Gen.listOf(constructor))
    ms <- Gen.resize(5, Gen.listOf(methodDef))
    fs <- Gen.resize(3, Gen.listOf(fieldDef))
  } yield cs ++ ms ++ fs

  def interfaceBody: Gen[List[MethodDef]] = {
    val emptyMethodDef = methodDef.filter(_.body.map(_.statements.isEmpty) getOrElse false)
    for (ms <- Gen.resize(5, Gen.listOf(emptyMethodDef))) yield ms
  }

  def classDef: Gen[ClassDef] = for {
    m <- classModifiers
    n <- ref
    e <- Arbitrary.arbitrary[Option[Ref]]
    i <- Gen.resize(3, Gen.listOf(ref))
    b <- classBody
  } yield ClassDef(m, n, e, i, b)

  def interfaceDef: Gen[InterfaceDef] = for {
    m <- interfaceModifiers
    n <- ref
    e <- Gen.resize(3, Gen.listOf(ref))
    b <- interfaceBody
  } yield InterfaceDef(m, n, e, b)

  implicit val arbRef = Arbitrary(ref)
  implicit val arbPackage = Arbitrary(pkg)
  implicit val arbPrimitive = Arbitrary(primitive)
  implicit val arbArray = Arbitrary(array)
  implicit val arbType = Arbitrary(typ)
  implicit val arbParamsDef = Arbitrary(paramsDef)
  implicit val arbLiteral = Arbitrary(literal)
  implicit val arbMethodSignature = Arbitrary(methodSignature)
  implicit val arbNewCall = Arbitrary(newCall(ExprDepth(0)))
  implicit val arbMethodCall = Arbitrary(methodCall(ExprDepth(0)))
  implicit val arbStaticMethodCall = Arbitrary(staticMethodCall(ExprDepth(0)))
  implicit val arbConditional = Arbitrary(conditional(ExprDepth(0)))
  implicit val arbInstanceOf = Arbitrary(instanceOf(ExprDepth(0)))
  implicit val arbCast = Arbitrary(cast(ExprDepth(0)))
  implicit val arbArrayInitializer = Arbitrary(arrayInitializer(ExprDepth(0)))
  implicit val arbFieldRef = Arbitrary(fieldRef(ExprDepth(0)))
  implicit val arbStaticFieldRef = Arbitrary(staticFieldRef)
  implicit val arbArrayRef = Arbitrary(arrayRef(ExprDepth(0)))
  implicit val arbExpression = Arbitrary(expression(ExprDepth(0)))
  implicit val arbVarDef = Arbitrary(varDef)
  implicit val arbAssignment = Arbitrary(assignment)
  implicit val arbIf = Arbitrary(ifStatement(StmtDepth(0)))
  implicit val arbTry = Arbitrary(tryStatement(StmtDepth(0)))
  implicit val arbWhile = Arbitrary(whileStatement(StmtDepth(0)))
  implicit val arbContinue = Arbitrary(continueStatement)
  implicit val arbBreak = Arbitrary(breakStatement)
  implicit val arbSwitch = Arbitrary(switchStatement(StmtDepth(0)))
  implicit val arbReturn = Arbitrary(returnStatement)
  implicit val arbThrow = Arbitrary(throwStatement)
  implicit val arbMethodStatement = Arbitrary(methodStatement(StmtDepth(0)))
  implicit val arbMethodBody = Arbitrary(methodBody) 
  implicit val arbConstructor = Arbitrary(constructor)
  implicit val arbMethodDef = Arbitrary(methodDef)
  implicit val arbFieldDef = Arbitrary(fieldDef)
  implicit val arbClassDef = Arbitrary(classDef)
  implicit val arbInterfaceDef = Arbitrary(interfaceDef)

  private def isDotTarget(x: Expression) = x match {
    case UnaryMinus(_: Primitive) => false
    case _: Primitive => false
    case _ => true
  }
}
