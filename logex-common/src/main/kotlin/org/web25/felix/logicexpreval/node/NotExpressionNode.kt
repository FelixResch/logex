package org.web25.felix.logicexpreval.node

import org.web25.felix.logicexpreval.EvaluationContext

/**
 * A simple not expression.
 *
 * This node will negate the result of [content]`s [ExpressionNode.evaluate].
 *
 * @property content the subtree that should be negated
 * @since 1.0.0
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 */
class NotExpressionNode (val content: ExpressionNode, partIndex: Int): OperatorExpressionNode("not", partIndex) {

    override fun initialize(context: EvaluationContext) {
        content.initialize(context)
    }

    override fun evaluate(context: EvaluationContext): Boolean = content.evaluate(context)

    override fun children(): List<ExpressionNode> = listOf(content)

    override fun buildLogicString(): String = "\u00AC${content.buildLogicString()}"
}