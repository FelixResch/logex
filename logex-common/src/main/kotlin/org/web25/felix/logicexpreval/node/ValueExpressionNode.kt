package org.web25.felix.logicexpreval.node

import org.web25.felix.logicexpreval.EvaluationContext

/**
 * A node that reads the value from the [EvaluationContext] on evaluation.
 *
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 * @since 1.0.0
 */
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
