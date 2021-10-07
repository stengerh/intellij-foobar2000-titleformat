package com.github.stengerh.intellij.foobar2000.titleformat

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon

class TitleFormatColorSettingsPage : ColorSettingsPage {
    companion object {
        val DESCRIPTORS: Array<AttributesDescriptor> = arrayOf(
            AttributesDescriptor("Comment", TitleFormatSyntaxHighlighter.COMMENT),
            AttributesDescriptor("Brackets", TitleFormatSyntaxHighlighter.BRACKETS),
            AttributesDescriptor("Parentheses", TitleFormatSyntaxHighlighter.PARENTHESES),
            AttributesDescriptor("Comma", TitleFormatSyntaxHighlighter.COMMA),
        )
    }

    override fun getDisplayName(): String {
        return "Title Formatting"
    }

    override fun getIcon(): Icon {
        return TitleFormatIcons.FILE
    }

    override fun getHighlighter(): SyntaxHighlighter {
        return TitleFormatSyntaxHighlighter()
    }

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return DESCRIPTORS
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return ColorDescriptor.EMPTY_ARRAY
    }

    override fun getDemoText(): String {
        return """
            // This is a comment.
            [%artist% - ]%title%
            $${"if"}(%artist%,%artist% - ,)%title%
            'quoted string'
            verbatim text %% '' ${"$"}$
            """.trimIndent()
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey>? {
        return null
    }
}