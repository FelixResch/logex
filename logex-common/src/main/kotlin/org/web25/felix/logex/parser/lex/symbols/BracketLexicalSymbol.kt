package org.web25.felix.logex.parser.lex.symbols

import org.web25.felix.logex.parser.lex.BracketType

/**
 * Represents any bracket in the list of symbols.
 *
 * A bracket is a single symbol that contains one bracket character.
 *
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 * @since 1.0.0
 */
abstract class BracketLexicalSymbol(glyphs: List<Char>, startIndex: Int, endIndex: Int) : LexicalSymbol(glyphs, startIndex, endIndex) {

    init {
        if (glyphs.size != 1) {
            throw RuntimeException("Invalid length for bracket symbol")
        }
    }

    /**
     * The type of bracket the symbol represents.
     *
     * At the moment only the types defined in [BracketType] are considered brackets.
     *
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     * @since 1.0.0
     */
    val bracketType: BracketType
    get() {
        return when (glyphs[0]) {
            ')', '(' -> BracketType.ROUND
            '[', ']' -> BracketType.SQUARE
            '}', '{' -> BracketType.CURLY
            else -> throw RuntimeException("Invalid bracket type detected ${glyphs[0]}")
        }
    }

    companion object {

        /**
         * Builds a [BracketLexicalSymbol] from a [LexicalSymbol].
         *
         * Only the first character of the [lexicalSymbol] will be used to determine the type of the bracket. If
         * the bracket type is not known a [RuntimeException] is thrown.
         *
         * @param lexicalSymbol A single glyph lexical symbol that contains a bracket
         * @return either an [OpeningBracketLexicalSymbol] or a [ClosingBracketLexicalSymbol] matching the type of bracket supplied in [lexicalSymbol]
         * @throws kotlin.RuntimeException if no matching bracket type was found
         * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
         * @since 1.0.0
         */
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

        /**
         * Checks whether [char] is a bracket.
         *
         * @param char the character to test
         * @return if [char] is `)`, `(`, `[`, `]`, `{` or `}`
         */
        fun isBracket(char: Char): Boolean {
            if (char == ')' || char == '(') {
                return true
            } else if (char == '[' || char == ']') {
                return true
            } else return char == '{' || char == '}'
        }
    }
}

