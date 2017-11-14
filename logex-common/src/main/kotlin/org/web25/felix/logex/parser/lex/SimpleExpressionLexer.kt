package org.web25.felix.logex.parser.lex

import org.web25.felix.logex.parser.lex.symbols.*
import org.web25.felix.logex.parser.operator.*

class SimpleExpressionLexer : ExpressionLexer {

    val operators = OperatorFinder {
        this load NotOperatorType()
        this load AndOperatorType()
        this load OrOperatorType()
    }

    override fun lex(parts: List<String>): List<LexicalSymbol> {
        var symbols = buildSymbols(parts)
        symbols = findBrackets(symbols)
        validateBrackets(symbols)
        symbols = findOperators(symbols)
        symbols = findValues(symbols)
        return symbols.filterNot { it is WhitespaceLexicalSymbol }
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
        val indices = symbols.mapIndexed { i, symbol -> Pair(i, symbol)}
                .filter { it.second is OpeningBracketLexicalSymbol }
                .map { it.first }
        for (i in indices.reversed()) {
            val openingBracket = symbols[i] as OpeningBracketLexicalSymbol
            var found = false
            val sublist = symbols.subList(i + 1, symbols.size)
            sublist
                    .find {
                        it is ClosingBracketLexicalSymbol && openingBracket.bracketType == it.bracketType && !it.used
                    }
                    ?.let {
                        val closingBracket = it as ClosingBracketLexicalSymbol
                        openingBracket.closingBracket = closingBracket
                        closingBracket.openingBracket = openingBracket
                        closingBracket.used = true
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
        val simplifiedSymbols = simplify(symbols)
        return simplifiedSymbols.flatMap { symbol ->
            if(symbol is CharacterLexicalSymbol) {
                operators.findAndSplit(symbol)
            } else {
                listOf(symbol)
            }
        }
    }

    private fun findValues(symbols: List<LexicalSymbol>): List<LexicalSymbol> {
        return symbols.map { symbol ->
            if (symbol is CharacterLexicalSymbol) {
                ValueLexicalSymbol(symbol.glyphs, symbol.startIndex, symbol.endIndex)
            } else {
                symbol
            }
        }
    }

    private fun simplify(symbols: List<LexicalSymbol>): List<LexicalSymbol> {
        val simplifiedSymbols = mutableListOf<LexicalSymbol>()
        val glyphs = mutableListOf<CharacterLexicalSymbol>()
        symbols.forEach { symbol ->
            if (symbol is CharacterLexicalSymbol) {
                glyphs.add(symbol)
            } else {
                if(glyphs.isNotEmpty()) {
                    simplifiedSymbols.add(glyphs.simplify())
                    glyphs.clear()
                }
                simplifiedSymbols.add(symbol)
            }
        }
        if (glyphs.isNotEmpty()) {
            simplifiedSymbols.add(glyphs.simplify())
        }
        return simplifiedSymbols
    }
}

