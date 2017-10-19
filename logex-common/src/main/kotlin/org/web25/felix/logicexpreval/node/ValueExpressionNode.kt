package org.web25.felix.logicexpreval.node

import org.web25.felix.logicexpreval.EvaluationContext

class ValueExpressionNode(override val name: String, override val partIndex: Int) : ExpressionNode {

    override fun initialize(context: EvaluationContext) {
        context.allocateVariable(name)
    }

    override fun evaluate(context: EvaluationContext): Boolean {
        val value = context[name]
        if(value != null) {
            return value
        } else {
            throw RuntimeException("Value $name not found!")
        }
    }

    override fun children(): List<ExpressionNode> = emptyList()

    override fun buildLogicString(): String = name
}
