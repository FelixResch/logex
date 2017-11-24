package org.web25.felix.logex.node

import org.web25.felix.logex.EvaluationContext

class ImplicationExpressionNode(val left: ExpressionNode, val right: ExpressionNode, partIndex: Int) : OperatorExpressionNode("impl", partIndex) {

    override fun initialize(context: EvaluationContext) {
        left.initialize(context)
        right.initialize(context)
    }

    override fun evaluate(context: EvaluationContext) = !left.evaluate(context) or right.evaluate(context)

    override fun children(): List<ExpressionNode> = listOf(left, right)

    override fun buildLogicString(): String = "${left.buildLogicString()} \u21D2 ${right.buildLogicString()}"
}