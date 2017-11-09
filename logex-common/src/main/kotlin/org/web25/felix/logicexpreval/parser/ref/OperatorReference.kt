package org.web25.felix.logicexpreval.parser.ref

import org.web25.felix.logicexpreval.node.ExpressionNode
import org.web25.felix.logicexpreval.parser.lex.symbols.OperatorLexicalSymbol

/**
 * A reference to an operator
 *
 * @param lexicalSymbol The symbol this reference is mapped to.
 * @since 1.0.0
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 */
class OperatorReference(lexicalSymbol: OperatorLexicalSymbol): Reference() {

    /**
     * Stores the type of operator this reference should represent.
     *
     * @since 1.0.0
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     */
    val operatorType = lexicalSymbol.operatorType

    /**
     * This is an intermediary node and should not be resolved.
     *
     * @since 1.0.0
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     */
    override fun resolve(): ExpressionNode {
        TODO("Intermediary references should not be evaluated!")
    }

    override fun toString(): String = "op:${operatorType.name}${super.toString()}"
}