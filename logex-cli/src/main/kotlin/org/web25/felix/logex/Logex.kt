package org.web25.felix.logex

import org.web25.felix.logex.ASTPrinter
import org.web25.felix.logex.LogexCommonInfo
import org.web25.felix.logex.LogicExpression
import org.web25.felix.system.SystemHelper

fun main(args: Array<String>) {
    println("Starting logex ${LogexCommonInfo.version}")
    SystemHelper.printPlatformInfo()
    SystemHelper.enableUnicode()
    val logicExpression = LogicExpression.parse(args.toList())
    logicExpression.printExpression()
    ASTPrinter.printAST(logicExpression.rootExpressionNode)
    val result = logicExpression.execute()
    result.print()
}