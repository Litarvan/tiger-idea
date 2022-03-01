// This is a generated file. Not intended for manual editing.
package com.litarvan.tigeridea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TigerExpressionPart extends PsiElement {

  @Nullable
  TigerChunks getChunks();

  @NotNull
  List<TigerExpression> getExpressionList();

  @Nullable
  TigerExpressions getExpressions();

  @Nullable
  TigerLvalue getLvalue();

  @Nullable
  TigerTypeId getTypeId();

}
