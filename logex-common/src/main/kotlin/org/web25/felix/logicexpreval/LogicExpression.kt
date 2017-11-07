package org.web25.felix.logicexpreval

import org.web25.felix.logicexpreval.node.ExpressionNode
import org.web25.felix.logicexpreval.parser.ExpressionParserFactory

/**
 * An expression that can be evaluated logically
 *
 * @constructor simple constructor
 * @property parts the string parts of the expression
 * @since 1.0.0
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 */
class LogicExpression private constructor(val parts: List<String>) {

    /**
     * The root expression node of the parsed expression
     *
     * @since 1.0.0
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     */
    lateinit var rootExpressionNode: ExpressionNode

    /**
     * The lazy initialized evaluation context of the expression.
     *
     * @since 1.0.0
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     */
    val evaluationContext by lazy { EvaluationContext() }

    /**
     * Evaluates the expression and creates an evaluation result.
     *
     * @return an EvaluationResult with the evaluated values and their results
     * @since 1.0.0
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     */
    fun execute(): EvaluationResult {
        val node = rootExpressionNode
        evaluationContext.reset()
        node.initialize(evaluationContext)
        val variations = evaluationContext.variableVariations()
        val evaluationResult = EvaluationResult(evaluationContext)
        variations.forEach { variation : BooleanArray ->
            evaluationContext.loadState(variation)
            val result = node.evaluate(evaluationContext)
            evaluationResult.addResult(variation, result)
        }
        return evaluationResult
    }

    companion object {

        /**
         * Parses and creates a logical expression from the given strings.
         *
         * @param parts the parts of the expression
         * @return a parsed logical expression
         * @since 1.0.0
         * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
         */
        fun parse(parts: Iterable<String>): LogicExpression {
            val list = parts.toList()
            val parser = ExpressionParserFactory.singletonParser()
            return parser.parse(LogicExpression(parts = list))
        }
    }

    /**
     * Prints the expression using unicode characters
     *
     * @since 1.0.0
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     */
    fun printExpression() {
        println(rootExpressionNode.buildLogicString())
    }
}

