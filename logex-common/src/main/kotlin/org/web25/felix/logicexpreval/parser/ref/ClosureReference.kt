package org.web25.felix.logicexpreval.parser.ref

import org.web25.felix.logicexpreval.node.ClosureExpressionNode
import org.web25.felix.logicexpreval.node.ExpressionNode

open class ClosureReference(val id: Int, var entryPoint: Reference): Reference() {

    override fun resolve(): ExpressionNode = ClosureExpressionNode(0, entryPoint.resolve())

    override fun toString(): String = "closure#$id:($entryPoint)${super.toString()}"

}