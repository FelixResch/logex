package org.web25.felix.logex

import kotlin.test.Test
import kotlin.test.assertEquals

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
        result.print()
    }
}