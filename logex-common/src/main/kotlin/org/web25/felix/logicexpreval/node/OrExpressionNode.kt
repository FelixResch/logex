package org.web25.felix.logicexpreval.node

import org.web25.felix.logicexpreval.EvaluationContext

/**
 * Node for performing an **OR** operation for [leftNode] and [rightNode]
 *
 * @param partIndex the index the symbol was found in
 * @property leftNode the left node of the expression
 * @property rightNode the right node of the expression
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 * @since 1.0.0
 */
class OrExpressionNode(partIndex: Int, val leftNode: ExpressionNode, val rightNode: ExpressionNode) : OperatorExpressionNode("or", partIndex) {

    override fun initialize(context: EvaluationContext) {
        leftNode.initialize(context)
        rightNode.initialize(context)
    }

    override fun evaluate(context: EvaluationContext): Boolean = leftNode.evaluate(context) or rightNode.evaluate(context)

    override fun children(): List<ExpressionNode> = listOf(leftNode, rightNode)

    override fun buildLogicString(): String = "${leftNode.buildLogicString()} \u2228 ${rightNode.buildLogicString()}"
}