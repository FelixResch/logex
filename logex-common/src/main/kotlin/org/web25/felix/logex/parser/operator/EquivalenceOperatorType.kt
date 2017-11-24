package org.web25.felix.logex.parser.operator

import org.web25.felix.logex.parser.ref.ClosureReference
import org.web25.felix.logex.parser.ref.EquivalenceOperationReference
import org.web25.felix.logex.parser.ref.OperationReference
import org.web25.felix.logex.parser.ref.OperatorReference

object EquivalenceOperatorType : OperatorType {

    override val unicodeRepresentation: Char = '\u21D4'

    override val name: String = "eq"

    override val operatorMatchers: List<String> = listOf("-eq", "=", "-equal", "-equals", "\u21D4")

    override fun build(reference: OperatorReference, enclosing: ClosureReference): OperationReference {
        val left = reference.before
        val right = reference.next
        if(left == null || right == null) {
            TODO("Implement proper exception type")
        }

        val result = EquivalenceOperationReference(left, right)

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

    override val priority: Int = 50
}