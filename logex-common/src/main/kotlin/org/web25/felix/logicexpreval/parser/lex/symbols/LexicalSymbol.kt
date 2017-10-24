package org.web25.felix.logicexpreval.parser.lex.symbols

/**
 * A symbol wrapping one or more glyphs from [startIndex] to [endIndex].
 *
 * @property glyphs the glyphs that are wrapped by this [LexicalSymbol]
 * @property startIndex the start index in the whole expression
 * @property endIndex the end index in the whole expression
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 * @since 1.0.0
 */
abstract class LexicalSymbol(val glyphs: List<Char>, val startIndex: Int, val endIndex: Int) {

    /**
     * The name of the type of lexical symbol.
     *
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     * @since 1.0.0
     */
    abstract val typeName: String

}