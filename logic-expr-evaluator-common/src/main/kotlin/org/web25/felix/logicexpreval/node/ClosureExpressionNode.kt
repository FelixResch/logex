package org.web25.felix.logicexpreval.node

import org.web25.felix.logicexpreval.EvaluationContext

class ClosureExpressionNode(override val partIndex: Int, val content: ExpressionNode) : ExpressionNode {

    override val name: String = "closure"

    override fun initialize(context: EvaluationContext) {
        content.initialize(context)
    }

    override fun evaluate(context: EvaluationContext): Boolean = content.evaluate(context)

    override fun children(): List<ExpressionNode> = listOf(content)

    override fun buildLogicString(): String = "( ${content.buildLogicString()} )"
}