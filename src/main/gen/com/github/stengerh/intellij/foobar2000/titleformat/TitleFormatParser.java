// This is a generated file. Not intended for manual editing.
package com.github.stengerh.intellij.foobar2000.titleformat;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.stengerh.intellij.foobar2000.titleformat.psi.TitleFormatTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class TitleFormatParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return Script(b, l + 1);
  }

  /* ********************************************************** */
  // DOLLAR_DOLLAR |
  //     PERCENT_PERCENT |
  //     QUOTE_QUOTE
  public static boolean CharLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CharLiteral")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CHAR_LITERAL, "<char literal>");
    r = consumeToken(b, DOLLAR_DOLLAR);
    if (!r) r = consumeToken(b, PERCENT_PERCENT);
    if (!r) r = consumeToken(b, QUOTE_QUOTE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LINE_COMMENT
  public static boolean Comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Comment")) return false;
    if (!nextTokenIs(b, LINE_COMMENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LINE_COMMENT);
    exit_section_(b, m, COMMENT, r);
    return r;
  }

  /* ********************************************************** */
  // Comment |
  //     Literal |
  //     OptionalExpression |
  //     FieldExpression |
  //     FunctionCallExpression
  public static boolean Expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = Comment(b, l + 1);
    if (!r) r = Literal(b, l + 1);
    if (!r) r = OptionalExpression(b, l + 1);
    if (!r) r = FieldExpression(b, l + 1);
    if (!r) r = FunctionCallExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PERCENT FIELD_NAME PERCENT
  public static boolean FieldExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldExpression")) return false;
    if (!nextTokenIs(b, PERCENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PERCENT, FIELD_NAME, PERCENT);
    exit_section_(b, m, FIELD_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // DOLLAR FUNCTION_NAME LEFT_PAREN ParameterList RIGHT_PAREN
  public static boolean FunctionCallExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionCallExpression")) return false;
    if (!nextTokenIs(b, DOLLAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOLLAR, FUNCTION_NAME, LEFT_PAREN);
    r = r && ParameterList(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, FUNCTION_CALL_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // CharLiteral |
  //     QuotedStringLiteral |
  //     VerbatimStringLiteral
  public static boolean Literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL, "<literal>");
    r = CharLiteral(b, l + 1);
    if (!r) r = QuotedStringLiteral(b, l + 1);
    if (!r) r = VerbatimStringLiteral(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACKET Expression* RIGHT_BRACKET
  public static boolean OptionalExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OptionalExpression")) return false;
    if (!nextTokenIs(b, LEFT_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACKET);
    r = r && OptionalExpression_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACKET);
    exit_section_(b, m, OPTIONAL_EXPRESSION, r);
    return r;
  }

  // Expression*
  private static boolean OptionalExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OptionalExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "OptionalExpression_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // Expression? (COMMA Expression?)*
  public static boolean ParameterList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAMETER_LIST, "<parameter list>");
    r = ParameterList_0(b, l + 1);
    r = r && ParameterList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Expression?
  private static boolean ParameterList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList_0")) return false;
    Expression(b, l + 1);
    return true;
  }

  // (COMMA Expression?)*
  private static boolean ParameterList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ParameterList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ParameterList_1", c)) break;
    }
    return true;
  }

  // COMMA Expression?
  private static boolean ParameterList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && ParameterList_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Expression?
  private static boolean ParameterList_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList_1_0_1")) return false;
    Expression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // QUOTE QUOTED_STRING_PART QUOTE
  public static boolean QuotedStringLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "QuotedStringLiteral")) return false;
    if (!nextTokenIs(b, QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, QUOTE, QUOTED_STRING_PART, QUOTE);
    exit_section_(b, m, QUOTED_STRING_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // Expression*
  static boolean Script(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Script")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Script", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // VERBATIM_TEXT
  public static boolean VerbatimStringLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VerbatimStringLiteral")) return false;
    if (!nextTokenIs(b, VERBATIM_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VERBATIM_TEXT);
    exit_section_(b, m, VERBATIM_STRING_LITERAL, r);
    return r;
  }

}
