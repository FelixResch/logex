package org.web25.felix.logicexpreval.parser

/**
 * Factory for expression parsers.
 *
 * For now it will only create [SimpleExpressionParser] instances, either as singleton or as new instance.
 *
 * > This class is part of the common module, all functions use only kotlin specific functions and data types for
 * > compatibility with other platforms.
 *
 * @since 1.0.0
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 */
object ExpressionParserFactory {

    /**
     * Lazily creates a singleton parser. Please note that this instance might not be thread-safe!
     */
    private val singleton by lazy { newParser() }

    /**
     * Creates a new instance of an expression parser.
     *
     * In the future, this parser will create a suiting parser for the length and complexity of the given expression.
     *
     * @since 1.0.0
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     */
    fun newParser(): ExpressionParser = SimpleExpressionParser()

    /**
     * Returns an instance to an expression parser.
     *
     * If no instance hasn't been created yet a new object will be initialized.
     *
     * @since 1.0.0
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     */
    fun singletonParser(): ExpressionParser = singleton

}