package org.web25.felix.logex.parser.ref

import org.web25.felix.logex.node.ExpressionNode

/**
 * Implicit closure reference for the root closure.
 *
 * @param id the id of the closure
 * @param entryPoint the [Reference] this closure encloses
 * @since 1.0.0
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 */
class ImplicitClosureReference(id: Int, entryPoint: Reference) : ClosureReference(id, entryPoint) {

    override fun resolve(): ExpressionNode = entryPoint.resolve()

    override fun toString(): String = "root:$entryPoint"
}