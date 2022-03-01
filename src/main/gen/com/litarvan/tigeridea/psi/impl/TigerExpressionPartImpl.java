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

public class TigerExpressionPartImpl extends ASTWrapperPsiElement implements TigerExpressionPart {

  public TigerExpressionPartImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TigerVisitor visitor) {
    visitor.visitExpressionPart(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TigerVisitor) accept((TigerVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public TigerChunks getChunks() {
    return findChildByClass(TigerChunks.class);
  }

  @Override
  @NotNull
  public List<TigerExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TigerExpression.class);
  }

  @Override
  @Nullable
  public TigerExpressions getExpressions() {
    return findChildByClass(TigerExpressions.class);
  }

  @Override
  @Nullable
  public TigerLvalue getLvalue() {
    return findChildByClass(TigerLvalue.class);
  }

  @Override
  @Nullable
  public TigerTypeId getTypeId() {
    return findChildByClass(TigerTypeId.class);
  }

}
