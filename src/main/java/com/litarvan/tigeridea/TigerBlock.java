package com.litarvan.tigeridea;

import java.util.ArrayList;
import java.util.List;

import com.intellij.formatting.*;
import com.intellij.formatting.Indent.Type;
import com.intellij.lang.ASTNode;
import com.intellij.psi.TokenType;
import com.intellij.psi.formatter.common.AbstractBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.litarvan.tigeridea.psi.TigerTypes;

public class TigerBlock extends AbstractBlock
{
    private final Indent indent;
    private final SpacingBuilder spacingBuilder;

    public TigerBlock(@NotNull ASTNode node, @Nullable Wrap wrap, @Nullable Alignment alignment, Indent indent, SpacingBuilder spacingBuilder)
    {
        super(node, wrap, alignment);

        this.indent = indent;
        this.spacingBuilder = spacingBuilder;
    }

    @Override
    protected List<Block> buildChildren()
    {
        var blocks = new ArrayList<Block>();
        var child = myNode.getFirstChildNode();

        var nextIndent = Indent.getNoneIndent();
        while (child != null)
        {
            if (child.getElementType() != TokenType.WHITE_SPACE)
            {
                // Doesn't work since it's the expression_part between them that is getting indented
                /* if (child.getElementType() == TigerTypes.RIGHT_PARENTHESIS ||
                    child.getElementType() == TigerTypes.RIGHT_BRACE)
                {
                    nextIndent = Indent.getNoneIndent();
                }*/

                blocks.add(new TigerBlock(child, Wrap.createWrap(WrapType.NONE, false), Alignment.createAlignment(), nextIndent, this.spacingBuilder));
                nextIndent = Indent.getNoneIndent();

                var type = child.getElementType();
                if (type == TigerTypes.THEN || type == TigerTypes.ASSIGN || type == TigerTypes.LEFT_PARENTHESIS ||
                    type == TigerTypes.LEFT_BRACE || type == TigerTypes.IN || type == TigerTypes.DO ||
                    type == TigerTypes.LET || type == TigerTypes.EQUALS)
                {
                    nextIndent = Indent.getNormalIndent();
                }
            }

            child = child.getTreeNext();
        }

        return blocks;
    }

    @Override
    public Indent getIndent()
    {
        return this.indent;
    }

    @Override
    public @Nullable Spacing getSpacing(@Nullable Block child1, @NotNull Block child2)
    {
        return this.spacingBuilder.getSpacing(this, child1, child2);
    }

    @Override
    public @NotNull ChildAttributes getChildAttributes(int newChildIndex)
    {
        var blocks = getSubBlocks();
        if (blocks.size() == 0)
        {
            return super.getChildAttributes(newChildIndex);
        }

        var block = blocks.get(blocks.size() - 1);
        if (newChildIndex > 0 && newChildIndex <= blocks.size())
        {
            block = blocks.get(newChildIndex - 1);
        }

        var indent = block.getIndent();
        if (indent == null || indent.getType() == Type.NONE)
        {
            var type = ((TigerBlock) block).getNode().getElementType();
            if (type == TigerTypes.LEFT_PARENTHESIS || type == TigerTypes.LEFT_BRACE)
            {
                indent = Indent.getNormalIndent();
            }
        }

        // When 'let' blocks aren't closed by 'in' and 'end', their content isn't parsed as a single chunk
        // so the indentation only applies to the value right after 'let'/'in'. When detecting an unfinished let
        // block for example (i.e. one not followed by chunks), we are setting the indentation as the one of the block
        // right after the 'let'
        for (int i = 0; i < newChildIndex - 1 && i < blocks.size() - 1; i++)
        {
            var type = ((TigerBlock) blocks.get(i)).getNode().getElementType();
            var next = blocks.get(i + 1);
            var nextType = ((TigerBlock) next).getNode().getElementType();

            if (type == TigerTypes.LET && nextType != TigerTypes.CHUNKS)
            {
                // if (indent != null && indent.getType() == Type.NORMAL && next.getIndent() != null)
                // {
                    // If we were already going to indent the block, this mean we must indent it twice
                    // Using .getSpaces() returned always 0, so i had to hardcode it
                    // TODO: Edit parser to allow unfinished let/in etc. blocks, but add a manual error if this happens
                    // indent = Indent.getSpaceIndent(4);
                    // Removed since it was overwritten by the true formatting from buildChildren, it's getting too
                    // complicated anyway for a workaround
                // }
                // else
                // {
                    indent = next.getIndent();
                // }
            }
        }
        return new ChildAttributes(indent, null);
    }

    @Override
    public boolean isLeaf()
    {
        return false;
    }

    @Override
    public @NotNull ASTNode getNode()
    {
        return super.getNode();
    }
}
