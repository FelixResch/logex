package org.web25.felix.logicexpreval

import org.web25.felix.logicexpreval.LogicExpression
import kotlin.test.assertEquals

class LogicExpressionTest {

    @Test
    fun test() {
        val logicExpression = LogicExpression.parse(listOf("a", "-and", "b"))
        assertEquals(listOf("a", "-and", "b"), logicExpression.parts)

    }
}