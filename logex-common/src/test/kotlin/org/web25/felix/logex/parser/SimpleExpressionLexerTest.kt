package org.web25.felix.logex.parser

import org.web25.felix.logex.parser.lex.*
import org.web25.felix.logex.parser.operator.AndOperatorType
import org.web25.felix.logex.parser.operator.OrOperatorType
import org.web25.felix.logex.parser.lex.symbols.ClosingBracketLexicalSymbol
import org.web25.felix.logex.parser.lex.symbols.OpeningBracketLexicalSymbol
import org.web25.felix.logex.parser.lex.symbols.OperatorLexicalSymbol
import org.web25.felix.logex.parser.lex.symbols.ValueLexicalSymbol
import kotlin.test.Test
import kotlin.test.assertEquals


class SimpleExpressionLexerTest {

    @Test
    fun testLexingWithWhitespace() {
        val lexer = SimpleExpressionLexer()
        val lexicalSymbols = lexer.lex(listOf("A -and (B -or C)"))
        assertEquals(listOf(
                ValueLexicalSymbol(listOf('A'), 0, 0),
                OperatorLexicalSymbol(listOf('-', 'a', 'n', 'd'), 2, 5, AndOperatorType),
                OpeningBracketLexicalSymbol(listOf('('), 7, 7),
                ValueLexicalSymbol(listOf('B'), 8, 8),
                OperatorLexicalSymbol(listOf('-', 'o', 'r'), 10, 12, OrOperatorType),
                ValueLexicalSymbol(listOf('C'), 14, 14),
                ClosingBracketLexicalSymbol(listOf(')'), 15, 15)
        ), lexicalSymbols)
    }

    @Test
    fun testLexingWithAllPartsSeparated() {
        val lexer = SimpleExpressionLexer()
        val lexicalSymbols = lexer.lex(listOf("A", "-and", "(", "B", "-or", "C", ")"))
        assertEquals(listOf(
                ValueLexicalSymbol(listOf('A'), 0, 0),
                OperatorLexicalSymbol(listOf('-', 'a', 'n', 'd'), 2, 5, AndOperatorType),
                OpeningBracketLexicalSymbol(listOf('('), 7, 7),
                ValueLexicalSymbol(listOf('B'), 8, 8),
                OperatorLexicalSymbol(listOf('-', 'o', 'r'), 10, 12, OrOperatorType),
                ValueLexicalSymbol(listOf('C'), 14, 14),
                ClosingBracketLexicalSymbol(listOf(')'), 15, 15)
        ), lexicalSymbols)
    }

    @Test
    fun testLexingWithSomePartsSeparated() {
        val lexer = SimpleExpressionLexer()
        val lexicalSymbols = lexer.lex(listOf("A", "-and", "(B", "-or", "C)"))
        assertEquals(listOf(
                ValueLexicalSymbol(listOf('A'), 0, 0),
                OperatorLexicalSymbol(listOf('-', 'a', 'n', 'd'), 2, 5, AndOperatorType),
                OpeningBracketLexicalSymbol(listOf('('), 7, 7),
                ValueLexicalSymbol(listOf('B'), 8, 8),
                OperatorLexicalSymbol(listOf('-', 'o', 'r'), 10, 12, OrOperatorType),
                ValueLexicalSymbol(listOf('C'), 14, 14),
                ClosingBracketLexicalSymbol(listOf(')'), 15, 15)
        ), lexicalSymbols)
    }

    @Test
    fun testLexingWithNoPartsSeparated() {
        val lexer = SimpleExpressionLexer()
        val lexicalSymbols = lexer.lex(listOf("A-and(B-orC)"))
        assertEquals(listOf(
                ValueLexicalSymbol(listOf('A'), 0, 0),
                OperatorLexicalSymbol(listOf('-', 'a', 'n', 'd'), 2, 5, AndOperatorType),
                OpeningBracketLexicalSymbol(listOf('('), 7, 7),
                ValueLexicalSymbol(listOf('B'), 8, 8),
                OperatorLexicalSymbol(listOf('-', 'o', 'r'), 10, 12, OrOperatorType),
                ValueLexicalSymbol(listOf('C'), 14, 14),
                ClosingBracketLexicalSymbol(listOf(')'), 15, 15)
        ), lexicalSymbols)
    }

    @Test
    fun testLexingWithComplexExpression() {
        val lexer = SimpleExpressionLexer()
        val lexicalSymbols = lexer.lex(listOf("A -or B -and C -and ( F -or (E -and D ))"))
        assertEquals(listOf(
                ValueLexicalSymbol(listOf('A'), 0, 0),
                OperatorLexicalSymbol(listOf('-', 'o', 'r'), 0, 0, OrOperatorType),
                ValueLexicalSymbol(listOf('B'), 0, 0),
                OperatorLexicalSymbol(listOf('-', 'a', 'n', 'd'), 0, 0, AndOperatorType),
                ValueLexicalSymbol(listOf('C'), 0, 0),
                OperatorLexicalSymbol(listOf('-', 'a', 'n', 'd'), 0, 0, AndOperatorType),
                OpeningBracketLexicalSymbol(listOf('('), 0, 0),
                ValueLexicalSymbol(listOf('F'), 0, 0),
                OperatorLexicalSymbol(listOf('-', 'o', 'r'), 0, 0, OrOperatorType),
                OpeningBracketLexicalSymbol(listOf('('), 0, 0),
                ValueLexicalSymbol(listOf('E'), 0, 0),
                OperatorLexicalSymbol(listOf('-', 'a', 'n', 'd'), 0, 0, AndOperatorType),
                ValueLexicalSymbol(listOf('D'), 0, 0),
                ClosingBracketLexicalSymbol(listOf(')'), 0, 0),
                ClosingBracketLexicalSymbol(listOf(')'), 0, 0)
        ), lexicalSymbols)
    }

    @Test
    fun testSimpleExpression() {
        val lexer = SimpleExpressionLexer()
        val lexicalSymbols = lexer.lex(listOf("A", "-and", "B"))
        assertEquals(listOf(
                ValueLexicalSymbol(listOf('A'), 0, 0),
                OperatorLexicalSymbol(listOf('-', 'a', 'n', 'd'), 0, 0, AndOperatorType),
                ValueLexicalSymbol(listOf('B'), 0, 0)
        ), lexicalSymbols)
    }
}

