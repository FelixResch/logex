package org.web25.felix.logex

import org.web25.felix.logicexpreval.ASTPrinter
import org.web25.felix.logicexpreval.LogexCommonInfo
import org.web25.felix.logicexpreval.LogicExpression
import org.web25.felix.system.SystemHelper

fun main(args: Array<String>) {
    println("Starting logex ${LogexCommonInfo.version}")
    SystemHelper.printPlatformInfo()
    SystemHelper.enableUnicode()
    val logicExpression = LogicExpression.parse(listOf("A -and -not (B -or C) -and (C -or B)"))
    logicExpression.printExpression()
    ASTPrinter.printAST(logicExpression.rootExpressionNode)
    val result = logicExpression.execute()
    result.print()
}