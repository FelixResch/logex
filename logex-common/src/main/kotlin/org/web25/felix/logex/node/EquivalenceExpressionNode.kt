package org.web25.felix.logex.node

import org.web25.felix.logex.EvaluationContext

class EquivalenceExpressionNode(val left: ExpressionNode, val right: ExpressionNode, partIndex: Int) : OperatorExpressionNode("eq", partIndex) {

    override fun initialize(context: EvaluationContext) {
        (left + right).forEach { it.initialize(context) }
    }

    override fun evaluate(context: EvaluationContext): Boolean = left.evaluate(context) == right.evaluate(context)

    override fun children(): List<ExpressionNode> = (left + right)

    override fun buildLogicString(): String = "${left.buildLogicString()} \u21D4 ${right.buildLogicString()}"
}