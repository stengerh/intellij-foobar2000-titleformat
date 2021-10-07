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

%xstate STRING

END_OF_LINE=\r\n|[\r\n]
FUNCTION_NAME=\$[a-zA-Z0-9_]+
FIELD_NAME=%[^%\r\n]+%
VERBATIM_TEXT=[^$%'\[\](),\r\n]+
QUOTED_STRING_PART = [^'\r\n]+

%%
<YYINITIAL> {
  {FUNCTION_NAME}           { return FUNCTION_NAME; }
  "$$"                      { return DOLLAR_DOLLAR; }
  "'"                       { yybegin(STRING); return QUOTE; }
  "''"                      { return QUOTE_QUOTE; }
  {FIELD_NAME}              { return FIELD_NAME; }
  "%%"                      { return PERCENT_PERCENT; }
  "["                       { return LEFT_BRACKET; }
  "]"                       { return RIGHT_BRACKET; }
  "("                       { return LEFT_PAREN; }
  ")"                       { return RIGHT_PAREN; }
  ","                       { return COMMA; }
  ^"//"[^\r\n]*             { return LINE_COMMENT; }
  {VERBATIM_TEXT}           { return VERBATIM_TEXT; }

  {END_OF_LINE}             { return END_OF_LINE; }
}

<STRING> {
  {QUOTED_STRING_PART}      { return QUOTED_STRING_PART; }
  "'"                       { yybegin(YYINITIAL); return QUOTE; }
  {END_OF_LINE}             { return END_OF_LINE; }
}

[^] { return BAD_CHARACTER; }
