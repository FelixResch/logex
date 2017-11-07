package org.web25.felix.logicexpreval.parser.lex

import org.web25.felix.logicexpreval.parser.operator.OperatorType
import org.web25.felix.logicexpreval.parser.lex.symbols.CharacterLexicalSymbol
import org.web25.felix.logicexpreval.parser.lex.symbols.LexicalSymbol
import org.web25.felix.logicexpreval.parser.lex.symbols.OperatorLexicalSymbol

class OperatorFinder() {

    private val operatorTypes: MutableList<OperatorType> = mutableListOf()
    private val lengthIndex = mutableMapOf<Int, MutableList<Pair<String, OperatorType>>>()
    private var maxOperatorLength: Int = 0
    private val operatorCache = mutableMapOf<Int, MutableList<Pair<String, OperatorType>>>()

    infix fun load(operatorType: OperatorType) {
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
        val remainingCharacterSymbol = symbol
        val buffer = mutableListOf<Char>()
        val symbols = mutableListOf<LexicalSymbol>()
        var skip = 0
        for (i in 0..remainingCharacterSymbol.glyphs.lastIndex) {
            if (skip > 0) {
                skip--
            } else {
                val possibleMatchers = matchers.filter { it.first[0] == remainingCharacterSymbol.glyphs[i] }
                if (possibleMatchers.isNotEmpty()) {
                    for (j in i..remainingCharacterSymbol.glyphs.lastIndex) {
                        val m = matchers.filter { it.first.length >= j - i }.filter {
                            it.first.subSequence(0, j - i).forEachIndexed { index, char ->
                                if (char != remainingCharacterSymbol.glyphs[index + i]) {
                                    return@filter false
                                }
                            }
                            true
                        }
                        if (m.isEmpty()) {
                            buffer.add(remainingCharacterSymbol.glyphs[i])
                            break
                        } else if (m.size == 1) {
                            val pair = m.first()
                            skip = pair.first.length - 1
                            if (buffer.isNotEmpty()) {
                                symbols.add(CharacterLexicalSymbol(buffer.toList(), 0, 0))
                                buffer.clear()
                            }
                            symbols.add(OperatorLexicalSymbol(pair.first.toList(), 0, 0, pair.second))
                            break
                        }
                    }
                } else {
                    buffer.add(remainingCharacterSymbol.glyphs[i])
                }
            }
        }
        if(buffer.isNotEmpty()) {
            symbols.add(CharacterLexicalSymbol(buffer.toList(), 0, 0))
        }
        return symbols
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