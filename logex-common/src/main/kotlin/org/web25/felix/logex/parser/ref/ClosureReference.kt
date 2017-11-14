package org.web25.felix.logex.parser.ref

import org.web25.felix.logex.node.ClosureExpressionNode
import org.web25.felix.logex.node.ExpressionNode

/**
 * Reference for a closure that would be enclosed in brackets.
 *
 * @param id the number of the Closure
 * @param entryPoint the reference this closure encloses
 * @since 1.0.0
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 */
open class ClosureReference(val id: Int, var entryPoint: Reference): Reference() {

    override fun resolve(): ExpressionNode = ClosureExpressionNode(0, entryPoint.resolve())

    override fun toString(): String = "closure#$id:($entryPoint)${super.toString()}"

}