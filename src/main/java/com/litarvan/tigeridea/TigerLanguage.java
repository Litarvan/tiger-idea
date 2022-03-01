package com.litarvan.tigeridea;

import com.intellij.lang.Language;

public class TigerLanguage extends Language
{
    public static final TigerLanguage INSTANCE = new TigerLanguage();

    private TigerLanguage()
    {
        super("Tiger");
    }
}
