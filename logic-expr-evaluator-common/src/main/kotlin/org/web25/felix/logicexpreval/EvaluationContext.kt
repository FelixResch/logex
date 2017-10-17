package org.web25.felix.logicexpreval

class EvaluationContext: MutableMap<String, Boolean> by mutableMapOf() {

    private val variables = mutableListOf<String>()

    fun allocateVariable(name: String) {
        this.variables.add(name)
    }

    fun variables(): List<String> = this.variables.toList()

    fun reset() {
        variables.clear()
    }

    fun variableVariations(): Array<Array<Boolean>> {
        val result = Array(size(variables.size), {Array(variables.size, {false})})
        for (i in 0..result.lastIndex) {
            for (j in 0..variables.lastIndex) {
                val pow = size(j)
                if(i and pow == pow) {
                    result[i][j] = true
                }
            }
        }
        return result
    }

    fun size(variables: Int): Int {
        if(variables == 0) return 1
        var value = 2
        (2..variables).forEach { value *= 2 }
        return value
    }

    fun loadState(variation: Array<Boolean>) {
        this.variables.forEachIndexed { index, name ->
            this@EvaluationContext[name] = variation[index]
        }
    }

}