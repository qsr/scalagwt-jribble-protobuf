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
import scala.util.parsing.combinator.syntactical.StdTokenParsers
import scala.util.parsing.combinator.{PackratParsers, ImplicitConversions}

/**
 * Collection of jribble parsers.
 *
 * All String literals occuring in Parser definition are either Keywords or delimiters (also represented as Keyword
 * token).
 */
trait Parsers extends StdTokenParsers with PackratParsers with ImplicitConversions {

  type Tokens = Lexer
  val lexical = new Tokens

  lexical.reserved ++= Parsers.reserved

  lexical.delimiters ++= Parsers.delimiters

  import lexical.{Keyword, Identifier}

  def modifs(allowed: Set[String]): Parser[List[String]] =
    rep(accept("modifier", { case Keyword(x) if allowed contains x => x }))

  val classModifs: Parser[Set[String]] = {
    val allowed = Set("public", "final", "abstract")
    modifs(allowed).map(_.toSet)
  }

  val interfaceModifs: Parser[Set[String]] = {
    val allowed = Set("public", "abstract")
    modifs(allowed).map(_.toSet)
  }

  val classDef: Parser[ClassDef] = {
    def extendsDef: Parser[Ref] = "extends" ~> ref
    def optImplementsDef: Parser[List[Ref]] = opt("implements" ~> rep1sep(ref, ",")) ^^ (_ getOrElse Nil)
    (classModifs <~ "class") ~! ref ~! opt(extendsDef) ~! optImplementsDef ~! classBody ^^ ClassDef
  }

  val interfaceDef: Parser[InterfaceDef] = {
    def optExtendsDef: Parser[List[Ref]] = opt("extends" ~> rep1sep(ref, ",")) ^^ (_ getOrElse Nil)
    (interfaceModifs <~ "interface") ~! ref ~! optExtendsDef ~! interfaceBody ^^ InterfaceDef
  }

  def name: Parser[String] = accept("identifier", { case Identifier(x) => x})

  def ref: Parser[Ref] = ((rep1sep(name, "/") <~";") into {
    case x :: xs if x.startsWith("L") => success((x drop 1) :: xs)
    case _ => failure("Reference must start with 'L'")
  }) ^^ { xs =>
    val pkg = xs.init match {
      case Nil => None
      case xs => Some(Package(xs mkString "/"))
    }
    Ref(pkg, xs.last)
  }

  def classBody: Parser[List[ClassBodyElement]] = "{" ~> rep(constructor | methodDef | fieldDef) <~ "}"

  def interfaceBody: Parser[List[MethodDef]] = {
    val methodDef = this.methodDef into {
      case x : MethodDef if x.body.map(_.statements.isEmpty) getOrElse true => success(x)
      case x => failure("Method definition should have an empty body.")
    }
    "{" ~> rep(methodDef) <~ "}"
  }

  //todo (grek): introduce separate nodes for all primitive types
  def primitive: Parser[Primitive] = {
    // BOOLEAN | BYTE | CHAR | DOUBLE | FLOAT | INT | LONG | SHORT
    val allowed = List("Z", "B", "C", "D", "F", "I", "J", "S")
    accept("primitive type", { case Identifier(x) if allowed contains x => Primitive(x)}) <~ ";"
  }
  def array: Parser[Array] = (primitive | ref) ~ rep1(Keyword("[")) ^^ {
    case typ ~ xs => {
      def iterateTimes[T](f: T => T, v: T, n: Int): T = if (n <= 0) v else f(iterateTimes(f, v, n-1))
      Array(iterateTimes(Array: (Type => Type), typ, xs.length-1))
    }
  }
  def typ: Parser[Type] = array | primitive | ref

  def paramsDef: Parser[List[ParamDef]] = {
    val paramDef: Parser[ParamDef] = typ ~ name ^^ { case t ~ i => ParamDef(i, t) }
    val noParams: Parser[List[ParamDef]] = "(" ~ ")" ^^^ List()
    val atLeastOneParam = "(" ~> rep1sep(paramDef, ",") <~ ")"
    noParams | atLeastOneParam
  }

  def statements[T <: Statement](statement: Parser[T]): Parser[List[T]] =
    "{" ~> rep(statement) <~ "}"

  def block: Parser[Block] = statements(methodStatement) ^^ (Block(_))

