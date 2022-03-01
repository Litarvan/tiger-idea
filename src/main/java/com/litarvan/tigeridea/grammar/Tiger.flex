package com.litarvan.tigeridea;

import com.intellij.util.containers.IntStack;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;

import com.litarvan.tigeridea.psi.TigerTypes;

%%

%{
  private static final IntStack stack = new IntStack();

  private void push(int state)
  {
      stack.push(yystate());
      yybegin(state);
  }

  private void pop()
  {
      yybegin(stack.pop());
  }

  private void reset()
  {
      stack.clear();
  }
%}

%class TigerLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{
  reset();
%eof}

%x COMMENT

%%

<YYINITIAL> \/\/(\n|[^\n=][^\n]*) { return TigerParserDefinition.LINE_COMMENT; }

<YYINITIAL, COMMENT> "/*" { push(COMMENT); return TigerParserDefinition.BLOCK_COMMENT_START; }
<COMMENT> ([^/*]|(\*[^/])|(\/[^*]))+ { return TigerParserDefinition.BLOCK_COMMENT_BODY; }
<COMMENT> "*/" { pop(); return TigerParserDefinition.BLOCK_COMMENT_END; }

<YYINITIAL> "&" { return TigerTypes.AND; }
<YYINITIAL> "array" { return TigerTypes.ARRAY; }
<YYINITIAL> ":=" { return TigerTypes.ASSIGN; }
<YYINITIAL> "break" { return TigerTypes.BREAK; }
<YYINITIAL> ":" { return TigerTypes.COLON; }
<YYINITIAL> "," { return TigerTypes.COMMA; }
<YYINITIAL> "/" { return TigerTypes.DIVIDES; }
<YYINITIAL> "do" { return TigerTypes.DO; }
<YYINITIAL> "." { return TigerTypes.DOT; }
<YYINITIAL> "else" { return TigerTypes.ELSE; }
<YYINITIAL> "end" { return TigerTypes.END; }
<YYINITIAL> "=" { return TigerTypes.EQUALS; }
<YYINITIAL> "for" { return TigerTypes.FOR; }
<YYINITIAL> "function" { return TigerTypes.FUNCTION; }
<YYINITIAL> ">" { return TigerTypes.GREATER; }
<YYINITIAL> ">=" { return TigerTypes.GREATER_EQUAL; }
<YYINITIAL> "if" { return TigerTypes.IF; }
<YYINITIAL> "import" { return TigerTypes.IMPORT; }
<YYINITIAL> "in" { return TigerTypes.IN; }
<YYINITIAL> "{" { return TigerTypes.LEFT_BRACE; }
<YYINITIAL> "[" { return TigerTypes.LEFT_BRACKET; }
<YYINITIAL> "(" { return TigerTypes.LEFT_PARENTHESIS; }
<YYINITIAL> "let" { return TigerTypes.LET; }
<YYINITIAL> "<" { return TigerTypes.LOWER; }
<YYINITIAL> "<=" { return TigerTypes.LOWER_EQUAL; }
<YYINITIAL> "-" { return TigerTypes.MINUS; }
<YYINITIAL> "*" { return TigerTypes.MULTIPLIES; }
<YYINITIAL> "nil" { return TigerTypes.NIL; }
<YYINITIAL> "<>" { return TigerTypes.NOT_EQUALS; }
<YYINITIAL> "of" { return TigerTypes.OF; }
<YYINITIAL> "|" { return TigerTypes.OR; }
<YYINITIAL> "+" { return TigerTypes.PLUS; }
<YYINITIAL> "primitive" { return TigerTypes.PRIMITIVE; }
<YYINITIAL> "}" { return TigerTypes.RIGHT_BRACE; }
<YYINITIAL> "]" { return TigerTypes.RIGHT_BRACKET; }
<YYINITIAL> ")" { return TigerTypes.RIGHT_PARENTHESIS; }
<YYINITIAL> ";" { return TigerTypes.SEMI_COLON; }
<YYINITIAL> "then" { return TigerTypes.THEN; }
<YYINITIAL> "to" { return TigerTypes.TO; }
<YYINITIAL> "type" { return TigerTypes.TYPE; }
<YYINITIAL> "var" { return TigerTypes.VAR; }
<YYINITIAL> "while" { return TigerTypes.WHILE; }

<YYINITIAL> [0-9]+ { return TigerTypes.INTEGER; }
<YYINITIAL> [A-Za-z][A-Za-z0-9_]* | "_main" { return TigerTypes.IDENTIFIER; }
// <YYINITIAL> \"([^\\\"]|\\([abfnrtv\\\"]|([0-9]+)|(x[A-Za-z0-9]{2})))*\" { return TigerTypes.STRING; }
<YYINITIAL> \"([^\\\"]|\\.)*\"? { return TigerTypes.STRING; }

(\R|[\ \n\t])+ { return TokenType.WHITE_SPACE; }

[^] { return TokenType.BAD_CHARACTER; }
