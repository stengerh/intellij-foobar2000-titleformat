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

public class TitleFormatExpressionImpl extends ASTWrapperPsiElement implements TitleFormatExpression {

  public TitleFormatExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TitleFormatVisitor visitor) {
    visitor.visitExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TitleFormatVisitor) accept((TitleFormatVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public TitleFormatComment getComment() {
    return findChildByClass(TitleFormatComment.class);
  }

  @Override
  @Nullable
  public TitleFormatFieldExpression getFieldExpression() {
    return findChildByClass(TitleFormatFieldExpression.class);
  }

  @Override
  @Nullable
  public TitleFormatFunctionCallExpression getFunctionCallExpression() {
    return findChildByClass(TitleFormatFunctionCallExpression.class);
  }

  @Override
  @Nullable
  public TitleFormatLiteral getLiteral() {
    return findChildByClass(TitleFormatLiteral.class);
  }

  @Override
  @Nullable
  public TitleFormatOptionalExpression getOptionalExpression() {
    return findChildByClass(TitleFormatOptionalExpression.class);
  }

}
