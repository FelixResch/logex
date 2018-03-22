package org.web25.felix.logex

import kotlin.test.assertEquals
object ExpressionTestHelper {

    fun test(expression: String, result: BooleanArray) {
        val parsedExpression = LogicExpression.parse(expression)
        test(parsedExpression, result)
    }

    fun test(expression: LogicExpression, result: BooleanArray) {
        val evaluationResult = expression.execute()
        assertEquals(result.toList(), evaluationResult.toBooleanArray().toList())
    }

    fun contradiction(i: Int): BooleanArray = BooleanArray(i, {false})
    fun tautology(i: Int): BooleanArray = BooleanArray(i, {true})

}