  def methodBody: Parser[Block] = block

  def constructorCall(name: Parser[String]): Parser[ConstructorCall] = signature(name) ~! params ^^ ConstructorCall

  val constructorCallStatement: Parser[ConstructorCall] = constructorCall("super" | "this") <~ ";"

  def constructorBody: Parser[Block] = statements(constructorCallStatement | methodStatement) ^^ (Block(_))

  def constructor: Parser[Constructor] = {
    val allowed = Set("public", "private", "protected")
    (modifs(allowed).map(_.toSet) ~ "this" ~ paramsDef) ~! constructorBody ^^ Constructor
  }

  val methodModifs: Parser[Set[String]] = {
    val allowed = Set("public", "final", "static", "private", "protected", "abstract")
    modifs(allowed).map(_.toSet)
  }

  def methodDef: Parser[MethodDef] =
    (methodModifs ~ returnType ~ name ~ paramsDef) ~! (";" ^^^ None | methodBody ^^ (Some(_))) ^^ MethodDef

  val fieldModifs: Parser[Set[String]] = {
    val allowed = Set("public", "final", "static", "private", "protected")
    modifs(allowed).map(_.toSet)
  }

  def fieldDef: Parser[FieldDef] = fieldModifs ~ typ ~ name ~ opt("=" ~> expression) <~ ";" ^^ FieldDef

  def VoidType: Parser[Type] = (Identifier("V") ~! ";" ^^^ Void)

  def returnType: Parser[Type] =   VoidType | typ

  def varDef: Parser[VarDef] = typ ~ ident ~ opt("=" ~> expression) ^^ VarDef

  def methodStatement: Parser[Statement] =
    ifStatement | tryStatement | whileStatement | switchStatement | block |
    ((continueStatement | breakStatement | returnStatement | throwStatement | varDef | assignment | expression) <~ ";")

  def ifStatement: Parser[If] =
    ("if" ~> "(" ~> expression <~ ")") ~! block ~ opt("else" ~> block) ^^ If

  def tryStatement: Parser[Try] = {
    val catchParser: Parser[(Ref, String, Block)] = (("catch" ~> "(" ~> ref ~ name <~ ")") ~ block) ^^ {
      case ref ~ name ~ block => Tuple3(ref, name, block)
    }
    val finallyParser: Parser[Block] = "finally" ~> block
    (("try" ~> block) ~! (rep(catchParser) ~ opt(finallyParser) >> {
      case x@(catches ~ finalizer) if (!(catches.isEmpty && finalizer.isEmpty)) => success(x)
      case _ => failure("You must provide either at least one catch block or finally block.")
    })) ^^ {
      case block ~ (catches ~ finalizer) => Try(block, catches, finalizer)
    }
  }

  def whileStatement: Parser[While] = opt(name <~ ":") ~ ("while" ~> "(" ~> expression <~ ")") ~ block ^^ While

  def continueStatement: Parser[Continue] = "continue" ~> opt(name) ^^ Continue

  def breakStatement: Parser[Break] = "break" ~> opt(name) ^^ Break

  def switchStatement: Parser[Switch] = {
    def group: Parser[(Literal, Block)] = (literal <~ ":") ~ block ^^ { case label ~ block => (label, block) }
    def default: Parser[Block] = "default" ~> ":" ~> block
    ("switch" ~> "(" ~> expression <~ ")") ~ ("{" ~> rep(group) ~ opt(default) <~ "}") ^^ {
      case expression ~ (groups ~ default) => Switch(expression, groups, default)
    }
  }

  def returnStatement: Parser[Return] = "return" ~> opt(expression) ^^ Return

  def throwStatement: Parser[Throw] = "throw" ~> expression ^^ Throw

  val arrayInitializer: Parser[ArrayInitializer] =
    ("<" ~> typ <~ ">") ~ ("{" ~> repsep(expression, ",") <~ "}") ^^ ArrayInitializer

  val thisRef: Parser[Expression] = "this" ^^^ ThisRef
  val superRef: Parser[Expression] = "super" ^^^ SuperRef
  val varRef: Parser[VarRef] = ident ^^ (VarRef)

  val staticFieldRef: Parser[StaticFieldRef] = (ref <~ ".") ~ name ^^ StaticFieldRef
  val staticCall: Parser[StaticMethodCall] = (ref ~ ("." ~> methodSignature) ~! params) ^^ StaticMethodCall

