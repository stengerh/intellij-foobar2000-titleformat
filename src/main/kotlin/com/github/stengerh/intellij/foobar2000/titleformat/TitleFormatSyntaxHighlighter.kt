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

        val COMMENT_KEYS: Array<TextAttributesKey> = arrayOf(COMMENT)
        val COMMA_KEYS: Array<TextAttributesKey> = arrayOf(COMMA)
        val BRACKETS_KEYS: Array<TextAttributesKey> = arrayOf(BRACKETS)
        val PARENTHESES_KEYS: Array<TextAttributesKey> = arrayOf(PARENTHESES)
        val EMPTY_KEYS: Array<TextAttributesKey> = arrayOf()
    }

    override fun getHighlightingLexer(): Lexer = TitleFormatLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        if (TitleFormatTypes.COMMENT.equals(tokenType)) {
            return COMMENT_KEYS
        } else if (TitleFormatTypes.LEFT_BRACKET.equals(tokenType) || TitleFormatTypes.RIGHT_BRACKET.equals(tokenType)) {
            return BRACKETS_KEYS
        } else if (TitleFormatTypes.LEFT_PAREN.equals(tokenType) || TitleFormatTypes.RIGHT_PAREN.equals(tokenType)) {
            return PARENTHESES_KEYS
        } else if (TitleFormatTypes.COMMA.equals(tokenType)) {
            return COMMA_KEYS
        } else {
            return EMPTY_KEYS
        }
    }
}