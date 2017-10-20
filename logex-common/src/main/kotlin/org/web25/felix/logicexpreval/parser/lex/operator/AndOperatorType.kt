package org.web25.felix.logicexpreval.parser.lex.operator

import org.web25.felix.logicexpreval.parser.lex.OperatorType

class AndOperatorType : OperatorType {

    override val unicodeRepresentation: Char = '\u2227'

    override val name: String = "and"

    override val operatorMatchers: List<String> = listOf("\u2227", "&", "-and")
}