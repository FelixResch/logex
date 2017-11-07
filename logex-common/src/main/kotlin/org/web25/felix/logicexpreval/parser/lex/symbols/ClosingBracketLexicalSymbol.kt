package org.web25.felix.logicexpreval.parser.lex.symbols

/**
 * Represents a closing bracket.
 *
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 * @since 1.0.0
 */
class ClosingBracketLexicalSymbol(glyphs: List<Char>, startIndex: Int, endIndex: Int) : BracketLexicalSymbol(glyphs, startIndex, endIndex) {

    override val typeName: String = "CB"

    /**
     * The matching [OpeningBracketLexicalSymbol] for this [ClosingBracketLexicalSymbol].
     *
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     * @since 1.0.0
     */
    lateinit var openingBracket : OpeningBracketLexicalSymbol
}