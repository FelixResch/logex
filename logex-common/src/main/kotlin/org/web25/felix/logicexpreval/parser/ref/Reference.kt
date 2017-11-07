package org.web25.felix.logicexpreval.parser.ref

import org.web25.felix.logicexpreval.node.ExpressionNode

/**
 * Represents a reference that can be resolved.
 *
 * @since 1.0.0
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 */
abstract class Reference {

    abstract fun resolve(): ExpressionNode

    var next: Reference? = null
    var before: Reference? = null
}