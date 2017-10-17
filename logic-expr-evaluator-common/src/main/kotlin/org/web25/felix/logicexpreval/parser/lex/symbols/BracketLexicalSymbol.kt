package org.web25.felix.logicexpreval.parser.lex.symbols

import org.web25.felix.logicexpreval.parser.lex.BracketType


abstract class BracketLexicalSymbol(glyphs: List<Char>, startIndex: Int, endIndex: Int) : LexicalSymbol(glyphs, startIndex, endIndex) {

    init {
        if (glyphs.size != 1) {
            throw RuntimeException("Invalid length for bracket symbol")
        }
    }

    val bracketType: BracketType
    get() {
        return when (glyphs[0]) {
            ')', '(' -> BracketType.ROUND
            '[', ']' -> BracketType.SQUARE
            '}', '{' -> BracketType.CURLY
            else -> throw RuntimeException("Invalid bracket type detected ${glyphs[0]}")
        }
    }

    override fun toString(): String = "ob:$bracketType"

    companion object {

        fun build(lexicalSymbol: LexicalSymbol): BracketLexicalSymbol {
            val glyph = lexicalSymbol.glyphs[0]
            if(glyph in arrayOf('(', '[', '{')) {
                return OpeningBracketLexicalSymbol(lexicalSymbol.glyphs, lexicalSymbol.startIndex, lexicalSymbol.endIndex)
            } else if (glyph in arrayOf(')', ']', '}')) {
                return ClosingBracketLexicalSymbol(lexicalSymbol.glyphs, lexicalSymbol.startIndex, lexicalSymbol.endIndex)
            } else {
                throw RuntimeException("Unknown bracket type found!")
            }
        }

        fun isBracket(char: Char): Boolean {
            if (char == ')' || char == '(') {
                return true
            } else if (char == '[' || char == ']') {
                return true
            } else return char == '{' || char == '}'
        }
    }
}

