package org.web25.felix.logicexpreval.parser.operator

import org.web25.felix.logicexpreval.parser.ref.NotOperationReference
import org.web25.felix.logicexpreval.parser.ref.OperationReference
import org.web25.felix.logicexpreval.parser.ref.OperatorReference

/**
 * Operator type for the **NOT** operator.
 *
 * This operator will match with the following glyphs/glyph groups: `¬`, `-not`, `!`.
 *
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 * @since 1.0.0
 */
class NotOperatorType : OperatorType {

    override val unicodeRepresentation: Char = '\u00AC'

    override val name: String = "not"

    override val operatorMatchers: List<String> = listOf("\u00AC", "-not", "!")


    override fun build(reference: OperatorReference): OperationReference {
        val right = reference.next ?: TODO("Implement proper exception type")
        return NotOperationReference(right)
    }
}