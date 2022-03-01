// This is a generated file. Not intended for manual editing.
package com.litarvan.tigeridea.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.litarvan.tigeridea.psi.impl.*;

public interface TigerTypes {

  IElementType CHUNK = new TigerElementType("CHUNK");
  IElementType CHUNKS = new TigerElementType("CHUNKS");
  IElementType EXPRESSION = new TigerElementType("EXPRESSION");
  IElementType EXPRESSIONS = new TigerElementType("EXPRESSIONS");
  IElementType EXPRESSION_PART = new TigerElementType("EXPRESSION_PART");
  IElementType FUNCTION_DECLARATION = new TigerElementType("FUNCTION_DECLARATION");
  IElementType LVALUE = new TigerElementType("LVALUE");
  IElementType LVALUE_SUFFIX = new TigerElementType("LVALUE_SUFFIX");
  IElementType OPERATOR = new TigerElementType("OPERATOR");
  IElementType PARAMETERS = new TigerElementType("PARAMETERS");
  IElementType TYPE_DECLARATION = new TigerElementType("TYPE_DECLARATION");
  IElementType TYPE_ID = new TigerElementType("TYPE_ID");
  IElementType TYPE_REF = new TigerElementType("TYPE_REF");
  IElementType VARIABLE_DECLARATION = new TigerElementType("VARIABLE_DECLARATION");

  IElementType AND = new TigerTokenType("AND");
  IElementType ARRAY = new TigerTokenType("ARRAY");
  IElementType ASSIGN = new TigerTokenType("ASSIGN");
  IElementType BREAK = new TigerTokenType("BREAK");
  IElementType COLON = new TigerTokenType("COLON");
  IElementType COMMA = new TigerTokenType("COMMA");
  IElementType DIVIDES = new TigerTokenType("DIVIDES");
  IElementType DO = new TigerTokenType("DO");
  IElementType DOT = new TigerTokenType("DOT");
  IElementType ELSE = new TigerTokenType("ELSE");
  IElementType END = new TigerTokenType("END");
  IElementType EQUALS = new TigerTokenType("EQUALS");
  IElementType FOR = new TigerTokenType("FOR");
  IElementType FUNCTION = new TigerTokenType("FUNCTION");
  IElementType GREATER = new TigerTokenType("GREATER");
  IElementType GREATER_EQUAL = new TigerTokenType("GREATER_EQUAL");
  IElementType IDENTIFIER = new TigerTokenType("IDENTIFIER");
  IElementType IF = new TigerTokenType("IF");
  IElementType IMPORT = new TigerTokenType("IMPORT");
  IElementType IN = new TigerTokenType("IN");
  IElementType INTEGER = new TigerTokenType("INTEGER");
  IElementType LEFT_BRACE = new TigerTokenType("LEFT_BRACE");
  IElementType LEFT_BRACKET = new TigerTokenType("LEFT_BRACKET");
  IElementType LEFT_PARENTHESIS = new TigerTokenType("LEFT_PARENTHESIS");
  IElementType LET = new TigerTokenType("LET");
  IElementType LOWER = new TigerTokenType("LOWER");
  IElementType LOWER_EQUAL = new TigerTokenType("LOWER_EQUAL");
  IElementType MINUS = new TigerTokenType("MINUS");
  IElementType MULTIPLIES = new TigerTokenType("MULTIPLIES");
  IElementType NIL = new TigerTokenType("NIL");
  IElementType NOT_EQUALS = new TigerTokenType("NOT_EQUALS");
  IElementType OF = new TigerTokenType("OF");
  IElementType OR = new TigerTokenType("OR");
  IElementType PLUS = new TigerTokenType("PLUS");
  IElementType PRIMITIVE = new TigerTokenType("PRIMITIVE");
  IElementType RIGHT_BRACE = new TigerTokenType("RIGHT_BRACE");
  IElementType RIGHT_BRACKET = new TigerTokenType("RIGHT_BRACKET");
  IElementType RIGHT_PARENTHESIS = new TigerTokenType("RIGHT_PARENTHESIS");
  IElementType SEMI_COLON = new TigerTokenType("SEMI_COLON");
  IElementType STRING = new TigerTokenType("STRING");
  IElementType THEN = new TigerTokenType("THEN");
  IElementType TO = new TigerTokenType("TO");
  IElementType TYPE = new TigerTokenType("TYPE");
  IElementType VAR = new TigerTokenType("VAR");
  IElementType WHILE = new TigerTokenType("WHILE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == CHUNK) {
        return new TigerChunkImpl(node);
      }
      else if (type == CHUNKS) {
        return new TigerChunksImpl(node);
      }
      else if (type == EXPRESSION) {
        return new TigerExpressionImpl(node);
      }
      else if (type == EXPRESSIONS) {
        return new TigerExpressionsImpl(node);
      }
      else if (type == EXPRESSION_PART) {
        return new TigerExpressionPartImpl(node);
      }
      else if (type == FUNCTION_DECLARATION) {
        return new TigerFunctionDeclarationImpl(node);
      }
      else if (type == LVALUE) {
        return new TigerLvalueImpl(node);
      }
      else if (type == LVALUE_SUFFIX) {
        return new TigerLvalueSuffixImpl(node);
      }
      else if (type == OPERATOR) {
        return new TigerOperatorImpl(node);
      }
      else if (type == PARAMETERS) {
        return new TigerParametersImpl(node);
      }
      else if (type == TYPE_DECLARATION) {
        return new TigerTypeDeclarationImpl(node);
      }
      else if (type == TYPE_ID) {
        return new TigerTypeIdImpl(node);
      }
      else if (type == TYPE_REF) {
        return new TigerTypeRefImpl(node);
      }
      else if (type == VARIABLE_DECLARATION) {
        return new TigerVariableDeclarationImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
