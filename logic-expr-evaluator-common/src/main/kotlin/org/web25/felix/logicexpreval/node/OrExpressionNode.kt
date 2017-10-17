package org.web25.felix.logicexpreval.node

import org.web25.felix.logicexpreval.EvaluationContext

class OrExpressionNode(partIndex: Int, val aNode: ExpressionNode, val bNode: ExpressionNode) : OperatorExpressionNode("or", partIndex) {

    override fun initialize(context: EvaluationContext) {
        aNode.initialize(context)
        bNode.initialize(context)
    }

    override fun evaluate(context: EvaluationContext): Boolean = aNode.evaluate(context) or bNode.evaluate(context)

    override fun children(): List<ExpressionNode> = listOf(aNode, bNode)

    override fun buildLogicString(): String = "${aNode.buildLogicString()} \u2228 ${bNode.buildLogicString()}"
}