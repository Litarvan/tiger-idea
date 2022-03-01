package com.litarvan.tigeridea.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

import com.litarvan.tigeridea.TigFileType;
import com.litarvan.tigeridea.TigerLanguage;

public class TigerFile extends PsiFileBase
{
    public TigerFile(@NotNull FileViewProvider viewProvider)
    {
        super(viewProvider, TigerLanguage.INSTANCE);
    }

    @Override
    public @NotNull FileType getFileType()
    {
        return TigFileType.INSTANCE;
    }

    @Override
    public String toString()
    {
        return "Tiger File";
    }
}
