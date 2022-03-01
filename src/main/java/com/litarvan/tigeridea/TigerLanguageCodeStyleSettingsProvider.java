package com.litarvan.tigeridea;

import com.intellij.application.options.IndentOptionsEditor;
import com.intellij.application.options.SmartIndentOptionsEditor;
import com.intellij.lang.Language;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TigerLanguageCodeStyleSettingsProvider extends LanguageCodeStyleSettingsProvider
{
    @Override
    public @Nullable String getCodeSample(@NotNull SettingsType settingsType)
    {
        return "let\n" + "  import \"my_file.tih\"\n" + "  var hello := \"world\"\n" + "in\n" + "  print(hello);\n" +
               "\n" + "  if true then\n" + "    \"Bonjour, je m'appelle Simon et je suis au LRDE\"\n" + "  else\n" +
               "    \"Chef ???\"\n" + "end";
    }

    @Nullable
    @Override
    public IndentOptionsEditor getIndentOptionsEditor()
    {
        return new SmartIndentOptionsEditor();
    }

    @Override
    protected void customizeDefaults(@NotNull CommonCodeStyleSettings commonSettings,
                                     @NotNull CommonCodeStyleSettings.IndentOptions indentOptions)
    {
        indentOptions.INDENT_SIZE = 2;
    }

    @Override
    public @NotNull Language getLanguage()
    {
        return TigerLanguage.INSTANCE;
    }
}
