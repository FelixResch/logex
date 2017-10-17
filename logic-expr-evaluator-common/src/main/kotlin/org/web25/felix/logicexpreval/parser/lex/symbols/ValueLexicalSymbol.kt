package org.web25.felix.logicexpreval.parser.lex.symbols

class ValueLexicalSymbol(glyphs: List<Char>, startIndex: Int, endIndex: Int) : LexicalSymbol(glyphs, startIndex, endIndex) {

    override val typeName: String = "value"

    override fun toString(): String = "val:${glyphs.toCharArray().contentToString()}"
}