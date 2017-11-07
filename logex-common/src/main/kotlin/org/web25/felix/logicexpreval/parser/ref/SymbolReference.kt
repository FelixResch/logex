package org.web25.felix.logicexpreval.parser.ref

import org.web25.felix.logicexpreval.node.ExpressionNode
import org.web25.felix.logicexpreval.parser.lex.symbols.LexicalSymbol

/**
 * Represents a lexer symbol.
 *
 * This implementation of [Reference] will throw when [Reference.resolve] is called.
 *
 * @property lexicalSymbol the symbol this reference represents
 * @since 1.0.0
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 */
class SymbolReference(val lexicalSymbol: LexicalSymbol): Reference {

    /**
     * @throws RuntimeException as this method should never be invoked on this type of reference
     */
    override fun resolve(): ExpressionNode {
        throw RuntimeException("This type of Reference should never be resolved!")
    }
}