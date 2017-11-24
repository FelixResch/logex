package org.web25.felix.logex.parser.ref

import org.web25.felix.logex.node.EquivalenceExpressionNode
import org.web25.felix.logex.node.ExpressionNode

class EquivalenceOperationReference(val left: Reference, val right: Reference): OperationReference() {

    override fun resolve(): ExpressionNode = EquivalenceExpressionNode(left.resolve(), right.resolve(), 0)

}