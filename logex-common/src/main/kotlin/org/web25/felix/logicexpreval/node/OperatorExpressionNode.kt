package org.web25.felix.logicexpreval.node

/**
 * Base node for operators.
 *
 * Operators should implement this node.
 *
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 * @since 1.0.0
 */
abstract class OperatorExpressionNode(override val name: String, override val partIndex: Int): ExpressionNode