package org.web25.felix.logicexpreval

fun main(args: Array<String>) {
    SystemHelper.enableUnicode()
    val logicExpression = LogicExpression.parse(listOf("A", "-and", "B"))
    logicExpression.printExpression()
    ASTPrinter.printAST(logicExpression.rootExpressionNode)
    val result = logicExpression.execute()
    result.print()
}