package org.web25.felix.logex.node

import org.web25.felix.logex.EvaluationContext

/**
 * Node for performing an **AND** operation for [leftNode] and [rightNode].
 *
 * @param partIndex the index the symbol was found in
 * @property leftNode the left node of the expression
 * @property rightNode the right node of the expression
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 * @since 1.0.0
 */
class AndExpressionNode(partIndex: Int, val leftNode: ExpressionNode, val rightNode: ExpressionNode) : OperatorExpressionNode("and", partIndex) {

    override fun initialize(context: EvaluationContext) {
        leftNode.initialize(context)
        rightNode.initialize(context)
    }

    override fun evaluate(context: EvaluationContext): Boolean = leftNode.evaluate(context) and rightNode.evaluate(context)

    override fun children(): List<ExpressionNode> = listOf(leftNode, rightNode)

    override fun buildLogicString(): String = "${leftNode.buildLogicString()} \u2227 ${rightNode.buildLogicString()}"
}