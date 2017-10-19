package org.web25.felix.logicexpreval

import org.web25.felix.logicexpreval.node.ClosureExpressionNode
import org.web25.felix.logicexpreval.node.ExpressionNode
import org.web25.felix.logicexpreval.node.OperatorExpressionNode
import org.web25.felix.logicexpreval.node.ValueExpressionNode

object ASTPrinter {

    fun printAST(root: ExpressionNode, level: Int = 0) {
        (1..level).forEach {
            print("  ")
        }
        print("- ")
        if(root is OperatorExpressionNode) {
            print("op:")
        } else if (root is ValueExpressionNode) {
            print("val:")
        } else if (root is ClosureExpressionNode) {
        } else {
            print("other:")
        }
        println(root.name)
        root.children().forEach { node ->
            printAST(root = node, level = level + 1)
        }
    }
}