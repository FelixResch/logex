package org.web25.felix.logicexpreval.parser

import org.web25.felix.logicexpreval.LogicExpression

/**
 * Interface that parses an expression and creates a reference to a new LogicalExpression
 *
 * > This class is part of the common module, all functions use only kotlin specific functions and data types for
 * > compatibility with other platforms.
 *
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 * @since 1.0.0
 */
interface ExpressionParser {

    /**
     * Parses an expression and returns an evaluateable logical expression.
     *
     * Please note that the signature of this operation might change in the future, to something more like this:
     *
     * ```
     * val expression = LogicalExpressionParserFactory.parse( 'expression' )
     * ```
     *
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     * @since 1.0.0
     */
    fun parse(logicExpression: LogicExpression) : LogicExpression

}