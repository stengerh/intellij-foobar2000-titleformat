package com.github.stengerh.intellij.foobar2000.titleformat;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import javax.annotation.processing.Generated;import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.github.stengerh.intellij.foobar2000.titleformat.psi.TitleFormatTypes.*;

%%

%{
  private int yycolumn = 0;

  public TitleFormatLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class TitleFormatLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode
%column

%xstate COMMENT

END_OF_LINE=\r?\n
FUNCTION_NAME=[^$()\r\n]+
FIELD_NAME=[^%\r\n]+
VERBATIM_TEXT=[^$%'\[\](),\r\n]+
QUOTED_STRING_PART = [^'\r\n]

%%
<YYINITIAL> {
  "$"                       { return DOLLAR; }
  "$$"                      { return DOLLAR_DOLLAR; }
  "'"                       { return QUOTE; }
  "''"                      { return QUOTE_QUOTE; }
  "%"                       { return PERCENT; }
  "%%"                      { return PERCENT_PERCENT; }
  "["                       { return LEFT_BRACKET; }
  "]"                       { return RIGHT_BRACKET; }
  "("                       { return LEFT_PAREN; }
  ")"                       { return RIGHT_PAREN; }
  "//"                      { if (yycolumn == 0) { yybegin(COMMENT); } }
  {QUOTED_STRING_PART}      { return QUOTED_STRING_PART; }
  {VERBATIM_TEXT}           { return VERBATIM_TEXT; }

  {END_OF_LINE}             { return END_OF_LINE; }
  {FUNCTION_NAME}           { return FUNCTION_NAME; }
  {FIELD_NAME}              { return FIELD_NAME; }
}

<COMMENT> {
    [^\r\n]+                { yybegin(YYINITIAL); return LINE_COMMENT; }
}

[^] { return BAD_CHARACTER; }
