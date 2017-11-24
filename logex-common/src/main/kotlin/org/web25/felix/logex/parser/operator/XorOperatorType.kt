package org.web25.felix.logex.parser.operator

import org.web25.felix.logex.parser.ref.XorOperationReference
import org.web25.felix.logex.parser.ref.*

object XorOperatorType : OperatorType {

    override val unicodeRepresentation: Char = '\u2297'

    override val name: String = "xor"

    override val operatorMatchers: List<String> = listOf("-xor", "\u2297")

    override fun build(reference: OperatorReference, enclosing: ClosureReference): OperationReference {
        val left = reference.before
        val right = reference.next
        if(left == null || right == null) {
            TODO("Implement proper exception type")
        }

        val result = XorOperationReference(left, right)

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

    override val priority: Int = 30
}