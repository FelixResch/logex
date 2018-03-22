package org.web25.felix.logex

import org.web25.felix.logex.display.ResultDisplay

/**
 * Stores the result of an evaluation of a logical expression.
 *
 * @constructor Simple constructor
 * @param evaluationContext the context that was used to evaluate an expression
 * @since 1.0.0
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 */
class EvaluationResult(evaluationContext: EvaluationContext) {

    /**
     * The names of the variables used in the evaluation
     *
     * @since 1.0.0
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     */
    val valuesNames = evaluationContext.variables()

    /**
     * List of the calculated results results
     */
    private val results = mutableListOf<EvaluationLineResult>()

    /**
     * Add a calculated result to the evaluation result
     *
     * @param variation the values that have been used to evaluate the result
     * @param result the result of the logical expression using the given values
     * @since 1.0.0
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     */
    fun addResult(variation: BooleanArray, result: Boolean) {
        this.results.add(EvaluationLineResult(variation, result))
    }

    /**
     * Prints an Unicode table containing all result lines.
     *
     * Could be replaced by a more advanced tool that creates tables either in ASCII or in Unicode.
     *
     * @since 1.0.0
     * @param resultDisplay the [ResultDisplay] that should be used to print the result
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     */
    fun print(resultDisplay: ResultDisplay = LogexPlatformDefault.defaultResultDisplay()) {
        resultDisplay.display(this)
    }

    fun forEach(block: (EvaluationLineResult) -> Unit) {
        results.forEach(block)
    }

    fun forEachIndexed(block: (Int, EvaluationLineResult) -> Unit) {
        results.forEachIndexed(block)
    }

    fun toBooleanArray(): BooleanArray {
        return BooleanArray(results.size) {index ->
            results[index].result
        }
    }

}
