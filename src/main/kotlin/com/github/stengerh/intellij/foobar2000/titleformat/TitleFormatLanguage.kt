package com.github.stengerh.intellij.foobar2000.titleformat

import com.intellij.lang.Language

object TitleFormatLanguage : Language("TitleFormat") {
    override fun getDisplayName(): String = TitleFormatBundle.message("file.type.titleformat.description")
    override fun isCaseSensitive(): Boolean = true
}