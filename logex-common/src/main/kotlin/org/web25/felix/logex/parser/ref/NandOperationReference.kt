package org.web25.felix.logex.parser.ref

import org.web25.felix.logex.node.NandExpressionNode
import org.web25.felix.logex.node.ExpressionNode

/**
 * References an **NAND** operator.
 *
 * The returned operation will resolve [left] and [right] and will create an [NandExpressionNode]
 * using them.
 *
 * @param left the reference to the left part of the expression
 * @param right the reference to the right part of the expression
 * @since 1.0.0
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 */
class NandOperationReference(val left: Reference, val right: Reference) : OperationReference() {

    override fun resolve(): ExpressionNode = NandExpressionNode(0, left.resolve(), right.resolve())

    override fun toString(): String = "op:nand($left, $right)${super.toString()}"
}

