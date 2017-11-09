package org.web25.felix.logicexpreval.parser.ref

import org.web25.felix.logicexpreval.node.ExpressionNode
import org.web25.felix.logicexpreval.parser.lex.symbols.OperatorLexicalSymbol

class OperatorReference(lexicalSymbol: OperatorLexicalSymbol): Reference() {

    val operatorType = lexicalSymbol.operatorType

    override fun resolve(): ExpressionNode {
        TODO("Intermediary references should not be evaluated!")
    }

    override fun toString(): String = "op:${operatorType.name}${super.toString()}"
}