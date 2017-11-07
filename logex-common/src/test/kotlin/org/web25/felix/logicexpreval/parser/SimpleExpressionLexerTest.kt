package org.web25.felix.logicexpreval.parser

import org.web25.felix.logicexpreval.parser.lex.*
import org.web25.felix.logicexpreval.parser.lex.operator.AndOperatorType
import org.web25.felix.logicexpreval.parser.lex.operator.OrOperatorType
import org.web25.felix.logicexpreval.parser.lex.symbols.ClosingBracketLexicalSymbol
import org.web25.felix.logicexpreval.parser.lex.symbols.OpeningBracketLexicalSymbol
import org.web25.felix.logicexpreval.parser.lex.symbols.OperatorLexicalSymbol
import org.web25.felix.logicexpreval.parser.lex.symbols.ValueLexicalSymbol
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals


class SimpleExpressionLexerTest {

    @Test
    fun testLexingWithWhitespace() {
        val lexer = SimpleExpressionLexer()
        val lexicalSymbols = lexer.lex(listOf("A -and (B -or C)"))
        println(lexicalSymbols)
        assertEquals(listOf(
                ValueLexicalSymbol(listOf('A'), 0, 0),
                OperatorLexicalSymbol(listOf('-', 'a', 'n', 'd'), 2, 5, AndOperatorType()),
                OpeningBracketLexicalSymbol(listOf('('), 7, 7),
                ValueLexicalSymbol(listOf('B'), 8, 8),
                OperatorLexicalSymbol(listOf('-', 'o', 'r'), 10, 12, OrOperatorType()),
                ValueLexicalSymbol(listOf('B'), 14, 14),
                ClosingBracketLexicalSymbol(listOf(')'), 15, 15)
        ), lexicalSymbols)
    }
}

