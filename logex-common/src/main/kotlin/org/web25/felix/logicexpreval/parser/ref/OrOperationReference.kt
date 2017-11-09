package org.web25.felix.logicexpreval.parser.ref

import org.web25.felix.logicexpreval.node.AndExpressionNode
import org.web25.felix.logicexpreval.node.ExpressionNode
import org.web25.felix.logicexpreval.node.OrExpressionNode

/**
 * References an **OR** operator.
 *
 * The returned operation will resolve [left] and [right] and will create an [OrExpressionNode]
 * using them.
 *
 * @param left the reference to the left part of the expression
 * @param right the reference to the right part of the expression
 * @since 1.0.0
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 */
class OrOperationReference(val left: Reference, val right: Reference) : OperationReference() {

    override fun resolve(): ExpressionNode = OrExpressionNode(0, left.resolve(), right.resolve())

    override fun toString(): String = "op:or($left, $right)${super.toString()}"
}