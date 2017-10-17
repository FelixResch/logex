package org.web25.felix.logicexpreval.parser.lex

interface OperatorType {

    val unicodeRepresentation: Char

    val name: String

    val operatorMatchers: List<String>
}