package org.web25.felix.logicexpreval.parser.ref

import org.web25.felix.logicexpreval.node.ExpressionNode
import org.web25.felix.logicexpreval.parser.lex.symbols.BracketLexicalSymbol

/**
 * References a bracket.
 *
 * @param lexicalSymbol the [BracketLexicalSymbol] this reference is created for
 * @since 1.0.0
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 */
class BracketReference(val lexicalSymbol: BracketLexicalSymbol) : Reference() {

    /**
     * The matching bracket reference for this bracket.
     *
     * @since 1.0.0
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     */
    lateinit var matching: BracketReference

    override fun resolve(): ExpressionNode {
        TODO("Intermediary references should not be evaluated!")
    }

    override fun toString(): String = "br:${lexicalSymbol.bracketType}${super.toString()}"
}