package org.web25.felix.logicexpreval.node

fun and(aNode: ExpressionNode, bNode: ExpressionNode): AndExpressionNode {
    return AndExpressionNode(0, aNode, bNode)
}

fun or(aNode: ExpressionNode, bNode: ExpressionNode): OrExpressionNode {
    return OrExpressionNode(0, aNode, bNode)
}

fun closure(content: ExpressionNode): ClosureExpressionNode {
    return ClosureExpressionNode(0, content)
}

fun value(name: String): ValueExpressionNode {
    return ValueExpressionNode(name, 0)
}