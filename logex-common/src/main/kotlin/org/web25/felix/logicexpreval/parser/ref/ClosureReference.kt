package org.web25.felix.logicexpreval.parser.ref

import org.web25.felix.logicexpreval.node.ClosureExpressionNode
import org.web25.felix.logicexpreval.node.ExpressionNode

class ClosureReference(val id: Int, val entryPoint: Reference): Reference() {

    override fun resolve(): ExpressionNode = ClosureExpressionNode(0, entryPoint.resolve())

}