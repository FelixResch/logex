package org.web25.felix.logex

import org.web25.felix.logex.node.and
import org.web25.felix.logex.node.not
import org.web25.felix.logex.node.value
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LogicExpressionTest {

    @Test
    fun test() {
        val logicExpression = LogicExpression.parse(listOf("a", "-and", "b"))
        assertEquals(listOf("a", "-and", "b"), logicExpression.parts)

    }

    @Test
    fun testMultipleBrackets() {
        val logicExpression = LogicExpression.parse("A -and -not (B -or C) -or (D -or E -and (A -or -not B))")
        val result = logicExpression.execute()
        //result.print()
    }

    @Test
    fun testTautology() {
        val logicExpression = LogicExpression.parse("A -or -not A")
        val result = logicExpression.execute()
        result.forEach {
            assertTrue(it.result)
        }
    }

    @Test
    fun testKontradiction() {
        val logicExpression = LogicExpression.parse("A -and -not A")
        val result = logicExpression.execute()
        result.forEach {
            assertFalse(it.result)
        }
    }

    @Test
    fun testNand() {
        val logicExpression = LogicExpression.create(not(and(value("A"), value("B"))))
        val result = logicExpression.execute()
        result.forEachIndexed { i, lineResult ->
            if (i == 3) {
                assertFalse(lineResult.result)
            } else {
                assertTrue(lineResult.result)
            }
        }
    }
}