package org.web25.felix.logicexpreval.parser.operator

import org.web25.felix.logicexpreval.parser.ref.ClosureReference
import org.web25.felix.logicexpreval.parser.ref.OperatorReference
import org.web25.felix.logicexpreval.parser.ref.OperationReference

/**
 * Represents one type of operator.
 *
 * Instances of this interface are used to detect operators in glyph groups.
 *
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 * @since 1.0.0
 */
interface OperatorType {

    /**
     * The unicode representation of the operator.
     *
     * If no glyph exists for a specific operator this property should throw.
     *
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     * @since 1.0.0
     */
    val unicodeRepresentation: Char

    /**
     * The representative name of the operator.
     *
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     * @since 1.0.0
     */
    val name: String

    /**
     * A list of matchers for the operator.
     *
     * These are used for finding operators in glyph groups.
     *
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     * @since 1.0.0
     */
    val operatorMatchers: List<String>

    fun build(reference: OperatorReference, enclosing: ClosureReference): OperationReference

}