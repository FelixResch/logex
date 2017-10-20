package org.web25.felix.logicexpreval

import org.web25.felix.logicexpreval.node.ClosureExpressionNode
import org.web25.felix.logicexpreval.node.ExpressionNode
import org.web25.felix.logicexpreval.node.OperatorExpressionNode
import org.web25.felix.logicexpreval.node.ValueExpressionNode

/**
 * Object to print the AST of a logic expression.
 *
 * > This class is part of the common module, all functions use only kotlin specific functions and data types for
 * > compatibility with other platforms.
 *
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 * @since 1.0.0
 */
object ASTPrinter {

    /**
     * This methods prints the AST in a human readable form.
     *
     * The expression `A ∧ ( B ∨ C )` would look like this when printed.
     *
     * ```
     * - op:and
     *   - val:A
     *   - closure
     *     - op:or
     *       - val:B
     *       - val:C
     * ```
     *
     * @param root the root of the expression that should be printed
     * @param level the indentation level that should be used for the printed statements.
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     * @since 1.0.0
     */
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