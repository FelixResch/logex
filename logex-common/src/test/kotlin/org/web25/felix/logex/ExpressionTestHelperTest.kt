package org.web25.felix.logex

import kotlin.test.*

class ExpressionTestHelperTest {

    @Test
    fun testTautology() {
        val tautology4 = ExpressionTestHelper.tautology(4)
        assertEquals(4, tautology4.size)
        tautology4.forEach {
            assertTrue(it)
        }
        val tautology32 = ExpressionTestHelper.tautology(32)
        assertEquals(32, tautology32.size)
        tautology32.forEach {
            assertTrue(it)
        }
    }

    @Test
    fun testContradiction() {
        val contradiction4 = ExpressionTestHelper.contradiction(4)
        assertEquals(4, contradiction4.size)
        contradiction4.forEach {
            assertFalse(it)
        }
        val contradiction32 = ExpressionTestHelper.contradiction(32)
        assertEquals(32, contradiction32.size)
        contradiction32.forEach {
            assertFalse(it)
        }
    }

    @Test
    fun testError() {
        assertFails {
            ExpressionTestHelper.test("((a -and b)", booleanArrayOf(true, false, false, false))
        }
    }
}