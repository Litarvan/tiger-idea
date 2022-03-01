package com.litarvan.tigeridea;

import com.intellij.lexer.FlexAdapter;

public class TigerLexerAdapter extends FlexAdapter
{
    public TigerLexerAdapter()
    {
        super(new TigerLexer(null));
    }
}
