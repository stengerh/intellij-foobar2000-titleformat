// This is a generated file. Not intended for manual editing.
package com.github.stengerh.intellij.foobar2000.titleformat.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TitleFormatSequenceExpression extends PsiElement {

  @NotNull
  List<TitleFormatCharLiteral> getCharLiteralList();

  @NotNull
  List<TitleFormatFieldExpression> getFieldExpressionList();

  @NotNull
  List<TitleFormatFunctionCallExpression> getFunctionCallExpressionList();

  @NotNull
  List<TitleFormatOptionalExpression> getOptionalExpressionList();

  @NotNull
  List<TitleFormatQuotedStringLiteral> getQuotedStringLiteralList();

  @NotNull
  List<TitleFormatVerbatimStringLiteral> getVerbatimStringLiteralList();

}
