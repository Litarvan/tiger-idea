package com.litarvan.tigeridea.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import com.litarvan.tigeridea.TigerLanguage;

public class TigerTokenType extends IElementType
{
    public TigerTokenType(@NonNls @NotNull String debugName)
    {
        super(debugName, TigerLanguage.INSTANCE);
    }

    @Override
    public String toString()
    {
        return "TigerTokenType." + super.toString();
    }
}
