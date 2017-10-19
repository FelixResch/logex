package org.web25.felix.logicexpreval.parser.lex

class ParserValidationException(parserError: ParserError) : RuntimeException("error: ${parserError.code}: $parserError") {

}