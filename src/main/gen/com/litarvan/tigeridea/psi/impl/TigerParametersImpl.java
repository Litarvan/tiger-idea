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

public class TigerParametersImpl extends ASTWrapperPsiElement implements TigerParameters {

  public TigerParametersImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TigerVisitor visitor) {
    visitor.visitParameters(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TigerVisitor) accept((TigerVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<TigerTypeId> getTypeIdList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TigerTypeId.class);
  }

}
