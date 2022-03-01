package com.litarvan.tigeridea;

import com.intellij.formatting.*;
import com.intellij.formatting.Indent.Type;
import org.jetbrains.annotations.NotNull;

import com.litarvan.tigeridea.psi.TigerTypes;

public class TigerFormattingModelBuilder implements FormattingModelBuilder
{
    @Override
    public @NotNull FormattingModel createModel(@NotNull FormattingContext formattingContext)
    {
        // TODO: Allow customization
        // TODO: Add ".none()"
        var spacingBuilder = new SpacingBuilder(formattingContext.getCodeStyleSettings(), TigerLanguage.INSTANCE)
            .after(TigerTypes.COMMA).spaces(1)
            .after(TigerTypes.COLON).spaces(1)
            .withinPair(TigerTypes.LEFT_BRACE, TigerTypes.RIGHT_BRACE).spaces(1)
            .around(TigerTypes.PLUS).spaces(1)
            .around(TigerTypes.MINUS).spaces(1)
            .around(TigerTypes.DIVIDES).spaces(1)
            .around(TigerTypes.MULTIPLIES).spaces(1)
            .around(TigerTypes.ASSIGN).spaces(1)
            .around(TigerTypes.EQUALS).spaces(1)
            .around(TigerTypes.NOT_EQUALS).spaces(1)
            .around(TigerTypes.GREATER).spaces(1)
            .around(TigerTypes.LOWER).spaces(1)
            .around(TigerTypes.GREATER_EQUAL).spaces(1)
            .around(TigerTypes.LOWER_EQUAL).spaces(1);

        return FormattingModelProvider
            .createFormattingModelForPsiFile(formattingContext.getContainingFile(),
                                             new TigerBlock(formattingContext.getNode(),
                                                            Wrap.createWrap(WrapType.NONE, false),
                                                            Alignment.createAlignment(),
                                                            Indent.getNoneIndent(),
                                                            spacingBuilder
                                             ), formattingContext.getCodeStyleSettings());
    }
}
