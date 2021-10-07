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
            AttributesDescriptor(TitleFormatBundle.messagePointer("colors.page.titleformat.attribute.comment"), TitleFormatSyntaxHighlighter.COMMENT),
            AttributesDescriptor(TitleFormatBundle.messagePointer("colors.page.titleformat.attribute.brackets"), TitleFormatSyntaxHighlighter.BRACKETS),
            AttributesDescriptor(TitleFormatBundle.messagePointer("colors.page.titleformat.attribute.parentheses"), TitleFormatSyntaxHighlighter.PARENTHESES),
            AttributesDescriptor(TitleFormatBundle.messagePointer("colors.page.titleformat.attribute.comma"), TitleFormatSyntaxHighlighter.COMMA),
            AttributesDescriptor(TitleFormatBundle.messagePointer("colors.page.titleformat.attribute.field"), TitleFormatSyntaxHighlighter.FIELD),
            AttributesDescriptor(TitleFormatBundle.messagePointer("colors.page.titleformat.attribute.function.call"), TitleFormatSyntaxHighlighter.FUNCTION_CALL),
            AttributesDescriptor(TitleFormatBundle.messagePointer("colors.page.titleformat.attribute.string.quoted"), TitleFormatSyntaxHighlighter.QUOTED_STRING),
            AttributesDescriptor(TitleFormatBundle.messagePointer("colors.page.titleformat.attribute.string.verbatim"), TitleFormatSyntaxHighlighter.VERBATIM_TEXT),
            AttributesDescriptor(TitleFormatBundle.messagePointer("colors.page.titleformat.attribute.string.special"), TitleFormatSyntaxHighlighter.SPECIAL_CHAR),
        )
    }

    override fun getDisplayName(): String {
        return TitleFormatBundle.message("colors.page.titleformat.display.name")
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