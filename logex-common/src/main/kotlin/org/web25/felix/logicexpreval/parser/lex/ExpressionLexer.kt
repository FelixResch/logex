package org.web25.felix.logicexpreval.parser.lex

import org.web25.felix.logicexpreval.parser.lex.symbols.LexicalSymbol

interface ExpressionLexer {

    fun lex(parts: List<String>): List<LexicalSymbol>
}

