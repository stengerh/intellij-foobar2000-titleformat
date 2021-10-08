package com.github.stengerh.intellij.foobar2000.titleformat.psi.impl

import com.github.stengerh.intellij.foobar2000.titleformat.psi.TitleFormatElementFactory
import com.github.stengerh.intellij.foobar2000.titleformat.psi.TitleFormatFieldExpression
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import org.jetbrains.annotations.NonNls

abstract class TitleFormatFieldExpressionMixin(node: ASTNode) :
    ASTWrapperPsiElement(node),
    TitleFormatFieldExpression,
    PsiNameIdentifierOwner {

    @NonNls
    override fun getName(): String? {
        val nameNode: ASTNode = fieldName.node
        val text = nameNode.text
        return if (text.length > 2) {
            text.substring(1, text.length - 1)
        } else {
            null
        }
    }

    override fun setName(@NonNls name: String): PsiElement {
        val nameNode: ASTNode = fieldName.node
        val fieldExpression = TitleFormatElementFactory.createFieldExpression(this.project, name)
        val newNameNode = fieldExpression.firstChild.node
        this.node.replaceChild(nameNode, newNameNode)
        return this
    }

    override fun getNameIdentifier(): PsiElement? {
        return fieldName.node.psi
    }
}
