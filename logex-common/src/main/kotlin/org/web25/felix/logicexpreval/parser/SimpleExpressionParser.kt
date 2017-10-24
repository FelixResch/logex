package org.web25.felix.logicexpreval.parser

import org.web25.felix.logicexpreval.LogicExpression
import org.web25.felix.logicexpreval.node.and
import org.web25.felix.logicexpreval.node.closure
import org.web25.felix.logicexpreval.node.or
import org.web25.felix.logicexpreval.node.value
import org.web25.felix.logicexpreval.parser.lex.ExpressionLexerFactory

/**
 * A simple, not optimized parser for logical expressions.
 *
 * This parser has a lot of potential for improvements.
 *
 * @since 1.0.0
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 */
class SimpleExpressionParser : ExpressionParser {

    /**
     * A simple lexer that creates a list of symbols.
     */
    private val lexer by lazy {
        ExpressionLexerFactory.build()
    }


    override fun parse(logicExpression: LogicExpression): LogicExpression {
        logicExpression.rootExpressionNode = and(value("A"), closure(or(value("B"), value("C"))))
        val symbols = lexer.lex(logicExpression.parts)


        return logicExpression
    }

}

