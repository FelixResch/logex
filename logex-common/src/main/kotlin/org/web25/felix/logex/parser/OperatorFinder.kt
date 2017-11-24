package org.web25.felix.logex.parser

import org.web25.felix.logex.parser.lex.symbols.CharacterLexicalSymbol
import org.web25.felix.logex.parser.lex.symbols.LexicalSymbol
import org.web25.felix.logex.parser.lex.symbols.OperatorLexicalSymbol
import org.web25.felix.logex.parser.operator.*
import org.web25.felix.system.SystemHelper

object OperatorFinder {

    private val operatorTypes: MutableList<OperatorType> = mutableListOf()
    private val lengthIndex = mutableMapOf<Int, MutableList<Pair<String, OperatorType>>>()
    private var maxOperatorLength: Int = 0
    private val operatorCache = mutableMapOf<Int, MutableList<Pair<String, OperatorType>>>()
    private var operatorOrder: Map<Int, List<OperatorType>> = mutableMapOf()

    val operators: Map<Int, List<OperatorType>>
    get() {
        return operatorOrder
    }

    fun load(vararg operatorType: OperatorType) {
        operatorTypes.addAll(operatorType)
    }

    init {
        load(
                NotOperatorType,
                OrOperatorType,
                NorOperatorType,
                AndOperatorType,
                NandOperatorType,
                XorOperatorType,
                ImplicationOperatorType,
                EquivalenceOperatorType
        )
        buildOperatorIndex()
    }



    private fun buildOperatorIndex() {
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
        printIndex()
        operatorOrder = operatorTypes.groupBy { it.priority }
    }

    private fun printIndex() {
        lengthIndex.forEach { (key, value) ->
            SystemHelper.logger.debug("$key: ${value.map { it.first }}")
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
                    for (j in i..remainingCharacterSymbol.glyphs.lastIndex + 1) {
                        val m = possibleMatchers.filter { it.first.length >= j - i }.filter {
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