package org.web25.felix.logex.parser.lex

/**
 * Class that maps the errors in [ParserValidationException] to an error code.
 *
 * @property code the error code defined for a certain error
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 * @since 1.0.0
 */
enum class ParserError(val code: Int) {

    /**
     * *0x01* No matching closing bracket could be found for the opening bracket.
     *
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     * @since 1.0.0
     */
    UNMATCHED_OPENING_BRACKET(1),

    /**
     * *0x02* No matching opening bracket could be found for the closing bracket.
     *
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     * @since 1.0.0
     */
    UNMATCHED_CLOSING_BRACKET(2)

}