package org.web25.felix.logicexpreval.parser.lex

import org.web25.felix.logicexpreval.parser.lex.symbols.*
import org.web25.felix.logicexpreval.parser.lex.operator.*

class SimpleExpressionLexer : ExpressionLexer {

    val operators = operatorFinder {
        this load AndOperatorType()
        this load OrOperatorType()
    }

    private fun operatorFinder(block: OperatorFinder.() -> Unit): OperatorFinder {
        val operatorFinder = OperatorFinder()
        operatorFinder.block()
        return operatorFinder
    }

    override fun lex(parts: List<String>): List<LexicalSymbol> {
        var symbols = buildSymbols(parts)
        symbols = findBrackets(symbols)
        validateBrackets(symbols)
        symbols = findOperators(symbols)
        symbols = findValues(symbols)
        return symbols
    }

    private fun buildSymbols(parts: List<String>): List<LexicalSymbol> {
        val symbols = mutableListOf<LexicalSymbol>()
        parts.forEachIndexed { i, part ->
            part.forEach { char ->
                val index = symbols.lastIndex + 1
                if (char == ' ') {
                    symbols.add(WhitespaceLexicalSymbol(listOf(char), index, index))
                } else {
                    symbols.add(CharacterLexicalSymbol(listOf(char), index, index))
                }
            }
            if(i != parts.lastIndex) {
                val index = symbols.lastIndex + 1
                symbols.add(WhitespaceLexicalSymbol(listOf(' '), index, index))
            }
        }
        return symbols
    }

    private fun findBrackets(symbols: List<LexicalSymbol>): List<LexicalSymbol> {
        return symbols.map { symbol ->
            if (symbol.glyphs.size == 1 && BracketLexicalSymbol.isBracket(symbol.glyphs[0])) {
                BracketLexicalSymbol.build(symbol)
            } else {
                symbol
            }
        }
    }


    private fun validateBrackets(symbols: List<LexicalSymbol>) {
        val index = symbols.mapIndexed { i, symbol -> Pair(i, symbol)}
                .filter { it.second is OpeningBracketLexicalSymbol }
                .map { it.first }
        for (i in index.reversed()) {
            val openingBracket = symbols[i] as OpeningBracketLexicalSymbol
            var found = false
            symbols.subList(i, symbols.lastIndex)
                    .find {it is ClosingBracketLexicalSymbol && openingBracket.bracketType == it.bracketType}
                    ?.let {
                        val closingBracket = it as ClosingBracketLexicalSymbol
                        openingBracket.closingBracket = closingBracket
                        closingBracket.openingBracket = openingBracket
                        found = true
                    }
            if(!found) {
                throw ParserValidationException(ParserError.UNMATCHED_OPENING_BRACKET)
            }
        }
        try {
            symbols.any { it is ClosingBracketLexicalSymbol && it.openingBracket.typeName == "" }
        } catch (_: Throwable) {
            throw ParserValidationException(ParserError.UNMATCHED_CLOSING_BRACKET)
        }
    }

    private fun findOperators(symbols: List<LexicalSymbol>): List<LexicalSymbol> {
        return symbols
    }

    private fun findValues(symbols: List<LexicalSymbol>): List<LexicalSymbol> {
        return symbols
    }
}

