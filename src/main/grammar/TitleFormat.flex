package com.github.stengerh.intellij.foobar2000.titleformat;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
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

%xstate COMMENT, STRING, FIELD, FUNCTION

END_OF_LINE=\r?\n
FUNCTION_NAME=[^$()\r\n]+
FIELD_NAME=[^%\r\n]+
VERBATIM_TEXT=[^$%'\[\](),\r\n]+
QUOTED_STRING_PART = [^'\r\n]

%%
<YYINITIAL> {
  "$"                       { yybegin(FUNCTION); return DOLLAR; }
  "$$"                      { return DOLLAR_DOLLAR; }
  "'"                       { yybegin(STRING); return QUOTE; }
  "''"                      { return QUOTE_QUOTE; }
  "%"                       { yybegin(FIELD); return PERCENT; }
  "%%"                      { return PERCENT_PERCENT; }
  "["                       { return LEFT_BRACKET; }
  "]"                       { return RIGHT_BRACKET; }
  "("                       { return LEFT_PAREN; }
  ")"                       { return RIGHT_PAREN; }
  ","                       { return COMMA; }
  "//"                      { if (yycolumn == 0) { yybegin(COMMENT); } }
  {VERBATIM_TEXT}           { return VERBATIM_TEXT; }

  {END_OF_LINE}             { return END_OF_LINE; }
}

<COMMENT> {
    [^\r\n]+                { yybegin(YYINITIAL); return LINE_COMMENT; }
}

<STRING> {
  {QUOTED_STRING_PART}      { return QUOTED_STRING_PART; }
  "'"                       { yybegin(YYINITIAL); return QUOTE; }
}

<FIELD> {
  {FIELD_NAME}              { yybegin(YYINITIAL); return FIELD_NAME; }
}

<FUNCTION> {
  {FUNCTION_NAME}           { yybegin(YYINITIAL); return FUNCTION_NAME; }
}

[^] { return BAD_CHARACTER; }
