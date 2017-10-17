package org.web25.felix.logicexpreval.parser.lex.symbols

class OpeningBracketLexicalSymbol(glyphs: List<Char>, startIndex: Int, endIndex: Int) : BracketLexicalSymbol(glyphs, startIndex, endIndex) {

    override val typeName: String = "OB"

    lateinit var closingBracket: ClosingBracketLexicalSymbol
}