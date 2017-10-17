package org.web25.felix.logicexpreval.parser.lex

object ExpressionLexerFactory {

    fun build(): ExpressionLexer {
        return SimpleExpressionLexer()
    }
}