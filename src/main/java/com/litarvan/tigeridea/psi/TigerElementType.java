package com.litarvan.tigeridea.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import com.litarvan.tigeridea.TigerLanguage;

public class TigerElementType extends IElementType
{
    public TigerElementType(@NonNls @NotNull String debugName)
    {
        super(debugName, TigerLanguage.INSTANCE);
    }
}
