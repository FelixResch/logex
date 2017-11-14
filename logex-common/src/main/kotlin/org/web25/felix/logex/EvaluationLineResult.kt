package org.web25.felix.logex

/**
 * Stores the result of one permutation.
 *
 * The result is stored with the values that are used to calculate this result.
 *
 * @since 1.0.0
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 *
 * @property variation the values used to calculate the result
 * @property result the result that was calculated using the values
 * @constructor a simple constructor to create the EvaluationResult
 */
data class EvaluationLineResult(val variation: BooleanArray, val result: Boolean)