package org.web25.felix.logicexpreval.parser.ref

import org.web25.felix.logicexpreval.node.AndExpressionNode
import org.web25.felix.logicexpreval.node.ExpressionNode

class AndOperationReference(val left: Reference, val right: Reference) : OperationReference() {

    override fun resolve(): ExpressionNode = AndExpressionNode(0, left.resolve(), right.resolve())

    override fun toString(): String = "op:and($left, $right)${super.toString()}"
}

