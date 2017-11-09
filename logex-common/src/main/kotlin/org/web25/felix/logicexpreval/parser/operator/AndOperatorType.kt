package org.web25.felix.logicexpreval.parser.operator

import org.web25.felix.logicexpreval.parser.ref.AndOperationReference
import org.web25.felix.logicexpreval.parser.ref.ClosureReference
import org.web25.felix.logicexpreval.parser.ref.OperationReference
import org.web25.felix.logicexpreval.parser.ref.OperatorReference

/**
 * Operator type for the **AND** operator.
 *
 * This operator will match with the following glyphs/glyph groups: `∧`, `-and`, `&`.
 *
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 * @since 1.0.0
 */
class AndOperatorType : OperatorType {

    override val unicodeRepresentation: Char = '\u2227'

    override val name: String = "and"

    override val operatorMatchers: List<String> = listOf("\u2227", "&", "-and")

    override fun build(reference: OperatorReference, enclosing: ClosureReference): OperationReference {
        val left = reference.before
        val right = reference.next
        if(left == null || right == null) {
            TODO("Implement proper exception type")
        }

        val result = AndOperationReference(left, right)

        val lBefore = left.before
        if(lBefore != null) {
            lBefore.next = result
        } else {
            enclosing.entryPoint = result
        }

        val rNext = right.next
        if(rNext != null) {
            rNext.before = result
        }

        result.before = left.before
        result.next = right.next
        left.before = null
        left.next = null
        right.before = null
        right.next = null

        return result
    }
}