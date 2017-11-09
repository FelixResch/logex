package org.web25.felix.logicexpreval.parser.ref

import org.web25.felix.logicexpreval.node.ExpressionNode
import org.web25.felix.logicexpreval.node.ValueExpressionNode
import org.web25.felix.logicexpreval.parser.lex.symbols.LexicalSymbol

class ValueReference(lexicalSymbol: LexicalSymbol): Reference() {

    private val name: String = lexicalSymbol.glyphs.joinToString()

    override fun resolve(): ExpressionNode = ValueExpressionNode(name, 0)

    override fun toString(): String = "val:$name${super.toString()}"
}