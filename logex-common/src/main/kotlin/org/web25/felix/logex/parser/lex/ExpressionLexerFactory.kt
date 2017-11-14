package org.web25.felix.logex.parser.lex

/**
 * Factory for [ExpressionLexer] instances.
 *
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 * @since 1.0.0
 */
object ExpressionLexerFactory {

    /**
     * Builds an [ExpressionLexer] instance.
     *
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     * @since 1.0.0
     * @return a fresh [ExpressionLexer] instance.
     */
    fun build(): ExpressionLexer {
        return SimpleExpressionLexer()
    }
}