package com.github.stengerh.intellij.foobar2000.titleformat.psi

import com.github.stengerh.intellij.foobar2000.titleformat.TitleFormatFileType
import com.github.stengerh.intellij.foobar2000.titleformat.TitleFormatLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class TitleFormatFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, TitleFormatLanguage) {
    override fun getFileType(): FileType = TitleFormatFileType

    override fun toString(): String = "TitleFormat File"
}