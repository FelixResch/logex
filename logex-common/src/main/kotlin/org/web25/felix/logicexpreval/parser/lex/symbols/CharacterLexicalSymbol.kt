package org.web25.felix.logicexpreval.parser.lex.symbols

class CharacterLexicalSymbol(glyphs: List<Char>, startIndex: Int, endIndex: Int) : LexicalSymbol(glyphs, startIndex, endIndex) {

    constructor(glyph: Char, startIndex: Int, endIndex: Int): this(listOf(glyph), startIndex, endIndex)

    override val typeName: String = "char"

    var length: Int
    get() = glyphs.size
    set(value) {}
}