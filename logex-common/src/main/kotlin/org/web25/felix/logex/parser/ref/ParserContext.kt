package org.web25.felix.logex.parser.ref

import org.web25.felix.logex.parser.lex.symbols.BracketLexicalSymbol
import org.web25.felix.logex.parser.lex.symbols.OpeningBracketLexicalSymbol

/**
 * Stores information of the current parsing operation.
 *
 * @since 1.0.0
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 */
class ParserContext {

    /**
     * Maps a closing [BracketLexicalSymbol] to its opening Reference.
     *
     * @since 1.0.0
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     */
    val brackets = mutableMapOf<String, BracketReference>()

    /**
     * Stores a list of the not yet parsed closures.
     *
     * During parsing the closures found in other closures are added to this list.
     * After a closure has been processed it is removed from this list.
     *
     * @since 1.0.0
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     */
    val closures = mutableListOf<ClosureReference>()

    /**
     * Keeps track of the closure IDs.
     *
     * @since 1.0.0
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     */
    var closureCounter = 0
}

