package org.web25.felix.logicexpreval.parser.lex.symbols

class WhitespaceLexicalSymbol(glyphs: List<Char>, startIndex: Int, endIndex: Int) : LexicalSymbol(glyphs, startIndex, endIndex) {

    override val typeName: String = "whitespace"

    override fun toString(): String = "WS"
}