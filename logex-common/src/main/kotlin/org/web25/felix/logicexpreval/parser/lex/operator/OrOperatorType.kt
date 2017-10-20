package org.web25.felix.logicexpreval.parser.lex.operator

import org.web25.felix.logicexpreval.parser.lex.OperatorType

class OrOperatorType : OperatorType {

    override val unicodeRepresentation: Char = '\u2228'

    override val name: String = "or"

    override val operatorMatchers: List<String> = listOf("\u2228", "|", "-or")

}