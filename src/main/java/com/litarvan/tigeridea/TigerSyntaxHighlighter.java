package com.litarvan.tigeridea;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import com.litarvan.tigeridea.psi.TigerTypes;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class TigerSyntaxHighlighter extends SyntaxHighlighterBase
{
    public static final TextAttributesKey LINE_COMMENT =
        createTextAttributesKey("TIGER_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BLOCK_COMMENT =
        createTextAttributesKey("TIGER_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
    public static final TextAttributesKey OPERATOR =
        createTextAttributesKey("TIGER_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey KEYWORD =
        createTextAttributesKey("TIGER_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey IDENTIFIER =
        createTextAttributesKey("TIGER_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey NUMBER =
        createTextAttributesKey("TIGER_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey STRING =
        createTextAttributesKey("TIGER_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey BRACES =
        createTextAttributesKey("TIGER_BRACES", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey DOT =
        createTextAttributesKey("TIGER_DOT", DefaultLanguageHighlighterColors.DOT);
    public static final TextAttributesKey SEMICOLON =
        createTextAttributesKey("TIGER_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON);
    public static final TextAttributesKey COMMA =
        createTextAttributesKey("TIGER_COMMA", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey PARENTHESES =
        createTextAttributesKey("TIGER_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES);
    public static final TextAttributesKey BRACKETS =
        createTextAttributesKey("TIGER_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);


    private static final TextAttributesKey[] LINE_COMMENT_KEYS = new TextAttributesKey[] { LINE_COMMENT };
    private static final TextAttributesKey[] BLOCK_COMMENT_KEYS = new TextAttributesKey[] { BLOCK_COMMENT };
    private static final TextAttributesKey[] OPERATOR_KEYS = new TextAttributesKey[] { OPERATOR };
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[] { KEYWORD };
    private static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[] { IDENTIFIER };
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[] { NUMBER };
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[] { STRING };
    private static final TextAttributesKey[] BRACES_KEYS = new TextAttributesKey[] { BRACES };
    private static final TextAttributesKey[] DOT_KEYS = new TextAttributesKey[] { DOT };
    private static final TextAttributesKey[] SEMICOLON_KEYS = new TextAttributesKey[] { SEMICOLON };
    private static final TextAttributesKey[] COMMA_KEYS = new TextAttributesKey[] { COMMA };
    private static final TextAttributesKey[] PARENTHESES_KEYS = new TextAttributesKey[] { PARENTHESES };
    private static final TextAttributesKey[] BRACKETS_KEYS = new TextAttributesKey[] { BRACKETS };
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @Override
    public @NotNull Lexer getHighlightingLexer()
    {
        return new TigerLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType)
    {
        if (tokenType == TigerParserDefinition.LINE_COMMENT) {
            return LINE_COMMENT_KEYS;
        }
        if (tokenType == TigerParserDefinition.BLOCK_COMMENT_START ||
            tokenType == TigerParserDefinition.BLOCK_COMMENT_BODY ||
            tokenType == TigerParserDefinition.BLOCK_COMMENT_END) {
            return BLOCK_COMMENT_KEYS;
        }
        if (tokenType == TigerTypes.OR || tokenType == TigerTypes.AND || tokenType == TigerTypes.EQUALS ||
            tokenType == TigerTypes.NOT_EQUALS || tokenType == TigerTypes.GREATER || tokenType == TigerTypes.LOWER ||
            tokenType == TigerTypes.GREATER_EQUAL || tokenType == TigerTypes.LOWER_EQUAL ||
            tokenType == TigerTypes.PLUS || tokenType == TigerTypes.MINUS || tokenType == TigerTypes.MULTIPLIES ||
            tokenType == TigerTypes.DIVIDES || tokenType == TigerTypes.ASSIGN || tokenType == TigerTypes.COLON) {
            return OPERATOR_KEYS;
        }
        if (tokenType == TigerTypes.ARRAY || tokenType == TigerTypes.BREAK || tokenType == TigerTypes.DO ||
            tokenType == TigerTypes.ELSE || tokenType == TigerTypes.END || tokenType == TigerTypes.FOR ||
            tokenType == TigerTypes.FUNCTION || tokenType == TigerTypes.IF || tokenType == TigerTypes.IMPORT ||
            tokenType == TigerTypes.IN || tokenType == TigerTypes.LET || tokenType == TigerTypes.NIL ||
            tokenType == TigerTypes.OF || tokenType == TigerTypes.PRIMITIVE ||  tokenType == TigerTypes.THEN ||
            tokenType == TigerTypes.TO || tokenType == TigerTypes.TYPE || tokenType == TigerTypes.VAR ||
            tokenType == TigerTypes.WHILE) {
            return KEYWORD_KEYS;
        }
        if (tokenType == TigerTypes.IDENTIFIER) {
            return IDENTIFIER_KEYS;
        }
        if (tokenType == TigerTypes.INTEGER) {
            return NUMBER_KEYS;
        }
        if (tokenType == TigerTypes.STRING) {
            return STRING_KEYS;
        }
        if (tokenType == TigerTypes.LEFT_BRACE || tokenType == TigerTypes.RIGHT_BRACE) {
            return BRACES_KEYS;
        }
        if (tokenType == TigerTypes.DOT) {
            return DOT_KEYS;
        }
        if (tokenType == TigerTypes.SEMI_COLON) {
            return SEMICOLON_KEYS;
        }
        if (tokenType == TigerTypes.COMMA) {
            return COMMA_KEYS;
        }
        if (tokenType == TigerTypes.LEFT_PARENTHESIS || tokenType == TigerTypes.RIGHT_PARENTHESIS) {
            return PARENTHESES_KEYS;
        }
        if (tokenType == TigerTypes.LEFT_BRACKET || tokenType == TigerTypes.RIGHT_BRACKET) {
            return BRACKETS_KEYS;
        }

        return EMPTY_KEYS;
    }
}
