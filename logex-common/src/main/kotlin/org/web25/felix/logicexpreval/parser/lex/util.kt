package org.web25.felix.logicexpreval.parser.lex

import org.web25.felix.logicexpreval.parser.lex.symbols.CharacterLexicalSymbol

/**
 * Simplifies a list of [CharacterLexicalSymbol]s so that one [CharacterLexicalSymbol] is returned.
 *
 * @receiver a list of [CharacterLexicalSymbol]s that can be simplified
 * @return one [CharacterLexicalSymbol] that contains all glyphs in the original list of [CharacterLexicalSymbol]s
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 * @since 1.0.0
 */
fun List<CharacterLexicalSymbol>.simplify(): CharacterLexicalSymbol {
    val start : Int = this.map { it.startIndex }.min()?: 0
    val end : Int = this.map { it.endIndex }.max()?: 0
    val glyphs = this.flatMap { it.glyphs }
    return CharacterLexicalSymbol(glyphs, start, end)
}