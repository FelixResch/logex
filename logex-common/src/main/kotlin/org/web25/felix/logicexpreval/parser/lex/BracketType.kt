package org.web25.felix.logicexpreval.parser.lex

/**
 * Defines the types of brackets that are known to the lexer.
 *
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 * @since 1.0.0
 */
enum class BracketType {

    /**
     * The brackets `(` and `)`.
     *
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     * @since 1.0.0
     */
    ROUND,

    /**
     * The brackets `{` and `}`.
     *
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     * @since 1.0.0
     */
    CURLY,

    /**
     * The brackets `[` and `]`.
     *
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     * @since 1.0.0
     */
    SQUARE

}