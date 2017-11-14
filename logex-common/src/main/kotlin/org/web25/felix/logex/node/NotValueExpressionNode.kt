package org.web25.felix.logex.node

import org.web25.felix.logex.EvaluationContext

/**
 * Optimized node for negated variables. This node should be the preferred node if a value is negated directly.
 *
 * @since 1.0.0
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 */
class NotValueExpressionNode(override val name: String, override val partIndex: Int) : ExpressionNode {

    override fun initialize(context: EvaluationContext) {
        context.allocateVariable(name)
    }

    override fun evaluate(context: EvaluationContext): Boolean {
        val value = context[name]
        if (value != null) {
            return !value
        } else {
            throw RuntimeException("Value $name not found!")
        }
    }

    override fun children(): List<ExpressionNode> = listOf()

    override fun buildLogicString(): String = "\u00AC $name"

    /**
     * Generates a negated value expression node based on a given [ValueExpressionNode].
     *
     * @param valueExpressionNode the node that should be negated
     * @since 1.0.0
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     */
    constructor(valueExpressionNode: ValueExpressionNode) : this(valueExpressionNode.name, valueExpressionNode.partIndex)
}