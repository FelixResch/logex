package org.web25.felix.logex.parser.ref

import org.web25.felix.logex.node.ExpressionNode
import org.web25.felix.logex.parser.lex.symbols.LexicalSymbol

/**
 * Represents a lexer symbol.
 *
 * This implementation of [Reference] will throw when [Reference.resolve] is called.
 *
 * @property lexicalSymbol the symbol this reference represents
 * @since 1.0.0
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 */
class SymbolReference(val lexicalSymbol: LexicalSymbol): Reference() {

    /**
     * This symbol should not be called as no [SymbolReference] should be left in the expression after parsing.
     *
     * @throws RuntimeException as this method should never be invoked on this type of reference
     * @since 1.0.0
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     */
    override fun resolve(): ExpressionNode {
        throw RuntimeException("This type of Reference should never be resolved!")
    }
}