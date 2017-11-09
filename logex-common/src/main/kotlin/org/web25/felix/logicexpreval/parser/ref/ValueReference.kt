package org.web25.felix.logicexpreval.parser.ref

import org.web25.felix.logicexpreval.node.ExpressionNode
import org.web25.felix.logicexpreval.node.ValueExpressionNode
import org.web25.felix.logicexpreval.parser.lex.symbols.LexicalSymbol

/**
 * Stores a reference to a value identifier.
 *
 * @param lexicalSymbol the symbol this [ValueReference] should encapsulate
 * @since 1.0.0
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 */
class ValueReference(lexicalSymbol: LexicalSymbol): Reference() {

    /**
     * The name of the value identifier
     *
     * @since 1.0.0
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     */
    private val name: String = lexicalSymbol.glyphs.joinToString()

    override fun resolve(): ExpressionNode = ValueExpressionNode(name, 0)

    override fun toString(): String = "val:$name${super.toString()}"
}