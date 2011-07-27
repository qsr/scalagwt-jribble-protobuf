// Generated file.  DO NOT EDIT!.
package com.google.jribble.ast

object JribbleProtoReader {

  val registry = com.google.protobuf.ExtensionRegistry.newInstance()
  JribbleProtos.registerAllExtensions(registry)

  def readASTMessage(message: com.google.protobuf.ByteString): com.google.jribble.ast.AST = {
   readASTMessage(JribbleProtos.AST.parseFrom(message, registry))
  }
  def readASTMessage(message: scala.Array[Byte]): com.google.jribble.ast.AST = {
   readASTMessage(JribbleProtos.AST.parseFrom(message, registry))
  }
  def readASTMessage(message: java.io.InputStream): com.google.jribble.ast.AST = {
   readASTMessage(JribbleProtos.AST.parseFrom(message, registry))
  }
  def readASTMessage(message: com.google.protobuf.CodedInputStream): com.google.jribble.ast.AST = {
   readASTMessage(JribbleProtos.AST.parseFrom(message, registry))
  }
  def readASTMessage(message: com.google.jribble.ast.JribbleProtos.AST): com.google.jribble.ast.AST = {
    message.getType() match {
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.And =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.And.aST)
        val lhs = readASTMessage(finalMessage.getLhs()).asInstanceOf[com.google.jribble.ast.Expression]
        val rhs = readASTMessage(finalMessage.getRhs()).asInstanceOf[com.google.jribble.ast.Expression]
        And(lhs, rhs)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.Array =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.Array.aST)
        val typ = readASTMessage(finalMessage.getTyp()).asInstanceOf[com.google.jribble.ast.Type]
        Array(typ)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.ArrayInitializer =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.ArrayInitializer.aST)
        val typ = readASTMessage(finalMessage.getTyp()).asInstanceOf[com.google.jribble.ast.Type]
        val elements = for(index <- (0 until finalMessage.getElementsCount()).toList) yield readASTMessage(finalMessage.getElements(index)).asInstanceOf[com.google.jribble.ast.Expression]
        ArrayInitializer(typ, elements)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.ArrayLength =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.ArrayLength.aST)
        val on = readASTMessage(finalMessage.getOn()).asInstanceOf[com.google.jribble.ast.Expression]
        ArrayLength(on)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.ArrayRef =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.ArrayRef.aST)
        val on = readASTMessage(finalMessage.getOn()).asInstanceOf[com.google.jribble.ast.Expression]
        val index = readASTMessage(finalMessage.getIndex()).asInstanceOf[com.google.jribble.ast.Expression]
        ArrayRef(on, index)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.Assignment =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.Assignment.aST)
        val lhs = readASTMessage(finalMessage.getLhs()).asInstanceOf[com.google.jribble.ast.Expression]
        val rhs = readASTMessage(finalMessage.getRhs()).asInstanceOf[com.google.jribble.ast.Expression]
        Assignment(lhs, rhs)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.BitAnd =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.BitAnd.aST)
        val lhs = readASTMessage(finalMessage.getLhs()).asInstanceOf[com.google.jribble.ast.Expression]
        val rhs = readASTMessage(finalMessage.getRhs()).asInstanceOf[com.google.jribble.ast.Expression]
        BitAnd(lhs, rhs)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.BitLShift =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.BitLShift.aST)
        val lhs = readASTMessage(finalMessage.getLhs()).asInstanceOf[com.google.jribble.ast.Expression]
        val rhs = readASTMessage(finalMessage.getRhs()).asInstanceOf[com.google.jribble.ast.Expression]
        BitLShift(lhs, rhs)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.BitNot =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.BitNot.aST)
        val expression = readASTMessage(finalMessage.getExpression()).asInstanceOf[com.google.jribble.ast.Expression]
        BitNot(expression)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.BitOr =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.BitOr.aST)
        val lhs = readASTMessage(finalMessage.getLhs()).asInstanceOf[com.google.jribble.ast.Expression]
        val rhs = readASTMessage(finalMessage.getRhs()).asInstanceOf[com.google.jribble.ast.Expression]
        BitOr(lhs, rhs)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.BitRShift =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.BitRShift.aST)
        val lhs = readASTMessage(finalMessage.getLhs()).asInstanceOf[com.google.jribble.ast.Expression]
        val rhs = readASTMessage(finalMessage.getRhs()).asInstanceOf[com.google.jribble.ast.Expression]
        BitRShift(lhs, rhs)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.BitUnsignedRShift =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.BitUnsignedRShift.aST)
        val lhs = readASTMessage(finalMessage.getLhs()).asInstanceOf[com.google.jribble.ast.Expression]
        val rhs = readASTMessage(finalMessage.getRhs()).asInstanceOf[com.google.jribble.ast.Expression]
        BitUnsignedRShift(lhs, rhs)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.BitXor =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.BitXor.aST)
        val lhs = readASTMessage(finalMessage.getLhs()).asInstanceOf[com.google.jribble.ast.Expression]
        val rhs = readASTMessage(finalMessage.getRhs()).asInstanceOf[com.google.jribble.ast.Expression]
        BitXor(lhs, rhs)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.Block =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.Block.aST)
        val statements = for(index <- (0 until finalMessage.getStatementsCount()).toList) yield readASTMessage(finalMessage.getStatements(index)).asInstanceOf[com.google.jribble.ast.Statement]
        Block(statements)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.BooleanLiteral =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.BooleanLiteral.aST)
        val v = finalMessage.getV()
        BooleanLiteral(v)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.Break =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.Break.aST)
        val label = if(finalMessage.hasLabel()) Some(finalMessage.getLabel()) else None
        Break(label)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.Cast =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.Cast.aST)
        val on = readASTMessage(finalMessage.getOn()).asInstanceOf[com.google.jribble.ast.Expression]
        val typ = readASTMessage(finalMessage.getTyp()).asInstanceOf[com.google.jribble.ast.Type]
        Cast(on, typ)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.CharLiteral =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.CharLiteral.aST)
        val v = finalMessage.getV().asInstanceOf[Char]
        CharLiteral(v)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.ClassOf =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.ClassOf.aST)
        val typ = readASTMessage(finalMessage.getTyp()).asInstanceOf[com.google.jribble.ast.Type]
        ClassOf(typ)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.Conditional =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.Conditional.aST)
        val condition = readASTMessage(finalMessage.getCondition()).asInstanceOf[com.google.jribble.ast.Expression]
        val typ = readASTMessage(finalMessage.getTyp()).asInstanceOf[com.google.jribble.ast.Type]
        val then = readASTMessage(finalMessage.getThen()).asInstanceOf[com.google.jribble.ast.Expression]
        val elsee = readASTMessage(finalMessage.getElsee()).asInstanceOf[com.google.jribble.ast.Expression]
        Conditional(condition, typ, then, elsee)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.Constructor =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.Constructor.aST)
        val modifs = for(index <- (0 until finalMessage.getModifsCount()).toSet[Int]) yield finalMessage.getModifs(index)
        val name = finalMessage.getName()
        val params = for(index <- (0 until finalMessage.getParamsCount()).toList) yield readASTMessage(finalMessage.getParams(index)).asInstanceOf[com.google.jribble.ast.ParamDef]
        val body = readASTMessage(finalMessage.getBody()).asInstanceOf[com.google.jribble.ast.Block]
        Constructor(modifs, name, params, body)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.ConstructorCall =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.ConstructorCall.aST)
        val signature = readASTMessage(finalMessage.getSignature()).asInstanceOf[com.google.jribble.ast.Signature]
        val params = for(index <- (0 until finalMessage.getParamsCount()).toList) yield readASTMessage(finalMessage.getParams(index)).asInstanceOf[com.google.jribble.ast.Expression]
        ConstructorCall(signature, params)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.Continue =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.Continue.aST)
        val label = if(finalMessage.hasLabel()) Some(finalMessage.getLabel()) else None
        Continue(label)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.Divide =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.Divide.aST)
        val lhs = readASTMessage(finalMessage.getLhs()).asInstanceOf[com.google.jribble.ast.Expression]
        val rhs = readASTMessage(finalMessage.getRhs()).asInstanceOf[com.google.jribble.ast.Expression]
        Divide(lhs, rhs)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.DoubleLiteral =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.DoubleLiteral.aST)
        val v = finalMessage.getV()
        DoubleLiteral(v)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.Equal =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.Equal.aST)
        val lhs = readASTMessage(finalMessage.getLhs()).asInstanceOf[com.google.jribble.ast.Expression]
        val rhs = readASTMessage(finalMessage.getRhs()).asInstanceOf[com.google.jribble.ast.Expression]
        Equal(lhs, rhs)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.FieldDef =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.FieldDef.aST)
        val modifs = for(index <- (0 until finalMessage.getModifsCount()).toSet[Int]) yield finalMessage.getModifs(index)
        val typ = readASTMessage(finalMessage.getTyp()).asInstanceOf[com.google.jribble.ast.Type]
        val name = finalMessage.getName()
        val value = if(finalMessage.hasValue()) Some(readASTMessage(finalMessage.getValue()).asInstanceOf[com.google.jribble.ast.Expression]) else None
        FieldDef(modifs, typ, name, value)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.FieldRef =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.FieldRef.aST)
        val on = readASTMessage(finalMessage.getOn()).asInstanceOf[com.google.jribble.ast.Expression]
        val onType = readASTMessage(finalMessage.getOnType()).asInstanceOf[com.google.jribble.ast.Type]
        val name = finalMessage.getName()
        FieldRef(on, onType, name)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.FloatLiteral =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.FloatLiteral.aST)
        val v = finalMessage.getV()
        FloatLiteral(v)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.Greater =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.Greater.aST)
        val lhs = readASTMessage(finalMessage.getLhs()).asInstanceOf[com.google.jribble.ast.Expression]
        val rhs = readASTMessage(finalMessage.getRhs()).asInstanceOf[com.google.jribble.ast.Expression]
        Greater(lhs, rhs)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.GreaterOrEqual =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.GreaterOrEqual.aST)
        val lhs = readASTMessage(finalMessage.getLhs()).asInstanceOf[com.google.jribble.ast.Expression]
        val rhs = readASTMessage(finalMessage.getRhs()).asInstanceOf[com.google.jribble.ast.Expression]
        GreaterOrEqual(lhs, rhs)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.If =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.If.aST)
        val condition = readASTMessage(finalMessage.getCondition()).asInstanceOf[com.google.jribble.ast.Expression]
        val then = readASTMessage(finalMessage.getThen()).asInstanceOf[com.google.jribble.ast.Block]
        val elsee = if(finalMessage.hasElsee()) Some(readASTMessage(finalMessage.getElsee()).asInstanceOf[com.google.jribble.ast.Block]) else None
        If(condition, then, elsee)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.InstanceOf =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.InstanceOf.aST)
        val on = readASTMessage(finalMessage.getOn()).asInstanceOf[com.google.jribble.ast.Expression]
        val typ = readASTMessage(finalMessage.getTyp()).asInstanceOf[com.google.jribble.ast.Type]
        InstanceOf(on, typ)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.IntLiteral =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.IntLiteral.aST)
        val v = finalMessage.getV()
        IntLiteral(v)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.Lesser =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.Lesser.aST)
        val lhs = readASTMessage(finalMessage.getLhs()).asInstanceOf[com.google.jribble.ast.Expression]
        val rhs = readASTMessage(finalMessage.getRhs()).asInstanceOf[com.google.jribble.ast.Expression]
        Lesser(lhs, rhs)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.LesserOrEqual =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.LesserOrEqual.aST)
        val lhs = readASTMessage(finalMessage.getLhs()).asInstanceOf[com.google.jribble.ast.Expression]
        val rhs = readASTMessage(finalMessage.getRhs()).asInstanceOf[com.google.jribble.ast.Expression]
        LesserOrEqual(lhs, rhs)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.LongLiteral =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.LongLiteral.aST)
        val v = finalMessage.getV()
        LongLiteral(v)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.MethodCall =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.MethodCall.aST)
        val on = readASTMessage(finalMessage.getOn()).asInstanceOf[com.google.jribble.ast.Expression]
        val signature = readASTMessage(finalMessage.getSignature()).asInstanceOf[com.google.jribble.ast.Signature]
        val params = for(index <- (0 until finalMessage.getParamsCount()).toList) yield readASTMessage(finalMessage.getParams(index)).asInstanceOf[com.google.jribble.ast.Expression]
        MethodCall(on, signature, params)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.MethodDef =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.MethodDef.aST)
        val modifs = for(index <- (0 until finalMessage.getModifsCount()).toSet[Int]) yield finalMessage.getModifs(index)
        val returnType = readASTMessage(finalMessage.getReturnType()).asInstanceOf[com.google.jribble.ast.Type]
        val name = finalMessage.getName()
        val params = for(index <- (0 until finalMessage.getParamsCount()).toList) yield readASTMessage(finalMessage.getParams(index)).asInstanceOf[com.google.jribble.ast.ParamDef]
        val body = if(finalMessage.hasBody()) Some(readASTMessage(finalMessage.getBody()).asInstanceOf[com.google.jribble.ast.Block]) else None
        MethodDef(modifs, returnType, name, params, body)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.Minus =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.Minus.aST)
        val lhs = readASTMessage(finalMessage.getLhs()).asInstanceOf[com.google.jribble.ast.Expression]
        val rhs = readASTMessage(finalMessage.getRhs()).asInstanceOf[com.google.jribble.ast.Expression]
        Minus(lhs, rhs)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.Modulus =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.Modulus.aST)
        val lhs = readASTMessage(finalMessage.getLhs()).asInstanceOf[com.google.jribble.ast.Expression]
        val rhs = readASTMessage(finalMessage.getRhs()).asInstanceOf[com.google.jribble.ast.Expression]
        Modulus(lhs, rhs)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.Multiply =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.Multiply.aST)
        val lhs = readASTMessage(finalMessage.getLhs()).asInstanceOf[com.google.jribble.ast.Expression]
        val rhs = readASTMessage(finalMessage.getRhs()).asInstanceOf[com.google.jribble.ast.Expression]
        Multiply(lhs, rhs)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.NewArray =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.NewArray.aST)
        val typ = readASTMessage(finalMessage.getTyp()).asInstanceOf[com.google.jribble.ast.Type]
        val dims = for(index <- (0 until finalMessage.getDimsCount()).toList) yield if(finalMessage.getDims(index).hasT()) Some(readASTMessage(finalMessage.getDims(index).getT).asInstanceOf[com.google.jribble.ast.Expression]) else None
        NewArray(typ, dims)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.NewCall =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.NewCall.aST)
        val constructor = readASTMessage(finalMessage.getConstructor()).asInstanceOf[com.google.jribble.ast.ConstructorCall]
        NewCall(constructor)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.Not =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.Not.aST)
        val expression = readASTMessage(finalMessage.getExpression()).asInstanceOf[com.google.jribble.ast.Expression]
        Not(expression)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.NotEqual =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.NotEqual.aST)
        val lhs = readASTMessage(finalMessage.getLhs()).asInstanceOf[com.google.jribble.ast.Expression]
        val rhs = readASTMessage(finalMessage.getRhs()).asInstanceOf[com.google.jribble.ast.Expression]
        NotEqual(lhs, rhs)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.NullLiteral =>
        com.google.jribble.ast.NullLiteral
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.Or =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.Or.aST)
        val lhs = readASTMessage(finalMessage.getLhs()).asInstanceOf[com.google.jribble.ast.Expression]
        val rhs = readASTMessage(finalMessage.getRhs()).asInstanceOf[com.google.jribble.ast.Expression]
        Or(lhs, rhs)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.Package =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.Package.aST)
        val name = finalMessage.getName()
        Package(name)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.ParamDef =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.ParamDef.aST)
        val name = finalMessage.getName()
        val typ = readASTMessage(finalMessage.getTyp()).asInstanceOf[com.google.jribble.ast.Type]
        ParamDef(name, typ)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.Plus =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.Plus.aST)
        val lhs = readASTMessage(finalMessage.getLhs()).asInstanceOf[com.google.jribble.ast.Expression]
        val rhs = readASTMessage(finalMessage.getRhs()).asInstanceOf[com.google.jribble.ast.Expression]
        Plus(lhs, rhs)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.Primitive =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.Primitive.aST)
        val name = finalMessage.getName()
        Primitive(name)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.Ref =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.Ref.aST)
        val pkg = if(finalMessage.hasPkg()) Some(readASTMessage(finalMessage.getPkg()).asInstanceOf[com.google.jribble.ast.Package]) else None
        val name = finalMessage.getName()
        Ref(pkg, name)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.Return =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.Return.aST)
        val expression = if(finalMessage.hasExpression()) Some(readASTMessage(finalMessage.getExpression()).asInstanceOf[com.google.jribble.ast.Expression]) else None
        Return(expression)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.Signature =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.Signature.aST)
        val on = readASTMessage(finalMessage.getOn()).asInstanceOf[com.google.jribble.ast.Ref]
        val name = finalMessage.getName()
        val paramTypes = for(index <- (0 until finalMessage.getParamTypesCount()).toList) yield readASTMessage(finalMessage.getParamTypes(index)).asInstanceOf[com.google.jribble.ast.Type]
        val returnType = readASTMessage(finalMessage.getReturnType()).asInstanceOf[com.google.jribble.ast.Type]
        Signature(on, name, paramTypes, returnType)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.StaticFieldRef =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.StaticFieldRef.aST)
        val on = readASTMessage(finalMessage.getOn()).asInstanceOf[com.google.jribble.ast.Ref]
        val name = finalMessage.getName()
        StaticFieldRef(on, name)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.StaticMethodCall =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.StaticMethodCall.aST)
        val classRef = readASTMessage(finalMessage.getClassRef()).asInstanceOf[com.google.jribble.ast.Ref]
        val signature = readASTMessage(finalMessage.getSignature()).asInstanceOf[com.google.jribble.ast.Signature]
        val params = for(index <- (0 until finalMessage.getParamsCount()).toList) yield readASTMessage(finalMessage.getParams(index)).asInstanceOf[com.google.jribble.ast.Expression]
        StaticMethodCall(classRef, signature, params)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.StringLiteral =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.StringLiteral.aST)
        val v = finalMessage.getV()
        StringLiteral(v)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.SuperRef =>
        com.google.jribble.ast.SuperRef
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.Switch =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.Switch.aST)
        val expression = readASTMessage(finalMessage.getExpression()).asInstanceOf[com.google.jribble.ast.Expression]
        val groups = for(index <- (0 until finalMessage.getGroupsCount()).toList) yield (readASTMessage(finalMessage.getGroups(index).getT0()).asInstanceOf[com.google.jribble.ast.Literal], readASTMessage(finalMessage.getGroups(index).getT1()).asInstanceOf[com.google.jribble.ast.Block])
        val default = if(finalMessage.hasDefault()) Some(readASTMessage(finalMessage.getDefault()).asInstanceOf[com.google.jribble.ast.Block]) else None
        Switch(expression, groups, default)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.ThisRef =>
        com.google.jribble.ast.ThisRef
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.Throw =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.Throw.aST)
        val expression = readASTMessage(finalMessage.getExpression()).asInstanceOf[com.google.jribble.ast.Expression]
        Throw(expression)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.Try =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.Try.aST)
        val block = readASTMessage(finalMessage.getBlock()).asInstanceOf[com.google.jribble.ast.Block]
        val catches = for(index <- (0 until finalMessage.getCatchesCount()).toList) yield (readASTMessage(finalMessage.getCatches(index).getT0()).asInstanceOf[com.google.jribble.ast.Ref], finalMessage.getCatches(index).getT1(), readASTMessage(finalMessage.getCatches(index).getT2()).asInstanceOf[com.google.jribble.ast.Block])
        val finalizer = if(finalMessage.hasFinalizer()) Some(readASTMessage(finalMessage.getFinalizer()).asInstanceOf[com.google.jribble.ast.Block]) else None
        Try(block, catches, finalizer)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.UnaryMinus =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.UnaryMinus.aST)
        val expression = readASTMessage(finalMessage.getExpression()).asInstanceOf[com.google.jribble.ast.Expression]
        UnaryMinus(expression)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.VarDef =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.VarDef.aST)
        val typ = readASTMessage(finalMessage.getTyp()).asInstanceOf[com.google.jribble.ast.Type]
        val name = finalMessage.getName()
        val value = if(finalMessage.hasValue()) Some(readASTMessage(finalMessage.getValue()).asInstanceOf[com.google.jribble.ast.Expression]) else None
        VarDef(typ, name, value)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.VarRef =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.VarRef.aST)
        val name = finalMessage.getName()
        VarRef(name)
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.Void =>
        com.google.jribble.ast.Void
      case com.google.jribble.ast.JribbleProtos.AST.MessageType.While =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.While.aST)
        val label = if(finalMessage.hasLabel()) Some(finalMessage.getLabel()) else None
        val condition = readASTMessage(finalMessage.getCondition()).asInstanceOf[com.google.jribble.ast.Expression]
        val block = readASTMessage(finalMessage.getBlock()).asInstanceOf[com.google.jribble.ast.Block]
        While(label, condition, block)
    }
  }
  def readDeclaredTypeMessage(message: com.google.protobuf.ByteString): com.google.jribble.ast.DeclaredType = {
   readDeclaredTypeMessage(JribbleProtos.DeclaredType.parseFrom(message, registry))
  }
  def readDeclaredTypeMessage(message: scala.Array[Byte]): com.google.jribble.ast.DeclaredType = {
   readDeclaredTypeMessage(JribbleProtos.DeclaredType.parseFrom(message, registry))
  }
  def readDeclaredTypeMessage(message: java.io.InputStream): com.google.jribble.ast.DeclaredType = {
   readDeclaredTypeMessage(JribbleProtos.DeclaredType.parseFrom(message, registry))
  }
  def readDeclaredTypeMessage(message: com.google.protobuf.CodedInputStream): com.google.jribble.ast.DeclaredType = {
   readDeclaredTypeMessage(JribbleProtos.DeclaredType.parseFrom(message, registry))
  }
  def readDeclaredTypeMessage(message: com.google.jribble.ast.JribbleProtos.DeclaredType): com.google.jribble.ast.DeclaredType = {
    message.getType() match {
      case com.google.jribble.ast.JribbleProtos.DeclaredType.MessageType.ClassDef =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.ClassDef.declaredType)
        val modifs = for(index <- (0 until finalMessage.getModifsCount()).toSet[Int]) yield finalMessage.getModifs(index)
        val name = readASTMessage(finalMessage.getName()).asInstanceOf[com.google.jribble.ast.Ref]
        val ext = if(finalMessage.hasExt()) Some(readASTMessage(finalMessage.getExt()).asInstanceOf[com.google.jribble.ast.Ref]) else None
        val implements = for(index <- (0 until finalMessage.getImplementsCount()).toList) yield readASTMessage(finalMessage.getImplements(index)).asInstanceOf[com.google.jribble.ast.Ref]
        val body = for(index <- (0 until finalMessage.getBodyCount()).toList) yield readASTMessage(finalMessage.getBody(index)).asInstanceOf[com.google.jribble.ast.ClassBodyElement]
        ClassDef(modifs, name, ext, implements, body)
      case com.google.jribble.ast.JribbleProtos.DeclaredType.MessageType.InterfaceDef =>
        val finalMessage = message.getExtension(com.google.jribble.ast.JribbleProtos.InterfaceDef.declaredType)
        val modifs = for(index <- (0 until finalMessage.getModifsCount()).toSet[Int]) yield finalMessage.getModifs(index)
        val name = readASTMessage(finalMessage.getName()).asInstanceOf[com.google.jribble.ast.Ref]
        val ext = for(index <- (0 until finalMessage.getExtCount()).toList) yield readASTMessage(finalMessage.getExt(index)).asInstanceOf[com.google.jribble.ast.Ref]
        val body = for(index <- (0 until finalMessage.getBodyCount()).toList) yield readASTMessage(finalMessage.getBody(index)).asInstanceOf[com.google.jribble.ast.MethodDef]
        InterfaceDef(modifs, name, ext, body)
    }
  }
}
