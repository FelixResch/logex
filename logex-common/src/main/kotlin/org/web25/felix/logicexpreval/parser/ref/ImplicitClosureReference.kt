package org.web25.felix.logicexpreval.parser.ref

import org.web25.felix.logicexpreval.node.ExpressionNode

class ImplicitClosureReference(id: Int, entryPoint: Reference) : ClosureReference(id, entryPoint) {

    override fun resolve(): ExpressionNode = entryPoint.resolve()

    override fun toString(): String = "root:$entryPoint"
}