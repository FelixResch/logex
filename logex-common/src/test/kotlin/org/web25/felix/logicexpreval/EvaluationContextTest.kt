package org.web25.felix.logicexpreval

import org.web25.felix.logicexpreval.node.AndExpressionNode
import org.web25.felix.logicexpreval.node.ValueExpressionNode
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class EvaluationContextTest {

    @Test
    fun testVariationPossibilites() {
        val context = EvaluationContext()
        assertEquals(2, context.size(1))
        assertEquals(4, context.size(2))
        assertEquals(8, context.size(3))
    }

    @Test
    fun testCorrectVariations() {
        val context = EvaluationContext()
        val rootNode = AndExpressionNode(1, ValueExpressionNode("A", 0), ValueExpressionNode("B", 2))
        rootNode.initialize(context)
        val variations = context.variableVariations()
        assertEquals(4, variations.size)
        variations.forEach {
            assertEquals(it.size, 2)
        }
        assertFalse(variations[0][0])
        assertFalse(variations[0][1])
        assertTrue(variations[1][0])
        assertFalse(variations[1][1])
        assertFalse(variations[2][0])
        assertTrue(variations[2][1])
        assertTrue(variations[3][0])
        assertTrue(variations[3][1])
    }
}