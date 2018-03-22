package org.web25.felix.logex

import org.web25.felix.logex.display.AsciiPrintDisplay
import org.web25.felix.logex.node.and
import org.web25.felix.logex.node.not
import org.web25.felix.logex.node.value
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LogicExpressionTest {


    @Test
    fun testMultipleBrackets() {
        val logicExpression = LogicExpression.parse("A -and -not (B -or C) -or (D -or E -and (A -or -not B))")
        val result = logicExpression.execute()
        //result.print(AsciiPrintDisplay)
    }

    @Test
    fun testTautology() {
        ExpressionTestHelper
                .test("A -or -not A",
                        ExpressionTestHelper.tautology(2))
    }

    @Test
    fun testKontradiction() {
        ExpressionTestHelper
                .test("A -and -not A",
                        ExpressionTestHelper.contradiction(2))
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

    @Test
    fun testComplexExpression() {
        ExpressionTestHelper
                .test("(-not A -and -not B) -or (A -and B)",
                        booleanArrayOf(
                                true,
                                false,
                                false,
                                true
                        )
                )
    }

    @Test
    fun testExpr01() {
        ExpressionTestHelper
                .test("((B -eq A) -and (-not A -impl B)) -eq (A -and B)",
                        ExpressionTestHelper.tautology(4))
    }

    @Test
    fun testExpr02() {
        ExpressionTestHelper
                .test("((R -or B) -and (R -impl (G -or -not B))) -and (-not B -impl -not R)",
                        booleanArrayOf(
                                false,
                                false,
                                true,
                                true,
                                false,
                                false,
                                false,
                                true
                        ))
    }
}