package com.litarvan.tigeridea;

import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.highlighter.HighlighterIterator;

import com.litarvan.tigeridea.psi.TigerTypes;

public class TigerQuoteHandler extends SimpleTokenSetQuoteHandler
{
    public TigerQuoteHandler()
    {
        super(TigerTypes.STRING);
    }

    @Override
    public boolean hasNonClosedLiteral(Editor editor, HighlighterIterator iterator, int offset)
    {
        return true;
    }
}
