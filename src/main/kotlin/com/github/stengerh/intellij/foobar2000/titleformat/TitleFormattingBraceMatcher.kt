package com.github.stengerh.intellij.foobar2000.titleformat

import com.github.stengerh.intellij.foobar2000.titleformat.psi.TitleFormatTypes
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType

class TitleFormattingBraceMatcher : PairedBraceMatcher {
    companion object {
        val PAIRS: Array<BracePair> = arrayOf(
            BracePair(TitleFormatTypes.LEFT_BRACKET, TitleFormatTypes.RIGHT_BRACKET, true),
            BracePair(TitleFormatTypes.LEFT_PAREN, TitleFormatTypes.RIGHT_PAREN, true),
        )
    }

    override fun getPairs(): Array<BracePair> {
        return PAIRS
    }

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, contextType: IElementType?): Boolean {
        return true
    }

    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int {
        return openingBraceOffset
    }
}