package org.web25.felix.logex.node

import org.web25.felix.logex.EvaluationContext

class XorExpressionNode(val left: ExpressionNode, val right: ExpressionNode, partIndex: Int) : OperatorExpressionNode("xor", partIndex) {

    override fun initialize(context: EvaluationContext) {
        (left + right).forEach { it.initialize(context) }
    }

    override fun evaluate(context: EvaluationContext): Boolean = left.evaluate(context) xor right.evaluate(context)

    override fun children(): List<ExpressionNode> = left + right

    override fun buildLogicString(): String = "${left.buildLogicString()} \u2297 ${right.buildLogicString()}"
}