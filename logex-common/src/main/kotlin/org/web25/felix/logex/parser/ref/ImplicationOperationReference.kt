package org.web25.felix.logex.parser.ref

import org.web25.felix.logex.node.ExpressionNode
import org.web25.felix.logex.node.ImplicationExpressionNode

class ImplicationOperationReference(val left: Reference, val right: Reference) : OperationReference() {

    override fun resolve(): ExpressionNode {
        return ImplicationExpressionNode(left.resolve(), right.resolve(), 0)
    }

}