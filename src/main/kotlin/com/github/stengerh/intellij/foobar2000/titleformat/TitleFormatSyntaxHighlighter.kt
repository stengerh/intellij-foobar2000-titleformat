package com.github.stengerh.intellij.foobar2000.titleformat

import com.github.stengerh.intellij.foobar2000.titleformat.psi.TitleFormatTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType

class TitleFormatSyntaxHighlighter : SyntaxHighlighterBase() {
    companion object {
        val COMMENT: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "TITLEFORMAT_COMMENT",
            DefaultLanguageHighlighterColors.LINE_COMMENT
        )
        val COMMA: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "TITLEFORMAT_COMMA",
            DefaultLanguageHighlighterColors.COMMA
        )
        val BRACKETS: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "TITLEFORMAT_BRACKETS",
            DefaultLanguageHighlighterColors.BRACKETS
        )
        val PARENTHESES: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "TITLEFORMAT_PARENTHS",
            DefaultLanguageHighlighterColors.PARENTHESES
        )
        val FIELD: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "TITLEFORMAT_FIELD",
            DefaultLanguageHighlighterColors.INSTANCE_FIELD
        )
        val FUNCTION_CALL: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "TITLEFORMAT_FUNCTION_CALL",
            DefaultLanguageHighlighterColors.FUNCTION_CALL
        )
        val QUOTED_STRING: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "TITLEFORMAT_QUOTED_STRING",
            DefaultLanguageHighlighterColors.STRING
        )
        val VERBATIM_TEXT: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "TITLEFORMAT_UNQUOTED_STRING",
            DefaultLanguageHighlighterColors.STRING
        )
        val SPECIAL_CHAR: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "TITLEFORMAT_SPECIAL_CHAR",
            DefaultLanguageHighlighterColors.STRING
        )

        val COMMENT_KEYS: Array<TextAttributesKey> = arrayOf(COMMENT)
        val COMMA_KEYS: Array<TextAttributesKey> = arrayOf(COMMA)
        val BRACKETS_KEYS: Array<TextAttributesKey> = arrayOf(BRACKETS)
        val PARENTHESES_KEYS: Array<TextAttributesKey> = arrayOf(PARENTHESES)
        val FIELD_KEYS: Array<TextAttributesKey> = arrayOf(FIELD)
        val FUNCTION_CALL_KEYS: Array<TextAttributesKey> = arrayOf(FUNCTION_CALL)
        val QUOTED_STRING_KEYS: Array<TextAttributesKey> = arrayOf(QUOTED_STRING)
        val VERBATIM_TEXT_KEYS: Array<TextAttributesKey> = arrayOf(VERBATIM_TEXT)
        val SPECIAL_CHAR_KEYS: Array<TextAttributesKey> = arrayOf(SPECIAL_CHAR)
        val EMPTY_KEYS: Array<TextAttributesKey> = arrayOf()
    }

    override fun getHighlightingLexer(): Lexer = TitleFormatLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        return when {
            TitleFormatTypes.COMMENT.equals(tokenType) -> {
                COMMENT_KEYS
            }
            TitleFormatTypes.LEFT_BRACKET.equals(tokenType)
                    || TitleFormatTypes.RIGHT_BRACKET.equals(tokenType) -> {
                BRACKETS_KEYS
            }
            TitleFormatTypes.LEFT_PAREN.equals(tokenType)
                    || TitleFormatTypes.RIGHT_PAREN.equals(tokenType) -> {
                PARENTHESES_KEYS
            }
            TitleFormatTypes.COMMA.equals(tokenType) -> {
                COMMA_KEYS
            }
            TitleFormatTypes.PERCENT.equals(tokenType)
                    || TitleFormatTypes.FIELD_NAME.equals(tokenType) -> {
                FIELD_KEYS
            }
            TitleFormatTypes.DOLLAR.equals(tokenType)
                    || TitleFormatTypes.FUNCTION_NAME.equals(tokenType) -> {
                FUNCTION_CALL_KEYS
            }
            TitleFormatTypes.QUOTE.equals(tokenType)
                    || TitleFormatTypes.QUOTED_STRING_PART.equals(tokenType) -> {
                QUOTED_STRING_KEYS
            }
            TitleFormatTypes.VERBATIM_TEXT.equals(tokenType) -> {
                VERBATIM_TEXT_KEYS
            }
            TitleFormatTypes.DOLLAR_DOLLAR.equals(tokenType)
                    || TitleFormatTypes.PERCENT_PERCENT.equals(tokenType)
                    || TitleFormatTypes.QUOTE_QUOTE.equals(tokenType) -> {
                SPECIAL_CHAR_KEYS
            }
            else -> {
                EMPTY_KEYS
            }
        }
    }
}