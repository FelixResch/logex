package org.web25.felix.logicexpreval.parser

import org.web25.felix.logicexpreval.LogicExpression
import org.web25.felix.logicexpreval.node.and
import org.web25.felix.logicexpreval.node.closure
import org.web25.felix.logicexpreval.node.or
import org.web25.felix.logicexpreval.node.value
import org.web25.felix.logicexpreval.parser.lex.ExpressionLexerFactory
import org.web25.felix.logicexpreval.parser.lex.symbols.OpeningBracketLexicalSymbol
import org.web25.felix.logicexpreval.parser.ref.*

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
        val root = ImplicitClosureReference(context.closureCounter++, link(references))
        context.closures.add(root)
        while (context.closures.isNotEmpty()) {
            val closure = context.closures.first()
            context.closures.removeAt(0)
            val closures = replaceClosures(closure, context)
            replaceOperators(closure)
            context.closures.addAll(closures)
        }
        logicExpression.rootExpressionNode = root.resolve()
        return logicExpression
    }

    private fun replaceOperators(closure: ClosureReference) {
        val operators = listOf("not", "and", "or")
        operators.forEach { operator ->
            var node : Reference? = closure.entryPoint
            while (node != null) {
                if (node is OperatorReference && node.operatorType.name == operator) {
                    node = node.operatorType.build(node, closure)
                }
                node = node.next
            }

        }
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

    private fun replaceClosures(closureReference: ClosureReference, context: ParserContext): List<ClosureReference> {
        var node : Reference = closureReference.entryPoint
        val closures = mutableListOf<ClosureReference>()
        while (node.next != null) {
            if(node is BracketReference) {
                if (node.lexicalSymbol is OpeningBracketLexicalSymbol) {
                    val matching = node.matching
                    val next = node.next ?: TODO("Implement proper exception here!")
                    val closure = ClosureReference(context.closureCounter++, next)
                    next.before = null
                    node.next = null
                    val before = node.before
                    if(before != null) {
                        before.next = closure
                    }
                    node.before = null
                    val mBefore = matching.before ?: TODO("Implement proper exception here!")
                    mBefore.next = null
                    val mNext = matching.next
                    if(mNext != null) {
                        mNext.before = closure
                    }
                    closures.add(closure)
                }
            }
            node = node.next?: break
        }
        return closures
    }

}

