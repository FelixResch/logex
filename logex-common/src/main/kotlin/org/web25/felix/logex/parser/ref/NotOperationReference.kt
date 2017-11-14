package org.web25.felix.logex.parser.ref

import org.web25.felix.logex.node.ExpressionNode
import org.web25.felix.logex.node.NotExpressionNode

/**
 * References a **NOT** operation.
 *
 * This reference resolves [element] and creates a [NotExpressionNode].
 *
 * @property element the element this expression node will negate
 * @since 1.0.0
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 */
class NotOperationReference(val element: Reference) : OperationReference() {

    override fun resolve(): ExpressionNode = NotExpressionNode(element.resolve(), 0)

    override fun toString(): String = "op:not($element)${super.toString()}"
}