package org.web25.felix.logicexpreval.parser.ref

import org.web25.felix.logicexpreval.node.ExpressionNode
import org.web25.felix.logicexpreval.node.NotExpressionNode

class NotOperationReference(val element: Reference) : OperationReference() {

    override fun resolve(): ExpressionNode = NotExpressionNode(element.resolve(), 0)

    override fun toString(): String = "op:not($element)${super.toString()}"
}