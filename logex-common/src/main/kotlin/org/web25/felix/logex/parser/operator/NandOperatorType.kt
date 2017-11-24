package org.web25.felix.logex.parser.operator

import org.web25.felix.logex.parser.ref.NandOperationReference
import org.web25.felix.logex.parser.ref.ClosureReference
import org.web25.felix.logex.parser.ref.OperationReference
import org.web25.felix.logex.parser.ref.OperatorReference

/**
 * Operator type for the **NAND** operator.
 *
 * This operator will match with the following glyphs/glyph groups: `∧`, `-nand`, `!&`.
 *
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 * @since 1.0.0
 */
object NandOperatorType : OperatorType {

    override val unicodeRepresentation: Char = '\u2193'

    override val name: String = "nand"

    override val operatorMatchers: List<String> = listOf("\u2193", "!&", "-nand")

    override fun build(reference: OperatorReference, enclosing: ClosureReference): OperationReference {
        val left = reference.before
        val right = reference.next
        if(left == null || right == null) {
            TODO("Implement proper exception type")
        }

        val result = NandOperationReference(left, right)

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

    override val priority: Int = 10
}