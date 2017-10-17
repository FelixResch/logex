package org.web25.felix.logicexpreval.parser.lex.symbols

abstract class LexicalSymbol(val glyphs: List<Char>, val startIndex: Int, val endIndex: Int) {

    abstract val typeName: String

}