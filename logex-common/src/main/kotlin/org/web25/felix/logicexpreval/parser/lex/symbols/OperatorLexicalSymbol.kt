package org.web25.felix.logicexpreval.parser.lex.symbols

import org.web25.felix.logicexpreval.parser.operator.OperatorType

/**
 * Represents a lexical symbol that can be interpreted as operator.
 *
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 * @since 1.0.0
 * @property operatorType The type of operator this symbol represents. (see [OperatorType])
 */
class OperatorLexicalSymbol(glyphs: List<Char>, startIndex: Int, endIndex: Int, val operatorType: OperatorType) : LexicalSymbol(glyphs, startIndex, endIndex) {

    override val typeName: String = "operator"

    override fun toString(): String = "op:${operatorType.name}"
}

