package org.web25.felix.logicexpreval.node

import org.web25.felix.logicexpreval.EvaluationContext

/**
 * Creates a closure around an expression node.
 *
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 * @since 1.0.0
 * @property content the content that is encapsulated in the closure
 */
class ClosureExpressionNode(override val partIndex: Int, val content: ExpressionNode) : ExpressionNode {

    override val name: String = "closure"

    override fun initialize(context: EvaluationContext) {
        content.initialize(context)
    }

    override fun evaluate(context: EvaluationContext): Boolean = content.evaluate(context)

    override fun children(): List<ExpressionNode> = listOf(content)

    override fun buildLogicString(): String = "(${content.buildLogicString()})"
}