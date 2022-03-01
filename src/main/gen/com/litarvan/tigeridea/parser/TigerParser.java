// This is a generated file. Not intended for manual editing.
package com.litarvan.tigeridea.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.litarvan.tigeridea.psi.TigerTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class TigerParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return program(b, l + 1);
  }

  /* ********************************************************** */
  // { type_declaration }+   /* tychunk */
  //   | { function_declaration }+  /* funchunk */
  //   | variable_declaration      /* varchunk */
  //   /* Importing a set of declarations. */
  //   | IMPORT STRING
  public static boolean chunk(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "chunk")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CHUNK, "<chunk>");
    r = chunk_0(b, l + 1);
    if (!r) r = chunk_1(b, l + 1);
    if (!r) r = variable_declaration(b, l + 1);
    if (!r) r = parseTokens(b, 0, IMPORT, STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // { type_declaration }+
  private static boolean chunk_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "chunk_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = chunk_0_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!chunk_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "chunk_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // { type_declaration }
  private static boolean chunk_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "chunk_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_declaration(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // { function_declaration }+
  private static boolean chunk_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "chunk_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = chunk_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!chunk_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "chunk_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // { function_declaration }
  private static boolean chunk_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "chunk_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = function_declaration(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // { chunk }+
  public static boolean chunks(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "chunks")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CHUNKS, "<chunks>");
    r = chunks_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!chunks_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "chunks", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // { chunk }
  private static boolean chunks_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "chunks_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = chunk(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expression_part operator expression
  //                | expression_part
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = expression_0(b, l + 1);
    if (!r) r = expression_part(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // expression_part operator expression
  private static boolean expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression_part(b, l + 1);
    r = r && operator(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NIL
  //   | INTEGER
  //   | STRING
  //   /* Array and record creations. */
  //   | type_id LEFT_BRACKET expression RIGHT_BRACKET OF expression
  //   | type_id LEFT_BRACE [ IDENTIFIER EQUALS expression { COMMA IDENTIFIER EQUALS expression }* ] RIGHT_BRACE
  //   /* Function call. */
  //   | IDENTIFIER LEFT_PARENTHESIS [ expression { COMMA expression }*] RIGHT_PARENTHESIS
  //   /* Operations. */
  //   | MINUS expression
  //   // >:( LEFT RECURSION CRINGE
  //   /* | expression operator expression */
  //   | LEFT_PARENTHESIS expressions RIGHT_PARENTHESIS
  //   /* Assignment. */
  //   | lvalue ASSIGN expression
  //   /* Variables, field, elements of an array. */
  //   | lvalue
  //   /* Control structures. */
  //   | IF expression THEN expression [ELSE expression]
  //   | WHILE expression DO expression
  //   | FOR IDENTIFIER ASSIGN expression TO expression DO expression
  //   | BREAK
  //   | LET chunks IN expressions END
  public static boolean expression_part(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_part")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION_PART, "<expression part>");
    r = consumeToken(b, NIL);
    if (!r) r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = expression_part_3(b, l + 1);
    if (!r) r = expression_part_4(b, l + 1);
    if (!r) r = expression_part_5(b, l + 1);
    if (!r) r = expression_part_6(b, l + 1);
    if (!r) r = expression_part_7(b, l + 1);
    if (!r) r = expression_part_8(b, l + 1);
    if (!r) r = lvalue(b, l + 1);
    if (!r) r = expression_part_10(b, l + 1);
    if (!r) r = expression_part_11(b, l + 1);
    if (!r) r = expression_part_12(b, l + 1);
    if (!r) r = consumeToken(b, BREAK);
    if (!r) r = expression_part_14(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // type_id LEFT_BRACKET expression RIGHT_BRACKET OF expression
  private static boolean expression_part_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_part_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_id(b, l + 1);
    r = r && consumeToken(b, LEFT_BRACKET);
    r = r && expression(b, l + 1);
    r = r && consumeTokens(b, 0, RIGHT_BRACKET, OF);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // type_id LEFT_BRACE [ IDENTIFIER EQUALS expression { COMMA IDENTIFIER EQUALS expression }* ] RIGHT_BRACE
  private static boolean expression_part_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_part_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_id(b, l + 1);
    r = r && consumeToken(b, LEFT_BRACE);
    r = r && expression_part_4_2(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ IDENTIFIER EQUALS expression { COMMA IDENTIFIER EQUALS expression }* ]
  private static boolean expression_part_4_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_part_4_2")) return false;
    expression_part_4_2_0(b, l + 1);
    return true;
  }

  // IDENTIFIER EQUALS expression { COMMA IDENTIFIER EQUALS expression }*
  private static boolean expression_part_4_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_part_4_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, EQUALS);
    r = r && expression(b, l + 1);
    r = r && expression_part_4_2_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // { COMMA IDENTIFIER EQUALS expression }*
  private static boolean expression_part_4_2_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_part_4_2_0_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expression_part_4_2_0_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expression_part_4_2_0_3", c)) break;
    }
    return true;
  }

  // COMMA IDENTIFIER EQUALS expression
  private static boolean expression_part_4_2_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_part_4_2_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, IDENTIFIER, EQUALS);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER LEFT_PARENTHESIS [ expression { COMMA expression }*] RIGHT_PARENTHESIS
  private static boolean expression_part_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_part_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, LEFT_PARENTHESIS);
    r = r && expression_part_5_2(b, l + 1);
    r = r && consumeToken(b, RIGHT_PARENTHESIS);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ expression { COMMA expression }*]
  private static boolean expression_part_5_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_part_5_2")) return false;
    expression_part_5_2_0(b, l + 1);
    return true;
  }

  // expression { COMMA expression }*
  private static boolean expression_part_5_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_part_5_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && expression_part_5_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // { COMMA expression }*
  private static boolean expression_part_5_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_part_5_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expression_part_5_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expression_part_5_2_0_1", c)) break;
    }
    return true;
  }

  // COMMA expression
  private static boolean expression_part_5_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_part_5_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // MINUS expression
  private static boolean expression_part_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_part_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MINUS);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_PARENTHESIS expressions RIGHT_PARENTHESIS
  private static boolean expression_part_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_part_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PARENTHESIS);
    r = r && expressions(b, l + 1);
    r = r && consumeToken(b, RIGHT_PARENTHESIS);
    exit_section_(b, m, null, r);
    return r;
  }

  // lvalue ASSIGN expression
  private static boolean expression_part_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_part_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = lvalue(b, l + 1);
    r = r && consumeToken(b, ASSIGN);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IF expression THEN expression [ELSE expression]
  private static boolean expression_part_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_part_10")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, THEN);
    r = r && expression(b, l + 1);
    r = r && expression_part_10_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ELSE expression]
  private static boolean expression_part_10_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_part_10_4")) return false;
    expression_part_10_4_0(b, l + 1);
    return true;
  }

  // ELSE expression
  private static boolean expression_part_10_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_part_10_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WHILE expression DO expression
  private static boolean expression_part_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_part_11")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, DO);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FOR IDENTIFIER ASSIGN expression TO expression DO expression
  private static boolean expression_part_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_part_12")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FOR, IDENTIFIER, ASSIGN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, TO);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, DO);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LET chunks IN expressions END
  private static boolean expression_part_14(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_part_14")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LET);
    r = r && chunks(b, l + 1);
    r = r && consumeToken(b, IN);
    r = r && expressions(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // [ expression { SEMI_COLON expression }* ]
  public static boolean expressions(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressions")) return false;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSIONS, "<expressions>");
    expressions_0(b, l + 1);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // expression { SEMI_COLON expression }*
  private static boolean expressions_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressions_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && expressions_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // { SEMI_COLON expression }*
  private static boolean expressions_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressions_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expressions_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expressions_0_1", c)) break;
    }
    return true;
  }

  // SEMI_COLON expression
  private static boolean expressions_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressions_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMI_COLON);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FUNCTION IDENTIFIER LEFT_PARENTHESIS parameters RIGHT_PARENTHESIS [ COLON type_id ] EQUALS expression
  //   | PRIMITIVE IDENTIFIER LEFT_PARENTHESIS parameters RIGHT_PARENTHESIS [ COLON type_id ]
  public static boolean function_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_declaration")) return false;
    if (!nextTokenIs(b, "<function declaration>", FUNCTION, PRIMITIVE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_DECLARATION, "<function declaration>");
    r = function_declaration_0(b, l + 1);
    if (!r) r = function_declaration_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // FUNCTION IDENTIFIER LEFT_PARENTHESIS parameters RIGHT_PARENTHESIS [ COLON type_id ] EQUALS expression
  private static boolean function_declaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_declaration_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FUNCTION, IDENTIFIER, LEFT_PARENTHESIS);
    r = r && parameters(b, l + 1);
    r = r && consumeToken(b, RIGHT_PARENTHESIS);
    r = r && function_declaration_0_5(b, l + 1);
    r = r && consumeToken(b, EQUALS);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ COLON type_id ]
  private static boolean function_declaration_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_declaration_0_5")) return false;
    function_declaration_0_5_0(b, l + 1);
    return true;
  }

  // COLON type_id
  private static boolean function_declaration_0_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_declaration_0_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type_id(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // PRIMITIVE IDENTIFIER LEFT_PARENTHESIS parameters RIGHT_PARENTHESIS [ COLON type_id ]
  private static boolean function_declaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_declaration_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PRIMITIVE, IDENTIFIER, LEFT_PARENTHESIS);
    r = r && parameters(b, l + 1);
    r = r && consumeToken(b, RIGHT_PARENTHESIS);
    r = r && function_declaration_1_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ COLON type_id ]
  private static boolean function_declaration_1_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_declaration_1_5")) return false;
    function_declaration_1_5_0(b, l + 1);
    return true;
  }

  // COLON type_id
  private static boolean function_declaration_1_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_declaration_1_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type_id(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER { lvalue_suffix }*
  public static boolean lvalue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lvalue")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && lvalue_1(b, l + 1);
    exit_section_(b, m, LVALUE, r);
    return r;
  }

  // { lvalue_suffix }*
  private static boolean lvalue_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lvalue_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!lvalue_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "lvalue_1", c)) break;
    }
    return true;
  }

  // { lvalue_suffix }
  private static boolean lvalue_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lvalue_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = lvalue_suffix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DOT IDENTIFIER
  //   | LEFT_BRACKET expression RIGHT_BRACKET
  public static boolean lvalue_suffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lvalue_suffix")) return false;
    if (!nextTokenIs(b, "<lvalue suffix>", DOT, LEFT_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LVALUE_SUFFIX, "<lvalue suffix>");
    r = parseTokens(b, 0, DOT, IDENTIFIER);
    if (!r) r = lvalue_suffix_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LEFT_BRACKET expression RIGHT_BRACKET
  private static boolean lvalue_suffix_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lvalue_suffix_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACKET);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PLUS | MINUS | MULTIPLIES | DIVIDES | EQUALS | NOT_EQUALS | GREATER | LOWER | GREATER_EQUAL | LOWER_EQUAL | AND | OR
  public static boolean operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPERATOR, "<operator>");
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, MULTIPLIES);
    if (!r) r = consumeToken(b, DIVIDES);
    if (!r) r = consumeToken(b, EQUALS);
    if (!r) r = consumeToken(b, NOT_EQUALS);
    if (!r) r = consumeToken(b, GREATER);
    if (!r) r = consumeToken(b, LOWER);
    if (!r) r = consumeToken(b, GREATER_EQUAL);
    if (!r) r = consumeToken(b, LOWER_EQUAL);
    if (!r) r = consumeToken(b, AND);
    if (!r) r = consumeToken(b, OR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // [ IDENTIFIER COLON type_id { COMMA IDENTIFIER COLON type_id }* ]
  public static boolean parameters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters")) return false;
    Marker m = enter_section_(b, l, _NONE_, PARAMETERS, "<parameters>");
    parameters_0(b, l + 1);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // IDENTIFIER COLON type_id { COMMA IDENTIFIER COLON type_id }*
  private static boolean parameters_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, COLON);
    r = r && type_id(b, l + 1);
    r = r && parameters_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // { COMMA IDENTIFIER COLON type_id }*
  private static boolean parameters_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_0_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!parameters_0_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "parameters_0_3", c)) break;
    }
    return true;
  }

  // COMMA IDENTIFIER COLON type_id
  private static boolean parameters_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, IDENTIFIER, COLON);
    r = r && type_id(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expression
  //   | chunks
  static boolean program(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program")) return false;
    boolean r;
    r = expression(b, l + 1);
    if (!r) r = chunks(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // TYPE IDENTIFIER EQUALS type_ref
  public static boolean type_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_declaration")) return false;
    if (!nextTokenIs(b, TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, TYPE, IDENTIFIER, EQUALS);
    r = r && type_ref(b, l + 1);
    exit_section_(b, m, TYPE_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean type_id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_id")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, TYPE_ID, r);
    return r;
  }

  /* ********************************************************** */
  // type_id
  //    /* Record type definition. */
  //    | LEFT_BRACE parameters  RIGHT_BRACE
  //    /* Array type definition. */
  //    | ARRAY OF type_id
  public static boolean type_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_ref")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_REF, "<type ref>");
    r = type_id(b, l + 1);
    if (!r) r = type_ref_1(b, l + 1);
    if (!r) r = type_ref_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LEFT_BRACE parameters  RIGHT_BRACE
  private static boolean type_ref_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_ref_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACE);
    r = r && parameters(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // ARRAY OF type_id
  private static boolean type_ref_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_ref_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ARRAY, OF);
    r = r && type_id(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // VAR IDENTIFIER [ COLON type_id ] ASSIGN expression
  public static boolean variable_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_declaration")) return false;
    if (!nextTokenIs(b, VAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, VAR, IDENTIFIER);
    r = r && variable_declaration_2(b, l + 1);
    r = r && consumeToken(b, ASSIGN);
    r = r && expression(b, l + 1);
    exit_section_(b, m, VARIABLE_DECLARATION, r);
    return r;
  }

  // [ COLON type_id ]
  private static boolean variable_declaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_declaration_2")) return false;
    variable_declaration_2_0(b, l + 1);
    return true;
  }

  // COLON type_id
  private static boolean variable_declaration_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_declaration_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type_id(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

}
