package org.web25.felix.logicexpreval.parser.lex.symbols

/**
 * Represents an opening bracket.
 *
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 * @since 1.0.0
 */
class OpeningBracketLexicalSymbol(glyphs: List<Char>, startIndex: Int, endIndex: Int) : BracketLexicalSymbol(glyphs, startIndex, endIndex) {

    override val typeName: String = "OB"

    /**
     * The matching [ClosingBracketLexicalSymbol] for this [OpeningBracketLexicalSymbol].
     *
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     * @since 1.0.0
     */
    lateinit var closingBracket: ClosingBracketLexicalSymbol

    override fun toString(): String = "ob:$bracketType"
}