package com.github.stengerh.intellij.foobar2000.titleformat.psi

import com.github.stengerh.intellij.foobar2000.titleformat.TitleFormatLanguage
import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NonNls

class TitleFormatElementType(@NonNls debugName: String) :
    IElementType(debugName, TitleFormatLanguage)
