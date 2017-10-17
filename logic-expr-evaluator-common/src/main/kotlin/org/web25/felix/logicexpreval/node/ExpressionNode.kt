package org.web25.felix.logicexpreval.node

import org.web25.felix.logicexpreval.EvaluationContext

interface ExpressionNode {

    val name: String

    val partIndex: Int

    fun initialize(context: EvaluationContext)

    fun evaluate(context: EvaluationContext): Boolean

    fun children(): List<ExpressionNode>

    fun buildLogicString(): String
}

