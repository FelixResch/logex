package org.web25.felix.logicexpreval.parser

object ExpressionParserFactory {

    private val singleton by lazy { newParser() }

    fun newParser(): ExpressionParser = SimpleExpressionParser()

    fun singletonParser(): ExpressionParser = singleton

}