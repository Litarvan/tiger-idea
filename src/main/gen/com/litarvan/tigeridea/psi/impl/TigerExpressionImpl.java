// This is a generated file. Not intended for manual editing.
package com.litarvan.tigeridea.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.litarvan.tigeridea.psi.TigerTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.litarvan.tigeridea.psi.*;

public class TigerExpressionImpl extends ASTWrapperPsiElement implements TigerExpression {

  public TigerExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TigerVisitor visitor) {
    visitor.visitExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TigerVisitor) accept((TigerVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public TigerExpression getExpression() {
    return findChildByClass(TigerExpression.class);
  }

  @Override
  @NotNull
  public TigerExpressionPart getExpressionPart() {
    return findNotNullChildByClass(TigerExpressionPart.class);
  }

  @Override
  @Nullable
  public TigerOperator getOperator() {
    return findChildByClass(TigerOperator.class);
  }

}
