package com.litarvan.tigeridea;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.NlsContexts.Label;
import com.intellij.openapi.util.NlsSafe;
import javax.swing.Icon;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TigFileType extends LanguageFileType
{
    public static final TigFileType INSTANCE = new TigFileType();

    private TigFileType()
    {
        super(TigerLanguage.INSTANCE);
    }

    @Override
    public @NonNls @NotNull String getName()
    {
        return "Tiger File";
    }

    @Override
    public @Nls @NotNull String getDisplayName()
    {
        return this.getName();
    }

    @Override
    public @Label @NotNull String getDescription()
    {
        return "Tiger language regular file";
    }

    @Override
    public @NlsSafe @NotNull String getDefaultExtension()
    {
        return "tig";
    }

    @Override
    public @Nullable Icon getIcon()
    {
        return TigerIcons.TIG_FILE;
    }
}
