package org.web25.felix.logicexpreval.parser

import org.web25.felix.logicexpreval.LogicExpression

interface ExpressionParser {

    fun parse(logicExpression: LogicExpression) : LogicExpression

}