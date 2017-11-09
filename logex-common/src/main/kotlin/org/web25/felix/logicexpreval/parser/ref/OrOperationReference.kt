package org.web25.felix.logicexpreval.parser.ref

import org.web25.felix.logicexpreval.node.ExpressionNode
import org.web25.felix.logicexpreval.node.OrExpressionNode

class OrOperationReference(val left: Reference, val right: Reference) : OperationReference() {

    override fun resolve(): ExpressionNode = OrExpressionNode(0, left.resolve(), right.resolve())

    override fun toString(): String = "op:or($left, $right)${super.toString()}"
}