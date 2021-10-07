package com.github.stengerh.intellij.foobar2000.titleformat

import com.github.stengerh.intellij.foobar2000.titleformat.psi.TitleFormatFile
import com.github.stengerh.intellij.foobar2000.titleformat.psi.TitleFormatTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class TitleFormatParserDefinition : ParserDefinition {
    companion object {
        val FILE: IFileElementType = IFileElementType(TitleFormatLanguage)

        val COMMENTS: TokenSet = TokenSet.create(TitleFormatTypes.LINE_COMMENT)
    }

    override fun createLexer(project: Project?): Lexer = TitleFormatLexerAdapter()

    override fun createParser(project: Project?): PsiParser = TitleFormatParser()

    override fun getFileNodeType(): IFileElementType = FILE

    override fun getCommentTokens(): TokenSet = COMMENTS

    override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY

    override fun createElement(node: ASTNode?): PsiElement = TitleFormatTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider?): PsiFile = TitleFormatFile(viewProvider!!)
}
