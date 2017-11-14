package org.web25.felix.logex.parser.lex.symbols

/**
 * Represents a set of glyphs that can be simplified to one single string.
 *
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 * @since 1.0.0
 */
class CharacterLexicalSymbol(glyphs: List<Char>, startIndex: Int, endIndex: Int) : LexicalSymbol(glyphs, startIndex, endIndex) {

    /**
     * Creates a single glyph [CharacterLexicalSymbol]
     *
     * @param glyph the glyph of the symbol
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     * @since 1.0.0
     */
    constructor(glyph: Char, startIndex: Int, endIndex: Int): this(listOf(glyph), startIndex, endIndex)

    override val typeName: String = "char"

    /**
     * The length of the lexical symbol
     *
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     * @since 1.0.0
     */
    var length: Int
    get() = glyphs.size
    set(_) {}

    /**
     * Creates a string from the glyphs of this [LexicalSymbol]
     */
    override fun toString(): String = "chars:[${glyphs.joinToString()}]"
}