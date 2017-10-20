package org.web25.felix.logicexpreval

/**
 * The context used during evaluation.
 *
 * This class stores the values of the current evaluation and performs some utility tasks for the execution.
 *
 * As the class implements MutableMap values could be set but should only be read from the context.
 *
 * > This class is part of the common module, all functions use only kotlin specific functions and data types for
 * > compatibility with other platforms.
 *
 * @constructor Simple no-args constructor for the context.
 *
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 * @since 1.0.0
 */
class EvaluationContext: MutableMap<String, Boolean> by mutableMapOf() {

    /**
     * Stores all known variables.
     */
    private val variables = mutableListOf<String>()

    /**
     * Adds the name of a variable to the list of known variables.
     *
     * @param name The name of the variable
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     * @since 1.0.0
     */
    fun allocateVariable(name: String) {
        this.variables.add(name)
    }

    /**
     * Returns a readonly list of all allocated variables
     *
     * @return a readonly copy of the internal list of known variables
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     * @since 1.0.0
     */
    fun variables(): List<String> = this.variables.toList()

    /**
     * Resets the context for the execution of a new logical expression
     *
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     * @since 1.0.0
     */
    fun reset() {
        variables.clear()
    }

    /**
     * Generates a two dimensional BooleanArray containing all permutations for the known variables
     *
     * @return An array of all permutations starting with (00...00) going through all binary number variations to (11..11)
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     * @since 1.0.0
     */
    fun variableVariations(): Array<BooleanArray> {
        val result = Array(size(variables.size), {BooleanArray(variables.size, {false})})
        for (i in 0..result.lastIndex) {
            for (j in 0..variables.lastIndex) {
                val pow = size(j)
                if(!(i and pow == pow)) {
                    result[i][j] = true
                }
            }
        }
        return result
    }

    /**
     * Calculates the number of permutations necessary for the evaluation of a logical expression
     *
     * @param variables The number of allocated variables
     * @return the number of possible permutations
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     * @since 1.0.0
     */
    fun size(variables: Int): Int {
        if(variables == 0) return 1
        var value = 2
        (2..variables).forEach { value *= 2 }
        return value
    }

    /**
     * Initializes the state of the evaluation context with a given permutation.
     *
     * @param variation the variation that should be loaded
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     * @since 1.0.0
     */
    fun loadState(variation: BooleanArray) {
        this.variables.forEachIndexed { index, name ->
            this@EvaluationContext[name] = variation[index]
        }
    }

}