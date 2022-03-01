package com.litarvan.tigeridea;

import java.util.Map;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.openapi.util.NlsContexts.ConfigurableName;
import javax.swing.Icon;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TigerColorSettingsPage implements ColorSettingsPage
{
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[] {
        new AttributesDescriptor("Line comment", TigerSyntaxHighlighter.LINE_COMMENT),
        new AttributesDescriptor("Block comment", TigerSyntaxHighlighter.BLOCK_COMMENT),
        new AttributesDescriptor("Keyword", TigerSyntaxHighlighter.KEYWORD),
        new AttributesDescriptor("Identifier", TigerSyntaxHighlighter.IDENTIFIER),
        new AttributesDescriptor("Number", TigerSyntaxHighlighter.NUMBER),
        new AttributesDescriptor("String", TigerSyntaxHighlighter.STRING),
        new AttributesDescriptor("Braces", TigerSyntaxHighlighter.BRACES),
        new AttributesDescriptor("Dot", TigerSyntaxHighlighter.DOT),
        new AttributesDescriptor("Semicolon", TigerSyntaxHighlighter.SEMICOLON),
        new AttributesDescriptor("Comma", TigerSyntaxHighlighter.COMMA),
        new AttributesDescriptor("Parenthesis", TigerSyntaxHighlighter.PARENTHESES),
        new AttributesDescriptor("Brackets", TigerSyntaxHighlighter.BRACKETS)
    };

    @Override
    public @Nullable Icon getIcon()
    {
        return TigerIcons.TIG_FILE;
    }

    @Override
    public @NotNull SyntaxHighlighter getHighlighter()
    {
        return new TigerSyntaxHighlighter();
    }

    @Override
    public @NonNls @NotNull String getDemoText()
    {
        return "let\n" + "  import \"my_file.tih\"\n" + "  var hello := \"world\"\n" + "in\n" + "  print(hello);\n" +
               "\n" + "  if true then\n" + "    \"Bonjour, je m'appelle Simon et je suis au LRDE\"\n" + "  else\n" +
               "    \"Chef ???\"\n" + "end";
    }

    @Override
    public @Nullable Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap()
    {
        return null;
    }

    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors()
    {
        return DESCRIPTORS;
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors()
    {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @Override
    public @NotNull @ConfigurableName String getDisplayName()
    {
        return "Tiger";
    }
}
