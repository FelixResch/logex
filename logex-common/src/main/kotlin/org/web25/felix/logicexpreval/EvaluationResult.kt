package org.web25.felix.logicexpreval

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
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     */
    fun print() {
        val headerLength = valuesNames.map { it.length }

        //TOP line
        print("\u250c")
        headerLength.forEachIndexed { index, length ->
            if(index == 0) {
                print("\u2500")
            } else {
                print("\u252c\u2500")
            }
            (1..length).forEach { print("\u2500") }
            print("\u2500")
        }
        println("\u2565\u2500\u2500\u2500\u2510")

        valuesNames.forEach { print("\u2502 $it ") }
        println("\u2551 Q \u2502")

        //Separator line

        print("\u251c")
        headerLength.forEachIndexed { index, length ->
            if(index == 0) {
                print("\u2500")
            } else {
                print("\u253c\u2500")
            }
            (1..length).forEach { print("\u2500") }
            print("\u2500")
        }
        println("\u256B\u2500\u2500\u2500\u2524")


        results.forEach { result ->
            result.variation.forEachIndexed { index, it ->
                print("\u2502 ")
                (2..headerLength[index]).forEach { print(" ") }
                print(if(it) "T" else "F")
                print(" ")
            }
            print("\u2551 ")
            print(if(result.result) "T" else "F")
            println(" \u2502")
        }

        //BOTTOM line

        print("\u2514")
        headerLength.forEachIndexed { index, length ->
            if(index == 0) {
                print("\u2500")
            } else {
                print("\u2534\u2500")
            }
            (1..length).forEach { print("\u2500") }
            print("\u2500")
        }
        println("\u2568\u2500\u2500\u2500\u2518")
    }

}
