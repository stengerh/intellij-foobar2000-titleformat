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

public class TitleFormatSequenceExpressionImpl extends ASTWrapperPsiElement implements TitleFormatSequenceExpression {

  public TitleFormatSequenceExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TitleFormatVisitor visitor) {
    visitor.visitSequenceExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TitleFormatVisitor) accept((TitleFormatVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<TitleFormatCharLiteral> getCharLiteralList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TitleFormatCharLiteral.class);
  }

  @Override
  @NotNull
  public List<TitleFormatFieldExpression> getFieldExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TitleFormatFieldExpression.class);
  }

  @Override
  @NotNull
  public List<TitleFormatFunctionCallExpression> getFunctionCallExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TitleFormatFunctionCallExpression.class);
  }

  @Override
  @NotNull
  public List<TitleFormatOptionalExpression> getOptionalExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TitleFormatOptionalExpression.class);
  }

  @Override
  @NotNull
  public List<TitleFormatQuotedStringLiteral> getQuotedStringLiteralList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TitleFormatQuotedStringLiteral.class);
  }

  @Override
  @NotNull
  public List<TitleFormatVerbatimStringLiteral> getVerbatimStringLiteralList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TitleFormatVerbatimStringLiteral.class);
  }

}
