// Generated file.  DO NOT EDIT!.
package com.google.jribble.ast

object JribbleProtoWriter {
  def convertASTToMessage(element: com.google.jribble.ast.AST): com.google.jribble.ast.JribbleProtos.AST = {
    element match {
      case subElement: com.google.jribble.ast.And => convertAndToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.Array => convertArrayToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.ArrayInitializer => convertArrayInitializerToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.ArrayLength => convertArrayLengthToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.ArrayRef => convertArrayRefToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.Assignment => convertAssignmentToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.BitAnd => convertBitAndToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.BitLShift => convertBitLShiftToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.BitNot => convertBitNotToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.BitOr => convertBitOrToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.BitRShift => convertBitRShiftToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.BitUnsignedRShift => convertBitUnsignedRShiftToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.BitXor => convertBitXorToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.Block => convertBlockToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.BooleanLiteral => convertBooleanLiteralToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.Break => convertBreakToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.Cast => convertCastToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.CharLiteral => convertCharLiteralToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.ClassOf => convertClassOfToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.Conditional => convertConditionalToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.Constructor => convertConstructorToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.ConstructorCall => convertConstructorCallToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.Continue => convertContinueToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.Divide => convertDivideToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.DoubleLiteral => convertDoubleLiteralToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.Equal => convertEqualToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.FieldDef => convertFieldDefToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.FieldRef => convertFieldRefToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.FloatLiteral => convertFloatLiteralToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.Greater => convertGreaterToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.GreaterOrEqual => convertGreaterOrEqualToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.If => convertIfToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.InstanceOf => convertInstanceOfToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.IntLiteral => convertIntLiteralToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.Lesser => convertLesserToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.LesserOrEqual => convertLesserOrEqualToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.LongLiteral => convertLongLiteralToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.MethodCall => convertMethodCallToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.MethodDef => convertMethodDefToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.Minus => convertMinusToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.Modulus => convertModulusToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.Multiply => convertMultiplyToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.NewArray => convertNewArrayToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.NewCall => convertNewCallToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.Not => convertNotToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.NotEqual => convertNotEqualToMessageBuilder(subElement).build()
      case com.google.jribble.ast.NullLiteral => convertNullLiteralToMessageBuilder().build()
      case subElement: com.google.jribble.ast.Or => convertOrToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.Package => convertPackageToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.ParamDef => convertParamDefToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.Plus => convertPlusToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.Primitive => convertPrimitiveToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.Ref => convertRefToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.Return => convertReturnToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.Signature => convertSignatureToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.StaticFieldRef => convertStaticFieldRefToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.StaticMethodCall => convertStaticMethodCallToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.StringLiteral => convertStringLiteralToMessageBuilder(subElement).build()
      case com.google.jribble.ast.SuperRef => convertSuperRefToMessageBuilder().build()
      case subElement: com.google.jribble.ast.Switch => convertSwitchToMessageBuilder(subElement).build()
      case com.google.jribble.ast.ThisRef => convertThisRefToMessageBuilder().build()
      case subElement: com.google.jribble.ast.Throw => convertThrowToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.Try => convertTryToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.UnaryMinus => convertUnaryMinusToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.VarDef => convertVarDefToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.VarRef => convertVarRefToMessageBuilder(subElement).build()
      case com.google.jribble.ast.Void => convertVoidToMessageBuilder().build()
      case subElement: com.google.jribble.ast.While => convertWhileToMessageBuilder(subElement).build()
    }
  }
  private def convertAndToMessageBuilder(element: com.google.jribble.ast.And) = {
    val message = com.google.jribble.ast.JribbleProtos.And.newBuilder()
    message.setLhs(convertASTToMessage(element.lhs))
    message.setRhs(convertASTToMessage(element.rhs))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.And)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.And.aST, message.build())
    headMessage
  }
  private def convertArrayToMessageBuilder(element: com.google.jribble.ast.Array) = {
    val message = com.google.jribble.ast.JribbleProtos.Array.newBuilder()
    message.setTyp(convertASTToMessage(element.typ))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Array)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Array.aST, message.build())
    headMessage
  }
  private def convertArrayInitializerToMessageBuilder(element: com.google.jribble.ast.ArrayInitializer) = {
    val message = com.google.jribble.ast.JribbleProtos.ArrayInitializer.newBuilder()
    message.setTyp(convertASTToMessage(element.typ))
    for(subElement <- element.elements) {
      message.addElements(convertASTToMessage(subElement))
    }
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.ArrayInitializer)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.ArrayInitializer.aST, message.build())
    headMessage
  }
  private def convertArrayLengthToMessageBuilder(element: com.google.jribble.ast.ArrayLength) = {
    val message = com.google.jribble.ast.JribbleProtos.ArrayLength.newBuilder()
    message.setOn(convertASTToMessage(element.on))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.ArrayLength)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.ArrayLength.aST, message.build())
    headMessage
  }
  private def convertArrayRefToMessageBuilder(element: com.google.jribble.ast.ArrayRef) = {
    val message = com.google.jribble.ast.JribbleProtos.ArrayRef.newBuilder()
    message.setOn(convertASTToMessage(element.on))
    message.setIndex(convertASTToMessage(element.index))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.ArrayRef)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.ArrayRef.aST, message.build())
    headMessage
  }
  private def convertAssignmentToMessageBuilder(element: com.google.jribble.ast.Assignment) = {
    val message = com.google.jribble.ast.JribbleProtos.Assignment.newBuilder()
    message.setLhs(convertASTToMessage(element.lhs))
    message.setRhs(convertASTToMessage(element.rhs))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Assignment)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Assignment.aST, message.build())
    headMessage
  }
  private def convertBitAndToMessageBuilder(element: com.google.jribble.ast.BitAnd) = {
    val message = com.google.jribble.ast.JribbleProtos.BitAnd.newBuilder()
    message.setLhs(convertASTToMessage(element.lhs))
    message.setRhs(convertASTToMessage(element.rhs))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.BitAnd)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.BitAnd.aST, message.build())
    headMessage
  }
  private def convertBitLShiftToMessageBuilder(element: com.google.jribble.ast.BitLShift) = {
    val message = com.google.jribble.ast.JribbleProtos.BitLShift.newBuilder()
    message.setLhs(convertASTToMessage(element.lhs))
    message.setRhs(convertASTToMessage(element.rhs))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.BitLShift)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.BitLShift.aST, message.build())
    headMessage
  }
  private def convertBitNotToMessageBuilder(element: com.google.jribble.ast.BitNot) = {
    val message = com.google.jribble.ast.JribbleProtos.BitNot.newBuilder()
    message.setExpression(convertASTToMessage(element.expression))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.BitNot)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.BitNot.aST, message.build())
    headMessage
  }
  private def convertBitOrToMessageBuilder(element: com.google.jribble.ast.BitOr) = {
    val message = com.google.jribble.ast.JribbleProtos.BitOr.newBuilder()
    message.setLhs(convertASTToMessage(element.lhs))
    message.setRhs(convertASTToMessage(element.rhs))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.BitOr)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.BitOr.aST, message.build())
    headMessage
  }
  private def convertBitRShiftToMessageBuilder(element: com.google.jribble.ast.BitRShift) = {
    val message = com.google.jribble.ast.JribbleProtos.BitRShift.newBuilder()
    message.setLhs(convertASTToMessage(element.lhs))
    message.setRhs(convertASTToMessage(element.rhs))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.BitRShift)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.BitRShift.aST, message.build())
    headMessage
  }
  private def convertBitUnsignedRShiftToMessageBuilder(element: com.google.jribble.ast.BitUnsignedRShift) = {
    val message = com.google.jribble.ast.JribbleProtos.BitUnsignedRShift.newBuilder()
    message.setLhs(convertASTToMessage(element.lhs))
    message.setRhs(convertASTToMessage(element.rhs))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.BitUnsignedRShift)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.BitUnsignedRShift.aST, message.build())
    headMessage
  }
  private def convertBitXorToMessageBuilder(element: com.google.jribble.ast.BitXor) = {
    val message = com.google.jribble.ast.JribbleProtos.BitXor.newBuilder()
    message.setLhs(convertASTToMessage(element.lhs))
    message.setRhs(convertASTToMessage(element.rhs))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.BitXor)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.BitXor.aST, message.build())
    headMessage
  }
  private def convertBlockToMessageBuilder(element: com.google.jribble.ast.Block) = {
    val message = com.google.jribble.ast.JribbleProtos.Block.newBuilder()
    for(subElement <- element.statements) {
      message.addStatements(convertASTToMessage(subElement))
    }
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Block)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Block.aST, message.build())
    headMessage
  }
  private def convertBooleanLiteralToMessageBuilder(element: com.google.jribble.ast.BooleanLiteral) = {
    val message = com.google.jribble.ast.JribbleProtos.BooleanLiteral.newBuilder()
    message.setV(element.v)
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.BooleanLiteral)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.BooleanLiteral.aST, message.build())
    headMessage
  }
  private def convertBreakToMessageBuilder(element: com.google.jribble.ast.Break) = {
    val message = com.google.jribble.ast.JribbleProtos.Break.newBuilder()
    if(element.label != None) message.setLabel(element.label.get)
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Break)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Break.aST, message.build())
    headMessage
  }
  private def convertCastToMessageBuilder(element: com.google.jribble.ast.Cast) = {
    val message = com.google.jribble.ast.JribbleProtos.Cast.newBuilder()
    message.setOn(convertASTToMessage(element.on))
    message.setTyp(convertASTToMessage(element.typ))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Cast)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Cast.aST, message.build())
    headMessage
  }
  private def convertCharLiteralToMessageBuilder(element: com.google.jribble.ast.CharLiteral) = {
    val message = com.google.jribble.ast.JribbleProtos.CharLiteral.newBuilder()
    message.setV(element.v)
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.CharLiteral)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.CharLiteral.aST, message.build())
    headMessage
  }
  private def convertClassDefToMessageBuilder(element: com.google.jribble.ast.ClassDef) = {
    val message = com.google.jribble.ast.JribbleProtos.ClassDef.newBuilder()
    for(subElement <- element.modifs) {
      message.addModifs(subElement)
    }
    message.setName(convertASTToMessage(element.name))
    if(element.ext != None) message.setExt(convertASTToMessage(element.ext.get))
    for(subElement <- element.implements) {
      message.addImplements(convertASTToMessage(subElement))
    }
    for(subElement <- element.body) {
      message.addBody(convertASTToMessage(subElement))
    }
    val headMessage = com.google.jribble.ast.JribbleProtos.DeclaredType.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.DeclaredType.MessageType.ClassDef)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.ClassDef.declaredType, message.build())
    headMessage
  }
  private def convertClassOfToMessageBuilder(element: com.google.jribble.ast.ClassOf) = {
    val message = com.google.jribble.ast.JribbleProtos.ClassOf.newBuilder()
    message.setTyp(convertASTToMessage(element.typ))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.ClassOf)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.ClassOf.aST, message.build())
    headMessage
  }
  private def convertConditionalToMessageBuilder(element: com.google.jribble.ast.Conditional) = {
    val message = com.google.jribble.ast.JribbleProtos.Conditional.newBuilder()
    message.setCondition(convertASTToMessage(element.condition))
    message.setTyp(convertASTToMessage(element.typ))
    message.setThen(convertASTToMessage(element.then))
    message.setElsee(convertASTToMessage(element.elsee))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Conditional)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Conditional.aST, message.build())
    headMessage
  }
  private def convertConstructorToMessageBuilder(element: com.google.jribble.ast.Constructor) = {
    val message = com.google.jribble.ast.JribbleProtos.Constructor.newBuilder()
    for(subElement <- element.modifs) {
      message.addModifs(subElement)
    }
    message.setName(element.name)
    for(subElement <- element.params) {
      message.addParams(convertASTToMessage(subElement))
    }
    message.setBody(convertASTToMessage(element.body))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Constructor)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Constructor.aST, message.build())
    headMessage
  }
  private def convertConstructorCallToMessageBuilder(element: com.google.jribble.ast.ConstructorCall) = {
    val message = com.google.jribble.ast.JribbleProtos.ConstructorCall.newBuilder()
    message.setSignature(convertASTToMessage(element.signature))
    for(subElement <- element.params) {
      message.addParams(convertASTToMessage(subElement))
    }
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.ConstructorCall)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.ConstructorCall.aST, message.build())
    headMessage
  }
  private def convertContinueToMessageBuilder(element: com.google.jribble.ast.Continue) = {
    val message = com.google.jribble.ast.JribbleProtos.Continue.newBuilder()
    if(element.label != None) message.setLabel(element.label.get)
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Continue)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Continue.aST, message.build())
    headMessage
  }
  def convertDeclaredTypeToMessage(element: com.google.jribble.ast.DeclaredType): com.google.jribble.ast.JribbleProtos.DeclaredType = {
    element match {
      case subElement: com.google.jribble.ast.ClassDef => convertClassDefToMessageBuilder(subElement).build()
      case subElement: com.google.jribble.ast.InterfaceDef => convertInterfaceDefToMessageBuilder(subElement).build()
    }
  }
  private def convertDivideToMessageBuilder(element: com.google.jribble.ast.Divide) = {
    val message = com.google.jribble.ast.JribbleProtos.Divide.newBuilder()
    message.setLhs(convertASTToMessage(element.lhs))
    message.setRhs(convertASTToMessage(element.rhs))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Divide)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Divide.aST, message.build())
    headMessage
  }
  private def convertDoubleLiteralToMessageBuilder(element: com.google.jribble.ast.DoubleLiteral) = {
    val message = com.google.jribble.ast.JribbleProtos.DoubleLiteral.newBuilder()
    message.setV(element.v)
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.DoubleLiteral)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.DoubleLiteral.aST, message.build())
    headMessage
  }
  private def convertEqualToMessageBuilder(element: com.google.jribble.ast.Equal) = {
    val message = com.google.jribble.ast.JribbleProtos.Equal.newBuilder()
    message.setLhs(convertASTToMessage(element.lhs))
    message.setRhs(convertASTToMessage(element.rhs))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Equal)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Equal.aST, message.build())
    headMessage
  }
  private def convertFieldDefToMessageBuilder(element: com.google.jribble.ast.FieldDef) = {
    val message = com.google.jribble.ast.JribbleProtos.FieldDef.newBuilder()
    for(subElement <- element.modifs) {
      message.addModifs(subElement)
    }
    message.setTyp(convertASTToMessage(element.typ))
    message.setName(element.name)
    if(element.value != None) message.setValue(convertASTToMessage(element.value.get))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.FieldDef)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.FieldDef.aST, message.build())
    headMessage
  }
  private def convertFieldRefToMessageBuilder(element: com.google.jribble.ast.FieldRef) = {
    val message = com.google.jribble.ast.JribbleProtos.FieldRef.newBuilder()
    message.setOn(convertASTToMessage(element.on))
    message.setOnType(convertASTToMessage(element.onType))
    message.setName(element.name)
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.FieldRef)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.FieldRef.aST, message.build())
    headMessage
  }
  private def convertFloatLiteralToMessageBuilder(element: com.google.jribble.ast.FloatLiteral) = {
    val message = com.google.jribble.ast.JribbleProtos.FloatLiteral.newBuilder()
    message.setV(element.v)
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.FloatLiteral)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.FloatLiteral.aST, message.build())
    headMessage
  }
  private def convertGreaterToMessageBuilder(element: com.google.jribble.ast.Greater) = {
    val message = com.google.jribble.ast.JribbleProtos.Greater.newBuilder()
    message.setLhs(convertASTToMessage(element.lhs))
    message.setRhs(convertASTToMessage(element.rhs))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Greater)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Greater.aST, message.build())
    headMessage
  }
  private def convertGreaterOrEqualToMessageBuilder(element: com.google.jribble.ast.GreaterOrEqual) = {
    val message = com.google.jribble.ast.JribbleProtos.GreaterOrEqual.newBuilder()
    message.setLhs(convertASTToMessage(element.lhs))
    message.setRhs(convertASTToMessage(element.rhs))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.GreaterOrEqual)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.GreaterOrEqual.aST, message.build())
    headMessage
  }
  private def convertIfToMessageBuilder(element: com.google.jribble.ast.If) = {
    val message = com.google.jribble.ast.JribbleProtos.If.newBuilder()
    message.setCondition(convertASTToMessage(element.condition))
    message.setThen(convertASTToMessage(element.then))
    if(element.elsee != None) message.setElsee(convertASTToMessage(element.elsee.get))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.If)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.If.aST, message.build())
    headMessage
  }
  private def convertInstanceOfToMessageBuilder(element: com.google.jribble.ast.InstanceOf) = {
    val message = com.google.jribble.ast.JribbleProtos.InstanceOf.newBuilder()
    message.setOn(convertASTToMessage(element.on))
    message.setTyp(convertASTToMessage(element.typ))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.InstanceOf)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.InstanceOf.aST, message.build())
    headMessage
  }
  private def convertIntLiteralToMessageBuilder(element: com.google.jribble.ast.IntLiteral) = {
    val message = com.google.jribble.ast.JribbleProtos.IntLiteral.newBuilder()
    message.setV(element.v)
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.IntLiteral)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.IntLiteral.aST, message.build())
    headMessage
  }
  private def convertInterfaceDefToMessageBuilder(element: com.google.jribble.ast.InterfaceDef) = {
    val message = com.google.jribble.ast.JribbleProtos.InterfaceDef.newBuilder()
    for(subElement <- element.modifs) {
      message.addModifs(subElement)
    }
    message.setName(convertASTToMessage(element.name))
    for(subElement <- element.ext) {
      message.addExt(convertASTToMessage(subElement))
    }
    for(subElement <- element.body) {
      message.addBody(convertASTToMessage(subElement))
    }
    val headMessage = com.google.jribble.ast.JribbleProtos.DeclaredType.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.DeclaredType.MessageType.InterfaceDef)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.InterfaceDef.declaredType, message.build())
    headMessage
  }
  private def convertLesserToMessageBuilder(element: com.google.jribble.ast.Lesser) = {
    val message = com.google.jribble.ast.JribbleProtos.Lesser.newBuilder()
    message.setLhs(convertASTToMessage(element.lhs))
    message.setRhs(convertASTToMessage(element.rhs))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Lesser)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Lesser.aST, message.build())
    headMessage
  }
  private def convertLesserOrEqualToMessageBuilder(element: com.google.jribble.ast.LesserOrEqual) = {
    val message = com.google.jribble.ast.JribbleProtos.LesserOrEqual.newBuilder()
    message.setLhs(convertASTToMessage(element.lhs))
    message.setRhs(convertASTToMessage(element.rhs))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.LesserOrEqual)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.LesserOrEqual.aST, message.build())
    headMessage
  }
  private def convertLongLiteralToMessageBuilder(element: com.google.jribble.ast.LongLiteral) = {
    val message = com.google.jribble.ast.JribbleProtos.LongLiteral.newBuilder()
    message.setV(element.v)
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.LongLiteral)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.LongLiteral.aST, message.build())
    headMessage
  }
  private def convertMethodCallToMessageBuilder(element: com.google.jribble.ast.MethodCall) = {
    val message = com.google.jribble.ast.JribbleProtos.MethodCall.newBuilder()
    message.setOn(convertASTToMessage(element.on))
    message.setSignature(convertASTToMessage(element.signature))
    for(subElement <- element.params) {
      message.addParams(convertASTToMessage(subElement))
    }
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.MethodCall)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.MethodCall.aST, message.build())
    headMessage
  }
  private def convertMethodDefToMessageBuilder(element: com.google.jribble.ast.MethodDef) = {
    val message = com.google.jribble.ast.JribbleProtos.MethodDef.newBuilder()
    for(subElement <- element.modifs) {
      message.addModifs(subElement)
    }
    message.setReturnType(convertASTToMessage(element.returnType))
    message.setName(element.name)
    for(subElement <- element.params) {
      message.addParams(convertASTToMessage(subElement))
    }
    if(element.body != None) message.setBody(convertASTToMessage(element.body.get))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.MethodDef)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.MethodDef.aST, message.build())
    headMessage
  }
  private def convertMinusToMessageBuilder(element: com.google.jribble.ast.Minus) = {
    val message = com.google.jribble.ast.JribbleProtos.Minus.newBuilder()
    message.setLhs(convertASTToMessage(element.lhs))
    message.setRhs(convertASTToMessage(element.rhs))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Minus)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Minus.aST, message.build())
    headMessage
  }
  private def convertModulusToMessageBuilder(element: com.google.jribble.ast.Modulus) = {
    val message = com.google.jribble.ast.JribbleProtos.Modulus.newBuilder()
    message.setLhs(convertASTToMessage(element.lhs))
    message.setRhs(convertASTToMessage(element.rhs))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Modulus)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Modulus.aST, message.build())
    headMessage
  }
  private def convertMultiplyToMessageBuilder(element: com.google.jribble.ast.Multiply) = {
    val message = com.google.jribble.ast.JribbleProtos.Multiply.newBuilder()
    message.setLhs(convertASTToMessage(element.lhs))
    message.setRhs(convertASTToMessage(element.rhs))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Multiply)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Multiply.aST, message.build())
    headMessage
  }
  private def convertNewArrayToMessageBuilder(element: com.google.jribble.ast.NewArray) = {
    val message = com.google.jribble.ast.JribbleProtos.NewArray.newBuilder()
    message.setTyp(convertASTToMessage(element.typ))
    for(subElement <- element.dims) {
      val subMessage = com.google.jribble.ast.JribbleProtos.NewArray.Dims.newBuilder()
      if(subElement != None) {
        subMessage.setT(convertASTToMessage(subElement.get))
      }
      message.addDims(subMessage.build())
    }
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.NewArray)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.NewArray.aST, message.build())
    headMessage
  }
  private def convertNewCallToMessageBuilder(element: com.google.jribble.ast.NewCall) = {
    val message = com.google.jribble.ast.JribbleProtos.NewCall.newBuilder()
    message.setConstructor(convertASTToMessage(element.constructor))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.NewCall)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.NewCall.aST, message.build())
    headMessage
  }
  private def convertNotToMessageBuilder(element: com.google.jribble.ast.Not) = {
    val message = com.google.jribble.ast.JribbleProtos.Not.newBuilder()
    message.setExpression(convertASTToMessage(element.expression))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Not)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Not.aST, message.build())
    headMessage
  }
  private def convertNotEqualToMessageBuilder(element: com.google.jribble.ast.NotEqual) = {
    val message = com.google.jribble.ast.JribbleProtos.NotEqual.newBuilder()
    message.setLhs(convertASTToMessage(element.lhs))
    message.setRhs(convertASTToMessage(element.rhs))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.NotEqual)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.NotEqual.aST, message.build())
    headMessage
  }
  private def convertNullLiteralToMessageBuilder() = {
    val message = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    message.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.NullLiteral)
    message
  }
  private def convertOrToMessageBuilder(element: com.google.jribble.ast.Or) = {
    val message = com.google.jribble.ast.JribbleProtos.Or.newBuilder()
    message.setLhs(convertASTToMessage(element.lhs))
    message.setRhs(convertASTToMessage(element.rhs))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Or)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Or.aST, message.build())
    headMessage
  }
  private def convertPackageToMessageBuilder(element: com.google.jribble.ast.Package) = {
    val message = com.google.jribble.ast.JribbleProtos.Package.newBuilder()
    message.setName(element.name)
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Package)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Package.aST, message.build())
    headMessage
  }
  private def convertParamDefToMessageBuilder(element: com.google.jribble.ast.ParamDef) = {
    val message = com.google.jribble.ast.JribbleProtos.ParamDef.newBuilder()
    message.setName(element.name)
    message.setTyp(convertASTToMessage(element.typ))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.ParamDef)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.ParamDef.aST, message.build())
    headMessage
  }
  private def convertPlusToMessageBuilder(element: com.google.jribble.ast.Plus) = {
    val message = com.google.jribble.ast.JribbleProtos.Plus.newBuilder()
    message.setLhs(convertASTToMessage(element.lhs))
    message.setRhs(convertASTToMessage(element.rhs))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Plus)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Plus.aST, message.build())
    headMessage
  }
  private def convertPrimitiveToMessageBuilder(element: com.google.jribble.ast.Primitive) = {
    val message = com.google.jribble.ast.JribbleProtos.Primitive.newBuilder()
    message.setName(element.name)
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Primitive)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Primitive.aST, message.build())
    headMessage
  }
  private def convertRefToMessageBuilder(element: com.google.jribble.ast.Ref) = {
    val message = com.google.jribble.ast.JribbleProtos.Ref.newBuilder()
    if(element.pkg != None) message.setPkg(convertASTToMessage(element.pkg.get))
    message.setName(element.name)
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Ref)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Ref.aST, message.build())
    headMessage
  }
  private def convertReturnToMessageBuilder(element: com.google.jribble.ast.Return) = {
    val message = com.google.jribble.ast.JribbleProtos.Return.newBuilder()
    if(element.expression != None) message.setExpression(convertASTToMessage(element.expression.get))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Return)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Return.aST, message.build())
    headMessage
  }
  private def convertSignatureToMessageBuilder(element: com.google.jribble.ast.Signature) = {
    val message = com.google.jribble.ast.JribbleProtos.Signature.newBuilder()
    message.setOn(convertASTToMessage(element.on))
    message.setName(element.name)
    for(subElement <- element.paramTypes) {
      message.addParamTypes(convertASTToMessage(subElement))
    }
    message.setReturnType(convertASTToMessage(element.returnType))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Signature)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Signature.aST, message.build())
    headMessage
  }
  private def convertStaticFieldRefToMessageBuilder(element: com.google.jribble.ast.StaticFieldRef) = {
    val message = com.google.jribble.ast.JribbleProtos.StaticFieldRef.newBuilder()
    message.setOn(convertASTToMessage(element.on))
    message.setName(element.name)
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.StaticFieldRef)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.StaticFieldRef.aST, message.build())
    headMessage
  }
  private def convertStaticMethodCallToMessageBuilder(element: com.google.jribble.ast.StaticMethodCall) = {
    val message = com.google.jribble.ast.JribbleProtos.StaticMethodCall.newBuilder()
    message.setClassRef(convertASTToMessage(element.classRef))
    message.setSignature(convertASTToMessage(element.signature))
    for(subElement <- element.params) {
      message.addParams(convertASTToMessage(subElement))
    }
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.StaticMethodCall)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.StaticMethodCall.aST, message.build())
    headMessage
  }
  private def convertStringLiteralToMessageBuilder(element: com.google.jribble.ast.StringLiteral) = {
    val message = com.google.jribble.ast.JribbleProtos.StringLiteral.newBuilder()
    message.setV(element.v)
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.StringLiteral)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.StringLiteral.aST, message.build())
    headMessage
  }
  private def convertSuperRefToMessageBuilder() = {
    val message = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    message.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.SuperRef)
    message
  }
  private def convertSwitchToMessageBuilder(element: com.google.jribble.ast.Switch) = {
    val message = com.google.jribble.ast.JribbleProtos.Switch.newBuilder()
    message.setExpression(convertASTToMessage(element.expression))
    for(subElement <- element.groups) {
      val subMessage = com.google.jribble.ast.JribbleProtos.Switch.Groups.newBuilder()
      subMessage.setT0(convertASTToMessage(subElement._1))
      subMessage.setT1(convertASTToMessage(subElement._2))
      message.addGroups(subMessage.build())
    }
    if(element.default != None) message.setDefault(convertASTToMessage(element.default.get))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Switch)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Switch.aST, message.build())
    headMessage
  }
  private def convertThisRefToMessageBuilder() = {
    val message = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    message.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.ThisRef)
    message
  }
  private def convertThrowToMessageBuilder(element: com.google.jribble.ast.Throw) = {
    val message = com.google.jribble.ast.JribbleProtos.Throw.newBuilder()
    message.setExpression(convertASTToMessage(element.expression))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Throw)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Throw.aST, message.build())
    headMessage
  }
  private def convertTryToMessageBuilder(element: com.google.jribble.ast.Try) = {
    val message = com.google.jribble.ast.JribbleProtos.Try.newBuilder()
    message.setBlock(convertASTToMessage(element.block))
    for(subElement <- element.catches) {
      val subMessage = com.google.jribble.ast.JribbleProtos.Try.Catches.newBuilder()
      subMessage.setT0(convertASTToMessage(subElement._1))
      subMessage.setT1(subElement._2)
      subMessage.setT2(convertASTToMessage(subElement._3))
      message.addCatches(subMessage.build())
    }
    if(element.finalizer != None) message.setFinalizer(convertASTToMessage(element.finalizer.get))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Try)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Try.aST, message.build())
    headMessage
  }
  private def convertUnaryMinusToMessageBuilder(element: com.google.jribble.ast.UnaryMinus) = {
    val message = com.google.jribble.ast.JribbleProtos.UnaryMinus.newBuilder()
    message.setExpression(convertASTToMessage(element.expression))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.UnaryMinus)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.UnaryMinus.aST, message.build())
    headMessage
  }
  private def convertVarDefToMessageBuilder(element: com.google.jribble.ast.VarDef) = {
    val message = com.google.jribble.ast.JribbleProtos.VarDef.newBuilder()
    message.setTyp(convertASTToMessage(element.typ))
    message.setName(element.name)
    if(element.value != None) message.setValue(convertASTToMessage(element.value.get))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.VarDef)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.VarDef.aST, message.build())
    headMessage
  }
  private def convertVarRefToMessageBuilder(element: com.google.jribble.ast.VarRef) = {
    val message = com.google.jribble.ast.JribbleProtos.VarRef.newBuilder()
    message.setName(element.name)
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.VarRef)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.VarRef.aST, message.build())
    headMessage
  }
  private def convertVoidToMessageBuilder() = {
    val message = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    message.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Void)
    message
  }
  private def convertWhileToMessageBuilder(element: com.google.jribble.ast.While) = {
    val message = com.google.jribble.ast.JribbleProtos.While.newBuilder()
    if(element.label != None) message.setLabel(element.label.get)
    message.setCondition(convertASTToMessage(element.condition))
    message.setBlock(convertASTToMessage(element.block))
    val headMessage = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.While)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.While.aST, message.build())
    headMessage
  }
}
