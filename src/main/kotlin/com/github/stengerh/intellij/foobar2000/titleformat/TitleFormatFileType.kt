package com.github.stengerh.intellij.foobar2000.titleformat

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object TitleFormatFileType : LanguageFileType(TitleFormatLanguage) {
    override fun getName(): String = "TitleFormat File"

    override fun getDescription(): String = TitleFormatBundle.message("file.type.titleformat.description")

    override fun getDefaultExtension(): String = "ftf"

    override fun getIcon(): Icon = TitleFormatIcons.FILE
}