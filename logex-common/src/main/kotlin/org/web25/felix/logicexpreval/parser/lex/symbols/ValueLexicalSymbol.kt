package org.web25.felix.logicexpreval.parser.lex.symbols

/**
 * Represents a value.
 *
 * This is in general every combination of adjacent glyphs that have no other meaning.
 *
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 * @since 1.0.0
 */
class ValueLexicalSymbol(glyphs: List<Char>, startIndex: Int, endIndex: Int) : LexicalSymbol(glyphs, startIndex, endIndex) {

    override val typeName: String = "value"

    override fun toString(): String = "val:${glyphs.toCharArray().contentToString()}"
}