package org.web25.felix.logicexpreval.parser.lex.symbols

/**
 * Represents any number of whitespace characters.
 *
 * This lexical symbol represents a separator betweem [CharacterLexicalSymbol]s, to distinguish values.
 *
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 * @since 1.0.0
 */
class WhitespaceLexicalSymbol(glyphs: List<Char>, startIndex: Int, endIndex: Int) : LexicalSymbol(glyphs, startIndex, endIndex) {

    override val typeName: String = "whitespace"

    override fun toString(): String = "WS"
}