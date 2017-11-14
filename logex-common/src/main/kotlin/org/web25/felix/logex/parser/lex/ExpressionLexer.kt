package org.web25.felix.logex.parser.lex

import org.web25.felix.logex.parser.lex.symbols.LexicalSymbol

/**
 * Expression lexer that creates a list of symbols from strings
 *
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 * @since 1.0.0
 */
interface ExpressionLexer {

    /**
     * Performs the lexing operation.
     *
     * @param parts a list of strings, that contain glyphs
     * @return a list of [LexicalSymbol]s that are created from the list of strings
     */
    fun lex(parts: List<String>): List<LexicalSymbol>
}

