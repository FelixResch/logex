package org.web25.felix.logicexpreval

fun main(args: Array<String>) {
    println("Starting logex ${LogexCommonInfo.version}")
    SystemHelper.printPlatformInfo()
    SystemHelper.enableUnicode()
    val logicExpression = LogicExpression.parse(listOf("A", "-and", "-not", "(", "B", "-or", "C", ")"))
    logicExpression.printExpression()
    ASTPrinter.printAST(logicExpression.rootExpressionNode)
    val result = logicExpression.execute()
    result.print()
}