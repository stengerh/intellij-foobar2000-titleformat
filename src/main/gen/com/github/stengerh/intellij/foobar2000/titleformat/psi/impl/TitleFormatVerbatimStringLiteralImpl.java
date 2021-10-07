// This is a generated file. Not intended for manual editing.
package com.github.stengerh.intellij.foobar2000.titleformat.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.stengerh.intellij.foobar2000.titleformat.psi.TitleFormatTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.stengerh.intellij.foobar2000.titleformat.psi.*;

public class TitleFormatVerbatimStringLiteralImpl extends ASTWrapperPsiElement implements TitleFormatVerbatimStringLiteral {

  public TitleFormatVerbatimStringLiteralImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TitleFormatVisitor visitor) {
    visitor.visitVerbatimStringLiteral(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TitleFormatVisitor) accept((TitleFormatVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getVerbatimText() {
    return findNotNullChildByType(VERBATIM_TEXT);
  }

}