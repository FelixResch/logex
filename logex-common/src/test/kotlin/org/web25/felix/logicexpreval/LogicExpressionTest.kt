package org.web25.felix.logicexpreval

import kotlin.test.Test
import kotlin.test.assertEquals

class LogicExpressionTest {

    @Test
    fun test() {
        val logicExpression = LogicExpression.parse(listOf("a", "-and", "b"))
        assertEquals(listOf("a", "-and", "b"), logicExpression.parts)

    }
}