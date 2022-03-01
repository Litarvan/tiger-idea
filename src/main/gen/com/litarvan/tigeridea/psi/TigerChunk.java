// This is a generated file. Not intended for manual editing.
package com.litarvan.tigeridea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TigerChunk extends PsiElement {

  @NotNull
  List<TigerFunctionDeclaration> getFunctionDeclarationList();

  @NotNull
  List<TigerTypeDeclaration> getTypeDeclarationList();

  @Nullable
  TigerVariableDeclaration getVariableDeclaration();

}
