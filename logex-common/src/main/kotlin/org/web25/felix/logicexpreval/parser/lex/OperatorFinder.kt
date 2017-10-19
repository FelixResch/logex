package org.web25.felix.logicexpreval.parser.lex

import org.web25.felix.logicexpreval.parser.lex.symbols.CharacterLexicalSymbol
import org.web25.felix.logicexpreval.parser.lex.symbols.LexicalSymbol

class OperatorFinder() {

    private val operatorTypes: MutableList<OperatorType> = mutableListOf()
    private val lengthIndex = mutableMapOf<Int, MutableList<Pair<String, OperatorType>>>()
    private var maxOperatorLength: Int = 0
    private val operatorCache = mutableMapOf<Int, MutableList<Pair<String, OperatorType>>>()

    infix fun load(operatorType: OperatorType) {
        println("Loading operator ${operatorType.name} (${operatorType.unicodeRepresentation}) [${operatorType.operatorMatchers}]")
        this.operatorTypes.add(operatorType)
    }

    constructor(block: OperatorFinder.() -> Unit): this() {
        this.block()
        this.buildOperatorIndex()
    }

    protected fun buildOperatorIndex() {
        lengthIndex.clear()
        operatorCache.clear()
        operatorTypes.forEach { operatorType ->
            operatorType.operatorMatchers.forEach { matcher ->
                val length = matcher.length
                if(maxOperatorLength < length) {
                    maxOperatorLength = length
                }
                val list = lengthIndex[length]?: mutableListOf()
                list.add(Pair(matcher, operatorType))
                if(!lengthIndex.containsKey(length)) {
                    lengthIndex[length] = list
                }
            }
        }
    }

    fun findAndSplit(symbol: CharacterLexicalSymbol): List<LexicalSymbol> {
        val length = symbol.length
        val matchers = findMatchers(length)
        return listOf(symbol)
    }

    private fun findMatchers(length: Int): List<Pair<String, OperatorType>> {
        val usedLength = if(length > maxOperatorLength) maxOperatorLength else length
        val cached = operatorCache[usedLength]
        if(cached != null) {
            return cached
        } else {
            val list = lengthIndex.filterKeys { key -> key <= usedLength }.flatMap { it.value }.toMutableList()
            operatorCache[usedLength] = list
            return list
        }
    }

}