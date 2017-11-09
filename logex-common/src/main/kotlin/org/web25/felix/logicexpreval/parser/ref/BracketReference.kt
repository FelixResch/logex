package org.web25.felix.logicexpreval.parser.ref

import org.web25.felix.logicexpreval.node.ExpressionNode
import org.web25.felix.logicexpreval.parser.lex.symbols.BracketLexicalSymbol

class BracketReference(val lexicalSymbol: BracketLexicalSymbol) : Reference() {

    lateinit var matching: BracketReference

    override fun resolve(): ExpressionNode {
        TODO("Intermediary references should not be evaluated!")
    }

    override fun toString(): String = "br:${lexicalSymbol.bracketType}${super.toString()}"
}