package org.web25.felix.logicexpreval.parser.lex

enum class ParserError(val code: Int) {
    UNMATCHED_OPENING_BRACKET(1),

    UNMATCHED_CLOSING_BRACKET(2)

}