  val clazzOf: Parser[ClassOf] = (VoidType | typ) <~ ("." ~ "class") ^^ ClassOf

  val newCall: Parser[NewCall] = ("new" ~> constructorCall("this")) ^^ NewCall

  val newRef: Parser[NewArray] = ("new" ~> (primitive | ref)) ~ rep1("[" ~> opt(expression) <~ "]") ^^ NewArray

  /**
   * Object that groups expressions that are interdependent.
   *
   * Parsing of expressions has been broken into several productions named "exprN"
   * where N-th production contains operators of N-th highest precedence.
   * In other words: expr1 contains operators with highest precedence, expr2 contains
   * operators with second highest precedence, etc.
   */
  object Expressions {
    lazy val methodCall: PackratParser[MethodCall] = expr1 ~ ("." ~> methodSignature) ~! params ^^ MethodCall
    lazy val instanceOf: PackratParser[InstanceOf] = expr1 ~
          ("." ~> "<" ~> "instanceof" ~> ">" ~> ("(" ~> typ <~ ")")) ^^ InstanceOf
    lazy val cast: PackratParser[Cast] = expr1 ~ ("." ~> "<" ~> "cast" ~> ">" ~> ("(" ~> typ <~ ")")) ^^ Cast
    lazy val fieldRef: PackratParser[FieldRef] = (expr1 <~ ".") ~ ("(" ~> typ <~ ")") ~ name ^^ FieldRef
    lazy val arrayRef: PackratParser[ArrayRef] = expr1 ~ ("[" ~> expression <~ "]") ^^ ArrayRef
    lazy val arrayLength: PackratParser[ArrayLength] = expr1 <~ ("." ~ "<" ~ Identifier("length") ~ ">") ^^ ArrayLength
    lazy val expr1: PackratParser[Expression] =
      (methodCall | instanceOf | cast | fieldRef | arrayRef | arrayLength | staticCall | staticFieldRef | clazzOf |
       thisRef | superRef | varRef | literal | arrayInitializer | ("(" ~> expr15 <~ ")"))
    lazy val expr2: PackratParser[Expression] = {
      lazy val not: PackratParser[Not] = "!" ~> expr2 ^^ Not
      lazy val minus: PackratParser[Expression] = "-" ~> expr2 ^^ UnaryMinus
      lazy val bitNot: PackratParser[BitNot] = "~" ~> expr2 ^^ BitNot
      not | minus | bitNot | expr1
    }

    lazy val expr3 = newCall | newRef | expr2

    /**
     * Takes a list of left-associative operators and turns them into alternative and
     * then adds higherPrec parser as another alternative.
     */
    private def leftBinaryOps(eqPrec: PackratParser[Expression], higherPrec: PackratParser[Expression])
                             (ops: (String, (Expression, Expression) => BinaryOp)*) = {
      val opsParsers = ops.toList map {
        case (symbol, f) => ((eqPrec <~ symbol) ~ higherPrec ^^ f): PackratParser[BinaryOp]
      }
      val opsAlternative = opsParsers.reduceLeft[PackratParser[BinaryOp]] { case (ps, p ) => ps | p }
      opsAlternative | higherPrec
    }
    lazy val expr4: PackratParser[Expression] = leftBinaryOps(expr4, expr3)("*" -> Multiply, "/" -> Divide)
    lazy val expr5: PackratParser[Expression] = leftBinaryOps(expr5, expr4)("+" -> Plus, "-" -> Minus, "%" -> Modulus)
    lazy val expr6: PackratParser[Expression] = leftBinaryOps(expr6, expr5)(
      "<<" -> BitLShift, ">>" -> BitRShift, ">>>" -> BitUnsignedRShift)
    lazy val expr7: PackratParser[Expression] = leftBinaryOps(expr7, expr6)(
      ">" -> Greater, ">=" -> GreaterOrEqual, "<" -> Lesser, "<=" -> LesserOrEqual)
    lazy val expr8: PackratParser[Expression] = leftBinaryOps(expr8, expr7)("==" -> Equal, "!=" -> NotEqual)
    lazy val expr9: PackratParser[Expression] = leftBinaryOps(expr9, expr8)("&" -> BitAnd)
    lazy val expr10: PackratParser[Expression] = leftBinaryOps(expr10, expr9)("^" -> BitXor)
    lazy val expr11: PackratParser[Expression] = leftBinaryOps(expr11, expr10)("|" -> BitOr)
    lazy val expr12: PackratParser[Expression] = leftBinaryOps(expr12, expr11)("&&" -> And)
    lazy val expr13: PackratParser[Expression] = leftBinaryOps(expr13, expr12)("||" -> Or)

