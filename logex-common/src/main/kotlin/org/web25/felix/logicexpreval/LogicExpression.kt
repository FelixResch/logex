package org.web25.felix.logicexpreval

import org.web25.felix.logicexpreval.node.ExpressionNode
import org.web25.felix.logicexpreval.parser.ExpressionParserFactory

class LogicExpression private constructor(val parts: List<String>) {

    lateinit var rootExpressionNode: ExpressionNode

    val evaluationContext by lazy { EvaluationContext() }

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

        fun parse(parts: Iterable<String>): LogicExpression {
            val list = parts.toList()
            val parser = ExpressionParserFactory.singletonParser()
            return parser.parse(LogicExpression(parts = list))
        }
    }

    fun printExpression() {
        println(rootExpressionNode.buildLogicString())
    }
}

