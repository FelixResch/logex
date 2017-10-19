package org.web25.felix.logicexpreval.parser.lex

import org.web25.felix.logicexpreval.parser.lex.symbols.CharacterLexicalSymbol

fun List<CharacterLexicalSymbol>.simplify(): CharacterLexicalSymbol {
    val start : Int = this.map { it.startIndex }.min()?: 0
    val end : Int = this.map { it.endIndex }.max()?: 0
    val glyphs = this.flatMap { it.glyphs }
    return CharacterLexicalSymbol(glyphs, start, end)
}