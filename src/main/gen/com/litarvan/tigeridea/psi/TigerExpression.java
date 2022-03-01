// This is a generated file. Not intended for manual editing.
package com.litarvan.tigeridea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TigerExpression extends PsiElement {

  @Nullable
  TigerExpression getExpression();

  @NotNull
  TigerExpressionPart getExpressionPart();

  @Nullable
  TigerOperator getOperator();

}
