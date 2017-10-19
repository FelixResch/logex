package org.web25.felix.logicexpreval.parser.lex.symbols

import org.web25.felix.logicexpreval.parser.lex.OperatorType

class OperatorLexicalSymbol(glyphs: List<Char>, startIndex: Int, endIndex: Int, val operatorType: OperatorType) : LexicalSymbol(glyphs, startIndex, endIndex) {

    override val typeName: String = "operator"

    override fun toString(): String = "op:${operatorType.name}"
}

