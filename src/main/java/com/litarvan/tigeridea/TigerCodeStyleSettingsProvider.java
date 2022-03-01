package com.litarvan.tigeridea;

import com.intellij.application.options.CodeStyleAbstractConfigurable;
import com.intellij.application.options.CodeStyleAbstractPanel;
import com.intellij.application.options.TabbedLanguageCodeStylePanel;
import com.intellij.psi.codeStyle.CodeStyleConfigurable;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CodeStyleSettingsProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TigerCodeStyleSettingsProvider extends CodeStyleSettingsProvider
{
    @Override
    public @NotNull CodeStyleConfigurable createConfigurable(@NotNull CodeStyleSettings settings, @NotNull CodeStyleSettings originalSettings)
    {
        return new CodeStyleAbstractConfigurable(settings, originalSettings, this.getConfigurableDisplayName())
        {
            @Override
            protected CodeStyleAbstractPanel createPanel(CodeStyleSettings settings)
            {
                return new TabbedLanguageCodeStylePanel(TigerLanguage.INSTANCE, getCurrentSettings(), settings)
                {
                    @Override
                    protected void initTabs(CodeStyleSettings settings)
                    {
                        addIndentOptionsTab(settings);
                        addWrappingAndBracesTab(settings);
                    }
                };
            }
        };
    }

    @Nullable
    @Override
    public String getConfigurableDisplayName()
    {
        return TigerLanguage.INSTANCE.getDisplayName();
    }
}
