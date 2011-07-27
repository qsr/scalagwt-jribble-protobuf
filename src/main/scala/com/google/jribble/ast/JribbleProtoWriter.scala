// Generated file.  DO NOT EDIT!.
package com.google.jribble.ast

object JribbleProtoWriter {
  def convertASTToMessage(element: com.google.jribble.ast.AST): com.google.jribble.ast.JribbleProtos.AST = {
    element match {
      case subElement: com.google.jribble.ast.Type => convertTypeToMessage(subElement)
      case subElement: com.google.jribble.ast.Signature => convertSignatureToMessage(subElement)
      case subElement: com.google.jribble.ast.Statement => convertStatementToMessage(subElement)
      case subElement: com.google.jribble.ast.ParamDef => convertParamDefToMessage(subElement)
      case subElement: com.google.jribble.ast.ClassBodyElement => convertClassBodyElementToMessage(subElement)
      case subElement: com.google.jribble.ast.Package => convertPackageToMessage(subElement)
      case _ => convertSpecificASTToMessage(element).build()
    }
  }
  private def convertSpecificASTToMessage(element: com.google.jribble.ast.AST): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.AST.newBuilder()
    message
  }
  def convertAndToMessage(element: com.google.jribble.ast.And): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificAndToMessage(element).build()
  }
  private def convertSpecificAndToMessage(element: com.google.jribble.ast.And): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.And.newBuilder()
    message.setLhs(convertExpressionToMessage(element.lhs))
    message.setRhs(convertExpressionToMessage(element.rhs))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.And)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.And.aST, message.build())
    headMessage
  }
  def convertArrayToMessage(element: com.google.jribble.ast.Array): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificArrayToMessage(element).build()
  }
  private def convertSpecificArrayToMessage(element: com.google.jribble.ast.Array): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.Array.newBuilder()
    message.setTyp(convertTypeToMessage(element.typ))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Array)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Array.aST, message.build())
    headMessage
  }
  def convertArrayInitializerToMessage(element: com.google.jribble.ast.ArrayInitializer): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificArrayInitializerToMessage(element).build()
  }
  private def convertSpecificArrayInitializerToMessage(element: com.google.jribble.ast.ArrayInitializer): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.ArrayInitializer.newBuilder()
    message.setTyp(convertTypeToMessage(element.typ))
    for(subElement <- element.elements) {
      message.addElements(convertExpressionToMessage(subElement))
    }
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.ArrayInitializer)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.ArrayInitializer.aST, message.build())
    headMessage
  }
  def convertArrayLengthToMessage(element: com.google.jribble.ast.ArrayLength): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificArrayLengthToMessage(element).build()
  }
  private def convertSpecificArrayLengthToMessage(element: com.google.jribble.ast.ArrayLength): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.ArrayLength.newBuilder()
    message.setOn(convertExpressionToMessage(element.on))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.ArrayLength)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.ArrayLength.aST, message.build())
    headMessage
  }
  def convertArrayRefToMessage(element: com.google.jribble.ast.ArrayRef): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificArrayRefToMessage(element).build()
  }
  private def convertSpecificArrayRefToMessage(element: com.google.jribble.ast.ArrayRef): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.ArrayRef.newBuilder()
    message.setOn(convertExpressionToMessage(element.on))
    message.setIndex(convertExpressionToMessage(element.index))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.ArrayRef)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.ArrayRef.aST, message.build())
    headMessage
  }
  def convertAssignmentToMessage(element: com.google.jribble.ast.Assignment): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificAssignmentToMessage(element).build()
  }
  private def convertSpecificAssignmentToMessage(element: com.google.jribble.ast.Assignment): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.Assignment.newBuilder()
    message.setLhs(convertExpressionToMessage(element.lhs))
    message.setRhs(convertExpressionToMessage(element.rhs))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Assignment)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Assignment.aST, message.build())
    headMessage
  }
  def convertBinaryOpToMessage(element: com.google.jribble.ast.BinaryOp): com.google.jribble.ast.JribbleProtos.AST = {
    element match {
      case subElement: com.google.jribble.ast.BitOr => convertBitOrToMessage(subElement)
      case subElement: com.google.jribble.ast.BitXor => convertBitXorToMessage(subElement)
      case subElement: com.google.jribble.ast.BitAnd => convertBitAndToMessage(subElement)
      case subElement: com.google.jribble.ast.BitUnsignedRShift => convertBitUnsignedRShiftToMessage(subElement)
      case subElement: com.google.jribble.ast.BitRShift => convertBitRShiftToMessage(subElement)
      case subElement: com.google.jribble.ast.BitLShift => convertBitLShiftToMessage(subElement)
      case subElement: com.google.jribble.ast.Or => convertOrToMessage(subElement)
      case subElement: com.google.jribble.ast.And => convertAndToMessage(subElement)
      case subElement: com.google.jribble.ast.NotEqual => convertNotEqualToMessage(subElement)
      case subElement: com.google.jribble.ast.Equal => convertEqualToMessage(subElement)
      case subElement: com.google.jribble.ast.LesserOrEqual => convertLesserOrEqualToMessage(subElement)
      case subElement: com.google.jribble.ast.Lesser => convertLesserToMessage(subElement)
      case subElement: com.google.jribble.ast.GreaterOrEqual => convertGreaterOrEqualToMessage(subElement)
      case subElement: com.google.jribble.ast.Greater => convertGreaterToMessage(subElement)
      case subElement: com.google.jribble.ast.Plus => convertPlusToMessage(subElement)
      case subElement: com.google.jribble.ast.Minus => convertMinusToMessage(subElement)
      case subElement: com.google.jribble.ast.Modulus => convertModulusToMessage(subElement)
      case subElement: com.google.jribble.ast.Divide => convertDivideToMessage(subElement)
      case subElement: com.google.jribble.ast.Multiply => convertMultiplyToMessage(subElement)
      case _ => convertSpecificBinaryOpToMessage(element).build()
    }
  }
  private def convertSpecificBinaryOpToMessage(element: com.google.jribble.ast.BinaryOp): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.BinaryOp.newBuilder()
    message.setSymbol(element.symbol)
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.BinaryOp)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.BinaryOp.aST, message.build())
    headMessage
  }
  def convertBitAndToMessage(element: com.google.jribble.ast.BitAnd): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificBitAndToMessage(element).build()
  }
  private def convertSpecificBitAndToMessage(element: com.google.jribble.ast.BitAnd): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.BitAnd.newBuilder()
    message.setLhs(convertExpressionToMessage(element.lhs))
    message.setRhs(convertExpressionToMessage(element.rhs))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.BitAnd)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.BitAnd.aST, message.build())
    headMessage
  }
  def convertBitLShiftToMessage(element: com.google.jribble.ast.BitLShift): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificBitLShiftToMessage(element).build()
  }
  private def convertSpecificBitLShiftToMessage(element: com.google.jribble.ast.BitLShift): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.BitLShift.newBuilder()
    message.setLhs(convertExpressionToMessage(element.lhs))
    message.setRhs(convertExpressionToMessage(element.rhs))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.BitLShift)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.BitLShift.aST, message.build())
    headMessage
  }
  def convertBitNotToMessage(element: com.google.jribble.ast.BitNot): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificBitNotToMessage(element).build()
  }
  private def convertSpecificBitNotToMessage(element: com.google.jribble.ast.BitNot): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.BitNot.newBuilder()
    message.setExpression(convertExpressionToMessage(element.expression))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.BitNot)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.BitNot.aST, message.build())
    headMessage
  }
  def convertBitOrToMessage(element: com.google.jribble.ast.BitOr): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificBitOrToMessage(element).build()
  }
  private def convertSpecificBitOrToMessage(element: com.google.jribble.ast.BitOr): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.BitOr.newBuilder()
    message.setLhs(convertExpressionToMessage(element.lhs))
    message.setRhs(convertExpressionToMessage(element.rhs))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.BitOr)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.BitOr.aST, message.build())
    headMessage
  }
  def convertBitRShiftToMessage(element: com.google.jribble.ast.BitRShift): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificBitRShiftToMessage(element).build()
  }
  private def convertSpecificBitRShiftToMessage(element: com.google.jribble.ast.BitRShift): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.BitRShift.newBuilder()
    message.setLhs(convertExpressionToMessage(element.lhs))
    message.setRhs(convertExpressionToMessage(element.rhs))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.BitRShift)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.BitRShift.aST, message.build())
    headMessage
  }
  def convertBitUnsignedRShiftToMessage(element: com.google.jribble.ast.BitUnsignedRShift): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificBitUnsignedRShiftToMessage(element).build()
  }
  private def convertSpecificBitUnsignedRShiftToMessage(element: com.google.jribble.ast.BitUnsignedRShift): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.BitUnsignedRShift.newBuilder()
    message.setLhs(convertExpressionToMessage(element.lhs))
    message.setRhs(convertExpressionToMessage(element.rhs))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.BitUnsignedRShift)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.BitUnsignedRShift.aST, message.build())
    headMessage
  }
  def convertBitXorToMessage(element: com.google.jribble.ast.BitXor): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificBitXorToMessage(element).build()
  }
  private def convertSpecificBitXorToMessage(element: com.google.jribble.ast.BitXor): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.BitXor.newBuilder()
    message.setLhs(convertExpressionToMessage(element.lhs))
    message.setRhs(convertExpressionToMessage(element.rhs))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.BitXor)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.BitXor.aST, message.build())
    headMessage
  }
  def convertBlockToMessage(element: com.google.jribble.ast.Block): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificBlockToMessage(element).build()
  }
  private def convertSpecificBlockToMessage(element: com.google.jribble.ast.Block): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.Block.newBuilder()
    for(subElement <- element.statements) {
      message.addStatements(convertStatementToMessage(subElement))
    }
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Block)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Block.aST, message.build())
    headMessage
  }
  def convertBooleanLiteralToMessage(element: com.google.jribble.ast.BooleanLiteral): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificBooleanLiteralToMessage(element).build()
  }
  private def convertSpecificBooleanLiteralToMessage(element: com.google.jribble.ast.BooleanLiteral): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.BooleanLiteral.newBuilder()
    message.setV(element.v)
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.BooleanLiteral)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.BooleanLiteral.aST, message.build())
    headMessage
  }
  def convertBreakToMessage(element: com.google.jribble.ast.Break): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificBreakToMessage(element).build()
  }
  private def convertSpecificBreakToMessage(element: com.google.jribble.ast.Break): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.Break.newBuilder()
    if(element.label != None) message.setLabel(element.label.get)
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Break)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Break.aST, message.build())
    headMessage
  }
  def convertCastToMessage(element: com.google.jribble.ast.Cast): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificCastToMessage(element).build()
  }
  private def convertSpecificCastToMessage(element: com.google.jribble.ast.Cast): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.Cast.newBuilder()
    message.setOn(convertExpressionToMessage(element.on))
    message.setTyp(convertTypeToMessage(element.typ))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Cast)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Cast.aST, message.build())
    headMessage
  }
  def convertCharLiteralToMessage(element: com.google.jribble.ast.CharLiteral): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificCharLiteralToMessage(element).build()
  }
  private def convertSpecificCharLiteralToMessage(element: com.google.jribble.ast.CharLiteral): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.CharLiteral.newBuilder()
    message.setV(element.v)
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.CharLiteral)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.CharLiteral.aST, message.build())
    headMessage
  }
  def convertClassBodyElementToMessage(element: com.google.jribble.ast.ClassBodyElement): com.google.jribble.ast.JribbleProtos.AST = {
    element match {
      case subElement: com.google.jribble.ast.FieldDef => convertFieldDefToMessage(subElement)
      case subElement: com.google.jribble.ast.MethodDef => convertMethodDefToMessage(subElement)
      case subElement: com.google.jribble.ast.Constructor => convertConstructorToMessage(subElement)
      case _ => convertSpecificClassBodyElementToMessage(element).build()
    }
  }
  private def convertSpecificClassBodyElementToMessage(element: com.google.jribble.ast.ClassBodyElement): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.ClassBodyElement)
    headMessage
  }
  def convertClassDefToMessage(element: com.google.jribble.ast.ClassDef): com.google.jribble.ast.JribbleProtos.DeclaredType = {
    convertSpecificClassDefToMessage(element).build()
  }
  private def convertSpecificClassDefToMessage(element: com.google.jribble.ast.ClassDef): com.google.jribble.ast.JribbleProtos.DeclaredType.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.ClassDef.newBuilder()
    for(subElement <- element.modifs) {
      message.addModifs(subElement)
    }
    message.setName(convertRefToMessage(element.name))
    if(element.ext != None) message.setExt(convertRefToMessage(element.ext.get))
    for(subElement <- element.implements) {
      message.addImplements(convertRefToMessage(subElement))
    }
    for(subElement <- element.body) {
      message.addBody(convertClassBodyElementToMessage(subElement))
    }
    val headMessage = convertSpecificDeclaredTypeToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.DeclaredType.MessageType.ClassDef)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.ClassDef.declaredType, message.build())
    headMessage
  }
  def convertClassOfToMessage(element: com.google.jribble.ast.ClassOf): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificClassOfToMessage(element).build()
  }
  private def convertSpecificClassOfToMessage(element: com.google.jribble.ast.ClassOf): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.ClassOf.newBuilder()
    message.setTyp(convertTypeToMessage(element.typ))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.ClassOf)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.ClassOf.aST, message.build())
    headMessage
  }
  def convertConditionalToMessage(element: com.google.jribble.ast.Conditional): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificConditionalToMessage(element).build()
  }
  private def convertSpecificConditionalToMessage(element: com.google.jribble.ast.Conditional): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.Conditional.newBuilder()
    message.setCondition(convertExpressionToMessage(element.condition))
    message.setTyp(convertTypeToMessage(element.typ))
    message.setThen(convertExpressionToMessage(element.then))
    message.setElsee(convertExpressionToMessage(element.elsee))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Conditional)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Conditional.aST, message.build())
    headMessage
  }
  def convertConstructorToMessage(element: com.google.jribble.ast.Constructor): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificConstructorToMessage(element).build()
  }
  private def convertSpecificConstructorToMessage(element: com.google.jribble.ast.Constructor): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.Constructor.newBuilder()
    for(subElement <- element.modifs) {
      message.addModifs(subElement)
    }
    message.setName(element.name)
    for(subElement <- element.params) {
      message.addParams(convertParamDefToMessage(subElement))
    }
    message.setBody(convertBlockToMessage(element.body))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Constructor)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Constructor.aST, message.build())
    headMessage
  }
  def convertConstructorCallToMessage(element: com.google.jribble.ast.ConstructorCall): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificConstructorCallToMessage(element).build()
  }
  private def convertSpecificConstructorCallToMessage(element: com.google.jribble.ast.ConstructorCall): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.ConstructorCall.newBuilder()
    message.setSignature(convertSignatureToMessage(element.signature))
    for(subElement <- element.params) {
      message.addParams(convertExpressionToMessage(subElement))
    }
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.ConstructorCall)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.ConstructorCall.aST, message.build())
    headMessage
  }
  def convertContinueToMessage(element: com.google.jribble.ast.Continue): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificContinueToMessage(element).build()
  }
  private def convertSpecificContinueToMessage(element: com.google.jribble.ast.Continue): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.Continue.newBuilder()
    if(element.label != None) message.setLabel(element.label.get)
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Continue)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Continue.aST, message.build())
    headMessage
  }
  def convertDeclaredTypeToMessage(element: com.google.jribble.ast.DeclaredType): com.google.jribble.ast.JribbleProtos.DeclaredType = {
    element match {
      case subElement: com.google.jribble.ast.InterfaceDef => convertInterfaceDefToMessage(subElement)
      case subElement: com.google.jribble.ast.ClassDef => convertClassDefToMessage(subElement)
      case _ => convertSpecificDeclaredTypeToMessage(element).build()
    }
  }
  private def convertSpecificDeclaredTypeToMessage(element: com.google.jribble.ast.DeclaredType): com.google.jribble.ast.JribbleProtos.DeclaredType.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.DeclaredType.newBuilder()
    message
  }
  def convertDivideToMessage(element: com.google.jribble.ast.Divide): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificDivideToMessage(element).build()
  }
  private def convertSpecificDivideToMessage(element: com.google.jribble.ast.Divide): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.Divide.newBuilder()
    message.setLhs(convertExpressionToMessage(element.lhs))
    message.setRhs(convertExpressionToMessage(element.rhs))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Divide)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Divide.aST, message.build())
    headMessage
  }
  def convertDoubleLiteralToMessage(element: com.google.jribble.ast.DoubleLiteral): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificDoubleLiteralToMessage(element).build()
  }
  private def convertSpecificDoubleLiteralToMessage(element: com.google.jribble.ast.DoubleLiteral): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.DoubleLiteral.newBuilder()
    message.setV(element.v)
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.DoubleLiteral)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.DoubleLiteral.aST, message.build())
    headMessage
  }
  def convertEqualToMessage(element: com.google.jribble.ast.Equal): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificEqualToMessage(element).build()
  }
  private def convertSpecificEqualToMessage(element: com.google.jribble.ast.Equal): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.Equal.newBuilder()
    message.setLhs(convertExpressionToMessage(element.lhs))
    message.setRhs(convertExpressionToMessage(element.rhs))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Equal)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Equal.aST, message.build())
    headMessage
  }
  def convertExpressionToMessage(element: com.google.jribble.ast.Expression): com.google.jribble.ast.JribbleProtos.AST = {
    element match {
      case subElement: com.google.jribble.ast.ArrayLength => convertArrayLengthToMessage(subElement)
      case subElement: com.google.jribble.ast.NewArray => convertNewArrayToMessage(subElement)
      case subElement: com.google.jribble.ast.ArrayRef => convertArrayRefToMessage(subElement)
      case subElement: com.google.jribble.ast.UnaryOp => convertUnaryOpToMessage(subElement)
      case subElement: com.google.jribble.ast.BinaryOp => convertBinaryOpToMessage(subElement)
      case subElement: com.google.jribble.ast.StaticFieldRef => convertStaticFieldRefToMessage(subElement)
      case subElement: com.google.jribble.ast.FieldRef => convertFieldRefToMessage(subElement)
      case subElement: com.google.jribble.ast.ClassOf => convertClassOfToMessage(subElement)
      case subElement: com.google.jribble.ast.Cast => convertCastToMessage(subElement)
      case subElement: com.google.jribble.ast.InstanceOf => convertInstanceOfToMessage(subElement)
      case subElement: com.google.jribble.ast.Conditional => convertConditionalToMessage(subElement)
      case subElement: com.google.jribble.ast.StaticMethodCall => convertStaticMethodCallToMessage(subElement)
      case subElement: com.google.jribble.ast.MethodCall => convertMethodCallToMessage(subElement)
      case subElement: com.google.jribble.ast.NewCall => convertNewCallToMessage(subElement)
      case subElement: com.google.jribble.ast.ArrayInitializer => convertArrayInitializerToMessage(subElement)
      case com.google.jribble.ast.SuperRef => convertSuperRefToMessage()
      case com.google.jribble.ast.ThisRef => convertThisRefToMessage()
      case subElement: com.google.jribble.ast.VarRef => convertVarRefToMessage(subElement)
      case subElement: com.google.jribble.ast.Literal => convertLiteralToMessage(subElement)
      case _ => convertSpecificExpressionToMessage(element).build()
    }
  }
  private def convertSpecificExpressionToMessage(element: com.google.jribble.ast.Expression): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Expression)
    headMessage
  }
  def convertFieldDefToMessage(element: com.google.jribble.ast.FieldDef): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificFieldDefToMessage(element).build()
  }
  private def convertSpecificFieldDefToMessage(element: com.google.jribble.ast.FieldDef): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.FieldDef.newBuilder()
    for(subElement <- element.modifs) {
      message.addModifs(subElement)
    }
    message.setTyp(convertTypeToMessage(element.typ))
    message.setName(element.name)
    if(element.value != None) message.setValue(convertExpressionToMessage(element.value.get))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.FieldDef)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.FieldDef.aST, message.build())
    headMessage
  }
  def convertFieldRefToMessage(element: com.google.jribble.ast.FieldRef): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificFieldRefToMessage(element).build()
  }
  private def convertSpecificFieldRefToMessage(element: com.google.jribble.ast.FieldRef): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.FieldRef.newBuilder()
    message.setOn(convertExpressionToMessage(element.on))
    message.setOnType(convertTypeToMessage(element.onType))
    message.setName(element.name)
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.FieldRef)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.FieldRef.aST, message.build())
    headMessage
  }
  def convertFloatLiteralToMessage(element: com.google.jribble.ast.FloatLiteral): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificFloatLiteralToMessage(element).build()
  }
  private def convertSpecificFloatLiteralToMessage(element: com.google.jribble.ast.FloatLiteral): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.FloatLiteral.newBuilder()
    message.setV(element.v)
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.FloatLiteral)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.FloatLiteral.aST, message.build())
    headMessage
  }
  def convertGreaterToMessage(element: com.google.jribble.ast.Greater): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificGreaterToMessage(element).build()
  }
  private def convertSpecificGreaterToMessage(element: com.google.jribble.ast.Greater): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.Greater.newBuilder()
    message.setLhs(convertExpressionToMessage(element.lhs))
    message.setRhs(convertExpressionToMessage(element.rhs))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Greater)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Greater.aST, message.build())
    headMessage
  }
  def convertGreaterOrEqualToMessage(element: com.google.jribble.ast.GreaterOrEqual): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificGreaterOrEqualToMessage(element).build()
  }
  private def convertSpecificGreaterOrEqualToMessage(element: com.google.jribble.ast.GreaterOrEqual): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.GreaterOrEqual.newBuilder()
    message.setLhs(convertExpressionToMessage(element.lhs))
    message.setRhs(convertExpressionToMessage(element.rhs))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.GreaterOrEqual)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.GreaterOrEqual.aST, message.build())
    headMessage
  }
  def convertIfToMessage(element: com.google.jribble.ast.If): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificIfToMessage(element).build()
  }
  private def convertSpecificIfToMessage(element: com.google.jribble.ast.If): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.If.newBuilder()
    message.setCondition(convertExpressionToMessage(element.condition))
    message.setThen(convertBlockToMessage(element.then))
    if(element.elsee != None) message.setElsee(convertBlockToMessage(element.elsee.get))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.If)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.If.aST, message.build())
    headMessage
  }
  def convertInstanceOfToMessage(element: com.google.jribble.ast.InstanceOf): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificInstanceOfToMessage(element).build()
  }
  private def convertSpecificInstanceOfToMessage(element: com.google.jribble.ast.InstanceOf): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.InstanceOf.newBuilder()
    message.setOn(convertExpressionToMessage(element.on))
    message.setTyp(convertTypeToMessage(element.typ))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.InstanceOf)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.InstanceOf.aST, message.build())
    headMessage
  }
  def convertIntLiteralToMessage(element: com.google.jribble.ast.IntLiteral): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificIntLiteralToMessage(element).build()
  }
  private def convertSpecificIntLiteralToMessage(element: com.google.jribble.ast.IntLiteral): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.IntLiteral.newBuilder()
    message.setV(element.v)
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.IntLiteral)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.IntLiteral.aST, message.build())
    headMessage
  }
  def convertInterfaceDefToMessage(element: com.google.jribble.ast.InterfaceDef): com.google.jribble.ast.JribbleProtos.DeclaredType = {
    convertSpecificInterfaceDefToMessage(element).build()
  }
  private def convertSpecificInterfaceDefToMessage(element: com.google.jribble.ast.InterfaceDef): com.google.jribble.ast.JribbleProtos.DeclaredType.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.InterfaceDef.newBuilder()
    for(subElement <- element.modifs) {
      message.addModifs(subElement)
    }
    message.setName(convertRefToMessage(element.name))
    for(subElement <- element.ext) {
      message.addExt(convertRefToMessage(subElement))
    }
    for(subElement <- element.body) {
      message.addBody(convertMethodDefToMessage(subElement))
    }
    val headMessage = convertSpecificDeclaredTypeToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.DeclaredType.MessageType.InterfaceDef)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.InterfaceDef.declaredType, message.build())
    headMessage
  }
  def convertLesserToMessage(element: com.google.jribble.ast.Lesser): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificLesserToMessage(element).build()
  }
  private def convertSpecificLesserToMessage(element: com.google.jribble.ast.Lesser): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.Lesser.newBuilder()
    message.setLhs(convertExpressionToMessage(element.lhs))
    message.setRhs(convertExpressionToMessage(element.rhs))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Lesser)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Lesser.aST, message.build())
    headMessage
  }
  def convertLesserOrEqualToMessage(element: com.google.jribble.ast.LesserOrEqual): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificLesserOrEqualToMessage(element).build()
  }
  private def convertSpecificLesserOrEqualToMessage(element: com.google.jribble.ast.LesserOrEqual): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.LesserOrEqual.newBuilder()
    message.setLhs(convertExpressionToMessage(element.lhs))
    message.setRhs(convertExpressionToMessage(element.rhs))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.LesserOrEqual)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.LesserOrEqual.aST, message.build())
    headMessage
  }
  def convertLiteralToMessage(element: com.google.jribble.ast.Literal): com.google.jribble.ast.JribbleProtos.AST = {
    element match {
      case subElement: com.google.jribble.ast.StringLiteral => convertStringLiteralToMessage(subElement)
      case com.google.jribble.ast.NullLiteral => convertNullLiteralToMessage()
      case subElement: com.google.jribble.ast.LongLiteral => convertLongLiteralToMessage(subElement)
      case subElement: com.google.jribble.ast.IntLiteral => convertIntLiteralToMessage(subElement)
      case subElement: com.google.jribble.ast.FloatLiteral => convertFloatLiteralToMessage(subElement)
      case subElement: com.google.jribble.ast.DoubleLiteral => convertDoubleLiteralToMessage(subElement)
      case subElement: com.google.jribble.ast.CharLiteral => convertCharLiteralToMessage(subElement)
      case subElement: com.google.jribble.ast.BooleanLiteral => convertBooleanLiteralToMessage(subElement)
      case _ => convertSpecificLiteralToMessage(element).build()
    }
  }
  private def convertSpecificLiteralToMessage(element: com.google.jribble.ast.Literal): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Literal)
    headMessage
  }
  def convertLongLiteralToMessage(element: com.google.jribble.ast.LongLiteral): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificLongLiteralToMessage(element).build()
  }
  private def convertSpecificLongLiteralToMessage(element: com.google.jribble.ast.LongLiteral): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.LongLiteral.newBuilder()
    message.setV(element.v)
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.LongLiteral)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.LongLiteral.aST, message.build())
    headMessage
  }
  def convertMethodCallToMessage(element: com.google.jribble.ast.MethodCall): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificMethodCallToMessage(element).build()
  }
  private def convertSpecificMethodCallToMessage(element: com.google.jribble.ast.MethodCall): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.MethodCall.newBuilder()
    message.setOn(convertExpressionToMessage(element.on))
    message.setSignature(convertSignatureToMessage(element.signature))
    for(subElement <- element.params) {
      message.addParams(convertExpressionToMessage(subElement))
    }
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.MethodCall)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.MethodCall.aST, message.build())
    headMessage
  }
  def convertMethodDefToMessage(element: com.google.jribble.ast.MethodDef): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificMethodDefToMessage(element).build()
  }
  private def convertSpecificMethodDefToMessage(element: com.google.jribble.ast.MethodDef): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.MethodDef.newBuilder()
    for(subElement <- element.modifs) {
      message.addModifs(subElement)
    }
    message.setReturnType(convertTypeToMessage(element.returnType))
    message.setName(element.name)
    for(subElement <- element.params) {
      message.addParams(convertParamDefToMessage(subElement))
    }
    if(element.body != None) message.setBody(convertBlockToMessage(element.body.get))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.MethodDef)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.MethodDef.aST, message.build())
    headMessage
  }
  def convertMinusToMessage(element: com.google.jribble.ast.Minus): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificMinusToMessage(element).build()
  }
  private def convertSpecificMinusToMessage(element: com.google.jribble.ast.Minus): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.Minus.newBuilder()
    message.setLhs(convertExpressionToMessage(element.lhs))
    message.setRhs(convertExpressionToMessage(element.rhs))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Minus)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Minus.aST, message.build())
    headMessage
  }
  def convertModulusToMessage(element: com.google.jribble.ast.Modulus): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificModulusToMessage(element).build()
  }
  private def convertSpecificModulusToMessage(element: com.google.jribble.ast.Modulus): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.Modulus.newBuilder()
    message.setLhs(convertExpressionToMessage(element.lhs))
    message.setRhs(convertExpressionToMessage(element.rhs))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Modulus)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Modulus.aST, message.build())
    headMessage
  }
  def convertMultiplyToMessage(element: com.google.jribble.ast.Multiply): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificMultiplyToMessage(element).build()
  }
  private def convertSpecificMultiplyToMessage(element: com.google.jribble.ast.Multiply): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.Multiply.newBuilder()
    message.setLhs(convertExpressionToMessage(element.lhs))
    message.setRhs(convertExpressionToMessage(element.rhs))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Multiply)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Multiply.aST, message.build())
    headMessage
  }
  def convertNewArrayToMessage(element: com.google.jribble.ast.NewArray): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificNewArrayToMessage(element).build()
  }
  private def convertSpecificNewArrayToMessage(element: com.google.jribble.ast.NewArray): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.NewArray.newBuilder()
    message.setTyp(convertTypeToMessage(element.typ))
    for(subElement <- element.dims) {
      val subMessage = com.google.jribble.ast.JribbleProtos.NewArray.Dims.newBuilder()
      if(subElement != None) {
        subMessage.setT(convertExpressionToMessage(subElement.get))
      }
      message.addDims(subMessage.build())
    }
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.NewArray)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.NewArray.aST, message.build())
    headMessage
  }
  def convertNewCallToMessage(element: com.google.jribble.ast.NewCall): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificNewCallToMessage(element).build()
  }
  private def convertSpecificNewCallToMessage(element: com.google.jribble.ast.NewCall): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.NewCall.newBuilder()
    message.setConstructor(convertConstructorCallToMessage(element.constructor))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.NewCall)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.NewCall.aST, message.build())
    headMessage
  }
  def convertNotToMessage(element: com.google.jribble.ast.Not): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificNotToMessage(element).build()
  }
  private def convertSpecificNotToMessage(element: com.google.jribble.ast.Not): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.Not.newBuilder()
    message.setExpression(convertExpressionToMessage(element.expression))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Not)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Not.aST, message.build())
    headMessage
  }
  def convertNotEqualToMessage(element: com.google.jribble.ast.NotEqual): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificNotEqualToMessage(element).build()
  }
  private def convertSpecificNotEqualToMessage(element: com.google.jribble.ast.NotEqual): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.NotEqual.newBuilder()
    message.setLhs(convertExpressionToMessage(element.lhs))
    message.setRhs(convertExpressionToMessage(element.rhs))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.NotEqual)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.NotEqual.aST, message.build())
    headMessage
  }
  def convertNullLiteralToMessage(): com.google.jribble.ast.JribbleProtos.AST = {
    val message = convertSpecificASTToMessage(com.google.jribble.ast.NullLiteral)
    message.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.NullLiteral)
    message.build()
  }
  def convertOrToMessage(element: com.google.jribble.ast.Or): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificOrToMessage(element).build()
  }
  private def convertSpecificOrToMessage(element: com.google.jribble.ast.Or): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.Or.newBuilder()
    message.setLhs(convertExpressionToMessage(element.lhs))
    message.setRhs(convertExpressionToMessage(element.rhs))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Or)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Or.aST, message.build())
    headMessage
  }
  def convertPackageToMessage(element: com.google.jribble.ast.Package): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificPackageToMessage(element).build()
  }
  private def convertSpecificPackageToMessage(element: com.google.jribble.ast.Package): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.Package.newBuilder()
    message.setName(element.name)
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Package)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Package.aST, message.build())
    headMessage
  }
  def convertParamDefToMessage(element: com.google.jribble.ast.ParamDef): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificParamDefToMessage(element).build()
  }
  private def convertSpecificParamDefToMessage(element: com.google.jribble.ast.ParamDef): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.ParamDef.newBuilder()
    message.setName(element.name)
    message.setTyp(convertTypeToMessage(element.typ))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.ParamDef)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.ParamDef.aST, message.build())
    headMessage
  }
  def convertPlusToMessage(element: com.google.jribble.ast.Plus): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificPlusToMessage(element).build()
  }
  private def convertSpecificPlusToMessage(element: com.google.jribble.ast.Plus): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.Plus.newBuilder()
    message.setLhs(convertExpressionToMessage(element.lhs))
    message.setRhs(convertExpressionToMessage(element.rhs))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Plus)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Plus.aST, message.build())
    headMessage
  }
  def convertPrimitiveToMessage(element: com.google.jribble.ast.Primitive): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificPrimitiveToMessage(element).build()
  }
  private def convertSpecificPrimitiveToMessage(element: com.google.jribble.ast.Primitive): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.Primitive.newBuilder()
    message.setName(element.name)
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Primitive)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Primitive.aST, message.build())
    headMessage
  }
  def convertRefToMessage(element: com.google.jribble.ast.Ref): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificRefToMessage(element).build()
  }
  private def convertSpecificRefToMessage(element: com.google.jribble.ast.Ref): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.Ref.newBuilder()
    if(element.pkg != None) message.setPkg(convertPackageToMessage(element.pkg.get))
    message.setName(element.name)
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Ref)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Ref.aST, message.build())
    headMessage
  }
  def convertReturnToMessage(element: com.google.jribble.ast.Return): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificReturnToMessage(element).build()
  }
  private def convertSpecificReturnToMessage(element: com.google.jribble.ast.Return): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.Return.newBuilder()
    if(element.expression != None) message.setExpression(convertExpressionToMessage(element.expression.get))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Return)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Return.aST, message.build())
    headMessage
  }
  def convertSignatureToMessage(element: com.google.jribble.ast.Signature): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificSignatureToMessage(element).build()
  }
  private def convertSpecificSignatureToMessage(element: com.google.jribble.ast.Signature): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.Signature.newBuilder()
    message.setOn(convertRefToMessage(element.on))
    message.setName(element.name)
    for(subElement <- element.paramTypes) {
      message.addParamTypes(convertTypeToMessage(subElement))
    }
    message.setReturnType(convertTypeToMessage(element.returnType))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Signature)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Signature.aST, message.build())
    headMessage
  }
  def convertStatementToMessage(element: com.google.jribble.ast.Statement): com.google.jribble.ast.JribbleProtos.AST = {
    element match {
      case subElement: com.google.jribble.ast.Expression => convertExpressionToMessage(subElement)
      case subElement: com.google.jribble.ast.ConstructorCall => convertConstructorCallToMessage(subElement)
      case subElement: com.google.jribble.ast.Throw => convertThrowToMessage(subElement)
      case subElement: com.google.jribble.ast.Return => convertReturnToMessage(subElement)
      case subElement: com.google.jribble.ast.Switch => convertSwitchToMessage(subElement)
      case subElement: com.google.jribble.ast.Break => convertBreakToMessage(subElement)
      case subElement: com.google.jribble.ast.Continue => convertContinueToMessage(subElement)
      case subElement: com.google.jribble.ast.While => convertWhileToMessage(subElement)
      case subElement: com.google.jribble.ast.Try => convertTryToMessage(subElement)
      case subElement: com.google.jribble.ast.If => convertIfToMessage(subElement)
      case subElement: com.google.jribble.ast.Assignment => convertAssignmentToMessage(subElement)
      case subElement: com.google.jribble.ast.VarDef => convertVarDefToMessage(subElement)
      case subElement: com.google.jribble.ast.Block => convertBlockToMessage(subElement)
      case _ => convertSpecificStatementToMessage(element).build()
    }
  }
  private def convertSpecificStatementToMessage(element: com.google.jribble.ast.Statement): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Statement)
    headMessage
  }
  def convertStaticFieldRefToMessage(element: com.google.jribble.ast.StaticFieldRef): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificStaticFieldRefToMessage(element).build()
  }
  private def convertSpecificStaticFieldRefToMessage(element: com.google.jribble.ast.StaticFieldRef): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.StaticFieldRef.newBuilder()
    message.setOn(convertRefToMessage(element.on))
    message.setName(element.name)
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.StaticFieldRef)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.StaticFieldRef.aST, message.build())
    headMessage
  }
  def convertStaticMethodCallToMessage(element: com.google.jribble.ast.StaticMethodCall): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificStaticMethodCallToMessage(element).build()
  }
  private def convertSpecificStaticMethodCallToMessage(element: com.google.jribble.ast.StaticMethodCall): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.StaticMethodCall.newBuilder()
    message.setClassRef(convertRefToMessage(element.classRef))
    message.setSignature(convertSignatureToMessage(element.signature))
    for(subElement <- element.params) {
      message.addParams(convertExpressionToMessage(subElement))
    }
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.StaticMethodCall)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.StaticMethodCall.aST, message.build())
    headMessage
  }
  def convertStringLiteralToMessage(element: com.google.jribble.ast.StringLiteral): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificStringLiteralToMessage(element).build()
  }
  private def convertSpecificStringLiteralToMessage(element: com.google.jribble.ast.StringLiteral): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.StringLiteral.newBuilder()
    message.setV(element.v)
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.StringLiteral)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.StringLiteral.aST, message.build())
    headMessage
  }
  def convertSuperRefToMessage(): com.google.jribble.ast.JribbleProtos.AST = {
    val message = convertSpecificASTToMessage(com.google.jribble.ast.SuperRef)
    message.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.SuperRef)
    message.build()
  }
  def convertSwitchToMessage(element: com.google.jribble.ast.Switch): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificSwitchToMessage(element).build()
  }
  private def convertSpecificSwitchToMessage(element: com.google.jribble.ast.Switch): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.Switch.newBuilder()
    message.setExpression(convertExpressionToMessage(element.expression))
    for(subElement <- element.groups) {
      val subMessage = com.google.jribble.ast.JribbleProtos.Switch.Groups.newBuilder()
      subMessage.setT0(convertLiteralToMessage(subElement._1))
      subMessage.setT1(convertBlockToMessage(subElement._2))
      message.addGroups(subMessage.build())
    }
    if(element.default != None) message.setDefault(convertBlockToMessage(element.default.get))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Switch)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Switch.aST, message.build())
    headMessage
  }
  def convertThisRefToMessage(): com.google.jribble.ast.JribbleProtos.AST = {
    val message = convertSpecificASTToMessage(com.google.jribble.ast.ThisRef)
    message.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.ThisRef)
    message.build()
  }
  def convertThrowToMessage(element: com.google.jribble.ast.Throw): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificThrowToMessage(element).build()
  }
  private def convertSpecificThrowToMessage(element: com.google.jribble.ast.Throw): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.Throw.newBuilder()
    message.setExpression(convertExpressionToMessage(element.expression))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Throw)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Throw.aST, message.build())
    headMessage
  }
  def convertTryToMessage(element: com.google.jribble.ast.Try): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificTryToMessage(element).build()
  }
  private def convertSpecificTryToMessage(element: com.google.jribble.ast.Try): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.Try.newBuilder()
    message.setBlock(convertBlockToMessage(element.block))
    for(subElement <- element.catches) {
      val subMessage = com.google.jribble.ast.JribbleProtos.Try.Catches.newBuilder()
      subMessage.setT0(convertRefToMessage(subElement._1))
      subMessage.setT1(subElement._2)
      subMessage.setT2(convertBlockToMessage(subElement._3))
      message.addCatches(subMessage.build())
    }
    if(element.finalizer != None) message.setFinalizer(convertBlockToMessage(element.finalizer.get))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Try)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.Try.aST, message.build())
    headMessage
  }
  def convertTypeToMessage(element: com.google.jribble.ast.Type): com.google.jribble.ast.JribbleProtos.AST = {
    element match {
      case com.google.jribble.ast.Void => convertVoidToMessage()
      case subElement: com.google.jribble.ast.Array => convertArrayToMessage(subElement)
      case subElement: com.google.jribble.ast.Primitive => convertPrimitiveToMessage(subElement)
      case subElement: com.google.jribble.ast.Ref => convertRefToMessage(subElement)
      case _ => convertSpecificTypeToMessage(element).build()
    }
  }
  private def convertSpecificTypeToMessage(element: com.google.jribble.ast.Type): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Type)
    headMessage
  }
  def convertUnaryMinusToMessage(element: com.google.jribble.ast.UnaryMinus): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificUnaryMinusToMessage(element).build()
  }
  private def convertSpecificUnaryMinusToMessage(element: com.google.jribble.ast.UnaryMinus): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.UnaryMinus.newBuilder()
    message.setExpression(convertExpressionToMessage(element.expression))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.UnaryMinus)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.UnaryMinus.aST, message.build())
    headMessage
  }
  def convertUnaryOpToMessage(element: com.google.jribble.ast.UnaryOp): com.google.jribble.ast.JribbleProtos.AST = {
    element match {
      case subElement: com.google.jribble.ast.BitNot => convertBitNotToMessage(subElement)
      case subElement: com.google.jribble.ast.UnaryMinus => convertUnaryMinusToMessage(subElement)
      case subElement: com.google.jribble.ast.Not => convertNotToMessage(subElement)
      case _ => convertSpecificUnaryOpToMessage(element).build()
    }
  }
  private def convertSpecificUnaryOpToMessage(element: com.google.jribble.ast.UnaryOp): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.UnaryOp.newBuilder()
    message.setSymbol(element.symbol)
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.UnaryOp)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.UnaryOp.aST, message.build())
    headMessage
  }
  def convertVarDefToMessage(element: com.google.jribble.ast.VarDef): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificVarDefToMessage(element).build()
  }
  private def convertSpecificVarDefToMessage(element: com.google.jribble.ast.VarDef): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.VarDef.newBuilder()
    message.setTyp(convertTypeToMessage(element.typ))
    message.setName(element.name)
    if(element.value != None) message.setValue(convertExpressionToMessage(element.value.get))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.VarDef)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.VarDef.aST, message.build())
    headMessage
  }
  def convertVarRefToMessage(element: com.google.jribble.ast.VarRef): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificVarRefToMessage(element).build()
  }
  private def convertSpecificVarRefToMessage(element: com.google.jribble.ast.VarRef): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.VarRef.newBuilder()
    message.setName(element.name)
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.VarRef)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.VarRef.aST, message.build())
    headMessage
  }
  def convertVoidToMessage(): com.google.jribble.ast.JribbleProtos.AST = {
    val message = convertSpecificASTToMessage(com.google.jribble.ast.Void)
    message.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.Void)
    message.build()
  }
  def convertWhileToMessage(element: com.google.jribble.ast.While): com.google.jribble.ast.JribbleProtos.AST = {
    convertSpecificWhileToMessage(element).build()
  }
  private def convertSpecificWhileToMessage(element: com.google.jribble.ast.While): com.google.jribble.ast.JribbleProtos.AST.Builder = {
    val message = com.google.jribble.ast.JribbleProtos.While.newBuilder()
    if(element.label != None) message.setLabel(element.label.get)
    message.setCondition(convertExpressionToMessage(element.condition))
    message.setBlock(convertBlockToMessage(element.block))
    val headMessage = convertSpecificASTToMessage(element)
    headMessage.setType(com.google.jribble.ast.JribbleProtos.AST.MessageType.While)
    headMessage.setExtension(com.google.jribble.ast.JribbleProtos.While.aST, message.build())
    headMessage
  }
}
