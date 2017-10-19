package org.web25.felix.logicexpreval.parser.lex.operator

import org.web25.felix.logicexpreval.parser.lex.OperatorType

class NotOperatorType : OperatorType {

    override val unicodeRepresentation: Char = '\u00AC'

    override val name: String = "not"

    override val operatorMatchers: List<String> = listOf("\u00AC", "-not", "!")
}