    lazy val conditional: PackratParser[Conditional] = (expr1 <~ "?") ~! ("(" ~> typ <~ ")") ~! expr1 ~!
          (":" ~> expr1) ^^ Conditional
    lazy val expr14 = conditional | expr13
    lazy val expr15: PackratParser[Expression] = expr14
  }

  lazy val expression: PackratParser[Expression] = Expressions.expr15

  val methodSignature = signature(name)

  def signature(name: Parser[String]): Parser[Signature] = "(" ~> ((ref <~ "::") ~ name) ~!
          ("(" ~> (typ *) <~ ")") ~! returnType <~ ")" ^^ Signature

  val params: Parser[List[Expression]] = {
    val noParams: Parser[List[Expression]] = "(" ~ ")" ^^^ List()
    val atLeastOneParam: Parser[List[Expression]] = "(" ~> rep1sep(expression, ",") <~ ")"
    noParams | atLeastOneParam
  }

  def assignment: Parser[Assignment] = expression ~ ("=" ~> expression) ^^ Assignment

  //todo (grek): implement parsing of all literals, recheck what we already have and make it less hacky
  def literal: Parser[Literal] = {
    val bool: Parser[BooleanLiteral] = (Keyword("false") | Keyword("true")) ^^ {
      case Keyword(x) => BooleanLiteral(x != "false")
    }
    val char: Parser[CharLiteral] =
      accept("character literal", { case lexical.CharLit(x) => CharLiteral(x)})
    val int: Parser[IntLiteral] =
      accept("int literal", { case lexical.NumericLit(x) => IntLiteral(x.toInt) })
    val long: Parser[LongLiteral] =
      accept("long literal", { case lexical.NumericLit(x) if x endsWith "L" => LongLiteral(x.take(x.size-1).toLong) })
    val float: Parser[FloatLiteral] =
      accept("float literal", { case lexical.FloatingPointLit(x) if x endsWith "F" => 
        FloatLiteral(x.take(x.size-1).toFloat)
      })
    val double: Parser[DoubleLiteral] =
      accept("double literal", {
        case lexical.FloatingPointLit(x) if x endsWith "D" => DoubleLiteral(x.take(x.size-1).toDouble)
      })
    bool | char | (stringLit ^^ StringLiteral) | long | float | double | int | ("null" ^^^ NullLiteral)
  }

  /** Parse some prefix of reader `in' with parser `p' */
  def parse[T](p: Parser[T], in: scala.util.parsing.input.Reader[Char]): ParseResult[T] =
    phrase(p)(new lexical.Scanner(in))

  /** Parse some prefix of reader `in' with parser `p' */
  def parse[T](p: Parser[T], in: java.io.Reader): ParseResult[T] = {
    import scala.collection.immutable.PagedSeq
    import scala.util.parsing.input.PagedSeqReader
    parse(p, new PagedSeqReader(PagedSeq.fromReader(in)))
  }

  /** Parse some prefix of character sequence `in' with parser `p' */
  def parse[T](p: Parser[T], in: java.lang.CharSequence): ParseResult[T] =
    parse(p, new scala.util.parsing.input.CharSequenceReader(in))

}

object Parsers {
  val reserved = List("public", "final", "abstract", "class", "interface",
                      "extends", "implements", "static", "super", "this",
                      "new", "false", "true", "if", "else", "instanceof",
                      "cast", "private", "try", "catch", "finally", "while",
                      "continue", "break", "switch", "default", "return",
                      "protected", "throw", "null")
  val delimiters = List("{", "}", ":", ";", "/", "(", ")", "?", "[", "]", "::", ".", ",", "=",
                        "<", ">", "==", "!=", "+", "-", "*", "&&", "||", ">", ">=", "<", "<=",
                        "!", "<<", ">>", ">>>", "&", "^", "|", "%", "~")
}
