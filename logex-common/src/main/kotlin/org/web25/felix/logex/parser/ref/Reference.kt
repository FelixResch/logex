package org.web25.felix.logex.parser.ref

import org.web25.felix.logex.node.ExpressionNode

/**
 * Represents a reference and an element in a linked list.
 *
 * @since 1.0.0
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 */
abstract class Reference {

    /**
     * Resolves the Reference to an [ExpressionNode]
     *
     * @throws RuntimeException if the reference can't be resolve
     * @return a matching node for the reference
     * @since 1.0.0
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     */
    abstract fun resolve(): ExpressionNode

    /**
     * The next reference, if a next reference exists
     *
     * @since 1.0.0
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     */
    var next: Reference? = null

    /**
     * The reference before this reference, if it exists
     *
     * @since 1.0.0
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     */
    var before: Reference? = null

    override fun toString(): String {
        val next = this.next
        if(next != null) {
            return " $next"
        } else {
            return ""
        }
    }
}