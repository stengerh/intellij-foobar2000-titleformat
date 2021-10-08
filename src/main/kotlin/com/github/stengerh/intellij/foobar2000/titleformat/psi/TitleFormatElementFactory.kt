package com.github.stengerh.intellij.foobar2000.titleformat.psi

import com.github.stengerh.intellij.foobar2000.titleformat.TitleFormatFileType
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory

object TitleFormatElementFactory {
    fun createFile(project: Project, text: String): TitleFormatFile {
        val name: String = "dummy.ftf"
        return PsiFileFactory.getInstance(project)
            .createFileFromText(name, TitleFormatFileType, text) as TitleFormatFile
    }

    fun createFieldExpression(project: Project, name: String): TitleFormatFieldExpression {
        val text = "%${name}%"
        val file: TitleFormatFile = createFile(project, text)
        val sequenceExpression = file.firstChild as TitleFormatSequenceExpression
        return sequenceExpression.firstChild as TitleFormatFieldExpression
    }
}