package org.web25.felix.logex.parser

import org.web25.felix.logex.LogicExpression
import org.web25.felix.logex.node.and
import org.web25.felix.logex.node.closure
import org.web25.felix.logex.node.or
import org.web25.felix.logex.node.value
import org.web25.felix.logex.parser.lex.ExpressionLexerFactory
import org.web25.felix.logex.parser.lex.symbols.OpeningBracketLexicalSymbol
import org.web25.felix.logex.parser.ref.*
import org.web25.felix.system.SystemHelper

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
     *
     * @since 1.0.0
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     */
    private val lexer by lazy {
        ExpressionLexerFactory.build()
    }


    override fun parse(logicExpression: LogicExpression): LogicExpression {
        val symbols = lexer.lex(logicExpression.parts)
        SystemHelper.logger.debug(symbols)
        val context = ParserContext()
        val references = symbols.map { reference(it, context) }
        val root = ImplicitClosureReference(context.closureCounter++, link(references))
        context.closures.add(root)
        while (context.closures.isNotEmpty()) {
            val closure = context.closures.first()
            context.closures.removeAt(0)
            val closures = replaceClosures(closure, context)
            SystemHelper.logger.debug(closure)
            replaceOperators(closure)
            SystemHelper.logger.debug(closure)
            context.closures.addAll(closures)
        }
        logicExpression.rootExpressionNode = root.resolve()
        return logicExpression
    }

    /**
     * Looks for operators in the closure and replaces them with a reference to the specified operator.
     *
     * @param closure The closure the operators should be looked in
     * @since 1.0.0
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     */
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

    /**
     * Links the references generated.
     *
     * @param references a list of references to be linked
     * @return the first reference in the linked list
     * @since 1.0.0
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     */
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

    /**
     * Looks for closures in a closure and returns them.
     *
     * @param closureReference the [ClosureReference] that the closures should be looked in
     * @param context the [ParserContext] for this parsing action
     * @return the closures found in the passed closure
     * @since 1.0.0
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     */
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
                        closure.before = before
                    } else {
                        closureReference.entryPoint = closure
                    }
                    node.before = null
                    val mBefore = matching.before ?: TODO("Implement proper exception here!")
                    mBefore.next = null
                    val mNext = matching.next
                    if(mNext != null) {
                        mNext.before = closure
                        closure.next = mNext
                    }
                    closures.add(closure)
                    node = closure
                }
            }
            node = node.next?: break
        }
        return closures
    }

}

