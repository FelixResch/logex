package org.web25.felix.logex.parser.lex

/**
 * Exception that is used by an expression parser when an error comes up.
 *
 * @property parserError the error that was detected during parsing
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 * @since 1.0.0
 */
class ParserValidationException(val parserError: ParserError) : RuntimeException("error: ${parserError.code}: $parserError")