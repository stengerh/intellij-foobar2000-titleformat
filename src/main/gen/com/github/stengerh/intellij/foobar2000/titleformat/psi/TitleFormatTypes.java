// This is a generated file. Not intended for manual editing.
package com.github.stengerh.intellij.foobar2000.titleformat.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.stengerh.intellij.foobar2000.titleformat.psi.impl.*;

public interface TitleFormatTypes {

  IElementType CHAR_LITERAL = new TitleFormatElementType("CHAR_LITERAL");
  IElementType COMMENT = new TitleFormatElementType("COMMENT");
  IElementType FIELD_EXPRESSION = new TitleFormatElementType("FIELD_EXPRESSION");
  IElementType FUNCTION_CALL_EXPRESSION = new TitleFormatElementType("FUNCTION_CALL_EXPRESSION");
  IElementType OPTIONAL_EXPRESSION = new TitleFormatElementType("OPTIONAL_EXPRESSION");
  IElementType QUOTED_STRING_LITERAL = new TitleFormatElementType("QUOTED_STRING_LITERAL");
  IElementType SEQUENCE_EXPRESSION = new TitleFormatElementType("SEQUENCE_EXPRESSION");
  IElementType VERBATIM_STRING_LITERAL = new TitleFormatElementType("VERBATIM_STRING_LITERAL");

  IElementType COMMA = new TitleFormatTokenType(",");
  IElementType DOLLAR = new TitleFormatTokenType("$");
  IElementType DOLLAR_DOLLAR = new TitleFormatTokenType("$$");
  IElementType END_OF_LINE = new TitleFormatTokenType("END_OF_LINE");
  IElementType FIELD_NAME = new TitleFormatTokenType("FIELD_NAME");
  IElementType FUNCTION_NAME = new TitleFormatTokenType("FUNCTION_NAME");
  IElementType LEFT_BRACKET = new TitleFormatTokenType("[");
  IElementType LEFT_PAREN = new TitleFormatTokenType("(");
  IElementType LINE_COMMENT = new TitleFormatTokenType("LINE_COMMENT");
  IElementType PERCENT = new TitleFormatTokenType("%");
  IElementType PERCENT_PERCENT = new TitleFormatTokenType("%%");
  IElementType QUOTE = new TitleFormatTokenType("'");
  IElementType QUOTED_STRING_PART = new TitleFormatTokenType("QUOTED_STRING_PART");
  IElementType QUOTE_QUOTE = new TitleFormatTokenType("''");
  IElementType RIGHT_BRACKET = new TitleFormatTokenType("]");
  IElementType RIGHT_PAREN = new TitleFormatTokenType(")");
  IElementType VERBATIM_TEXT = new TitleFormatTokenType("VERBATIM_TEXT");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == CHAR_LITERAL) {
        return new TitleFormatCharLiteralImpl(node);
      }
      else if (type == COMMENT) {
        return new TitleFormatCommentImpl(node);
      }
      else if (type == FIELD_EXPRESSION) {
        return new TitleFormatFieldExpressionImpl(node);
      }
      else if (type == FUNCTION_CALL_EXPRESSION) {
        return new TitleFormatFunctionCallExpressionImpl(node);
      }
      else if (type == OPTIONAL_EXPRESSION) {
        return new TitleFormatOptionalExpressionImpl(node);
      }
      else if (type == QUOTED_STRING_LITERAL) {
        return new TitleFormatQuotedStringLiteralImpl(node);
      }
      else if (type == SEQUENCE_EXPRESSION) {
        return new TitleFormatSequenceExpressionImpl(node);
      }
      else if (type == VERBATIM_STRING_LITERAL) {
        return new TitleFormatVerbatimStringLiteralImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
