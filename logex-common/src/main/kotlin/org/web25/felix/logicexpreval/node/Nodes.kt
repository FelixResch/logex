package org.web25.felix.logicexpreval.node

/**
 * Creates a **AND** node.
 *
 * @param leftNode The left node of the **AND** expression
 * @param rightNode The right node of the **AND** expression
 * @return an [AndExpressionNode] that will **AND** the left and the right expression
 */
fun and(leftNode: ExpressionNode, rightNode: ExpressionNode): AndExpressionNode = AndExpressionNode(0, leftNode, rightNode)

/**
 * Creates a **OR** node.
 *
 * @param leftNode The left node of the **OR** expression
 * @param rightNode The right node of the **OR** expression
 * @return an [OrExpressionNode] that will **OR** the left and the right expression
 */
fun or(leftNode: ExpressionNode, rightNode: ExpressionNode): OrExpressionNode = OrExpressionNode(0, leftNode, rightNode)

/**
 * Creates a closure around a node.
 *
 * This is only necessary if the printed version of the expression will be used. If no closure is used, the expression
 * must no be ubiquitous.
 *
 * @param content The top-most node of the inner tree.
 * @return a [ClosureExpressionNode] that creates a closure around the inner tree
 */
fun closure(content: ExpressionNode): ClosureExpressionNode = ClosureExpressionNode(0, content)

/**
 * Creates a value node.
 *
 * This node will use the value stored in the current evaluation context.
 *
 * @param name The name of the variable
 * @return a [ValueExpressionNode] that will read the value from the evaluation context
 */
fun value(name: String): ValueExpressionNode = ValueExpressionNode(name, 0)

/**
 * Creates an optimized **NOT** node.
 *
 * @param content The content that should be negated.
 * @return either a [NotExpressionNode] if the content is complex expression or a [NotValueExpressionNode] [content] if a [ValueExpressionNode].
 */
fun not(content: ExpressionNode) = if (content is ValueExpressionNode) NotValueExpressionNode(content) else NotExpressionNode(content, 0)