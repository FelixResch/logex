package org.web25.felix.logicexpreval.parser

import org.web25.felix.logicexpreval.LogicExpression
import org.web25.felix.logicexpreval.node.and
import org.web25.felix.logicexpreval.node.closure
import org.web25.felix.logicexpreval.node.or
import org.web25.felix.logicexpreval.node.value
import org.web25.felix.logicexpreval.parser.lex.ExpressionLexerFactory
import org.web25.felix.logicexpreval.parser.ref.ParserContext
import org.web25.felix.logicexpreval.parser.ref.Reference
import org.web25.felix.logicexpreval.parser.ref.reference

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
        val context = ParserContext()
        val references = symbols.map { reference(it, context) }
        var root = link(references)

        logicExpression.rootExpressionNode = root.resolve()
        return logicExpression
    }

    private fun link(references: List<Reference>): Reference {
        (0..references.lastIndex).forEach { i ->
            if(i != 0) {
                references[i].before = references[i - 1]
            }
            if(i != references.lastIndex) {
                references[i].next = references[i + 1]
            }
        }
        return references[0]
    }

}

