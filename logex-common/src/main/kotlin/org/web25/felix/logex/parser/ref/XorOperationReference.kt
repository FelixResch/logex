package org.web25.felix.logex.parser.ref

import org.web25.felix.logex.node.ExpressionNode
import org.web25.felix.logex.node.XorExpressionNode

class XorOperationReference(val left: Reference, val right: Reference) : OperationReference() {

    override fun resolve(): ExpressionNode = XorExpressionNode(left.resolve(), right.resolve(), 0)

}