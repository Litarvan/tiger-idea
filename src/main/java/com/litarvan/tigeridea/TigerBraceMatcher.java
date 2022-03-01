package com.litarvan.tigeridea;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.litarvan.tigeridea.psi.TigerTypes;

public class TigerBraceMatcher implements PairedBraceMatcher
{
    private static final BracePair[] PAIRS = {
        new BracePair(TigerTypes.LEFT_BRACE, TigerTypes.RIGHT_BRACE, true),
        new BracePair(TigerTypes.LEFT_BRACKET, TigerTypes.RIGHT_BRACKET, false),
        new BracePair(TigerTypes.LEFT_PARENTHESIS, TigerTypes.RIGHT_PARENTHESIS, false)
    };

    @Override
    public BracePair @NotNull [] getPairs()
    {
        return PAIRS;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType)
    {
        return true;
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset)
    {
        return openingBraceOffset;
    }
}
