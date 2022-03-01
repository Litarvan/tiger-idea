package com.litarvan.tigeridea;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

import com.litarvan.tigeridea.parser.TigerParser;
import com.litarvan.tigeridea.psi.TigerFile;
import com.litarvan.tigeridea.psi.TigerTokenType;
import com.litarvan.tigeridea.psi.TigerTypes;

public class TigerParserDefinition implements ParserDefinition
{
    public static final IElementType LINE_COMMENT = new TigerTokenType("LINE_COMMENT");
    public static final IElementType BLOCK_COMMENT_START = new TigerTokenType("BLOCK_COMMENT_START");
    public static final IElementType BLOCK_COMMENT_BODY = new TigerTokenType("BLOCK_COMMENT_BODY");
    public static final IElementType BLOCK_COMMENT_END = new TigerTokenType("BLOCK_COMMENT_END");

    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENTS = TokenSet.create(LINE_COMMENT, BLOCK_COMMENT_START, BLOCK_COMMENT_BODY, BLOCK_COMMENT_END);
    public static final TokenSet STRINGS = TokenSet.create(TigerTypes.STRING);

    public static final IFileElementType FILE = new IFileElementType(TigerLanguage.INSTANCE);

    @Override
    public @NotNull Lexer createLexer(Project project)
    {
        return new TigerLexerAdapter();
    }

    @Override
    public @NotNull TokenSet getWhitespaceTokens()
    {
        return WHITE_SPACES;
    }

    @Override
    public @NotNull TokenSet getCommentTokens()
    {
        return COMMENTS;
    }

    @Override
    public @NotNull TokenSet getStringLiteralElements()
    {
        return STRINGS;
    }

    @Override
    public @NotNull PsiParser createParser(Project project)
    {
        return new TigerParser();
    }

    @Override
    public @NotNull IFileElementType getFileNodeType()
    {
        return FILE;
    }

    @Override
    public @NotNull PsiFile createFile(@NotNull FileViewProvider viewProvider)
    {
        return new TigerFile(viewProvider);
    }

    @Override
    public @NotNull SpaceRequirements spaceExistenceTypeBetweenTokens(ASTNode left, ASTNode right)
    {
        return SpaceRequirements.MAY;
    }

    @Override
    public @NotNull PsiElement createElement(ASTNode node)
    {
        return TigerTypes.Factory.createElement(node);
    }
}
