package org.web25.felix.logicexpreval.node

import org.web25.felix.logicexpreval.EvaluationContext

/**
 * Represents a node in an expression.
 *
 * Every node needs a name and a method that generates a string representation of the operation.
 *
 * > This class is part of the common module, all functions use only kotlin specific functions and data types for
 * > compatibility with other platforms.
 *
 * @since 1.0.0
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 */
interface ExpressionNode {

    /**
     * A representative name of the operation that this expression node is used for.
     */
    val name: String

    /**
     * The index this expression is mapped to.
     *
     * *Could be replaced by beginning index and end index, for better mapping to the glyphs*
     */
    val partIndex: Int

    /**
     * Initializes the evaluation context given to the node.
     *
     * Every node should call all of it's children's [initialize] methods with the given [EvaluationContext].
     *
     * The node should initialize the context with required variables and other functions that might be added in the future.
     *
     * @param context the context of the evaluation
     */
    fun initialize(context: EvaluationContext)

    /**
     * Performs the evaluation defined in the node.
     *
     * @param context the context that is used by the evaluation
     * @return the logical operation`s result this node represents
     */
    fun evaluate(context: EvaluationContext): Boolean

    /**
     * A immutable list of nodes this node is parent of.
     *
     * @return an immutable list of this nodes child nodes
     */
    fun children(): List<ExpressionNode>

    /**
     * Builds a unicode representation of this logic expression.
     *
     * @return a unicode representation of this logic expression.
     */
    fun buildLogicString(): String
}

