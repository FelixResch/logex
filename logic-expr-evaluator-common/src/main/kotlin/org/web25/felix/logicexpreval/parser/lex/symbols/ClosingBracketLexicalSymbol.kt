package org.web25.felix.logicexpreval.parser.lex.symbols

class ClosingBracketLexicalSymbol(glyphs: List<Char>, startIndex: Int, endIndex: Int) : BracketLexicalSymbol(glyphs, startIndex, endIndex) {

    override val typeName: String = "CB"

    lateinit var openingBracket : OpeningBracketLexicalSymbol
}