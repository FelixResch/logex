package org.web25.felix.logicexpreval.parser.ref

import org.web25.felix.logicexpreval.parser.lex.symbols.*

fun reference(lexicalSymbol: LexicalSymbol, context: ParserContext) = when {
    lexicalSymbol is BracketLexicalSymbol -> {
        val matching = context.brackets[lexicalSymbol]

        val reference = BracketReference(lexicalSymbol)
        if (matching != null) {
            reference.matching = matching
            matching.matching = reference
        } else {
            if(lexicalSymbol is OpeningBracketLexicalSymbol) {
                context.brackets[lexicalSymbol.closingBracket] = reference
            } else {
                TODO("Implement proper exception here")
            }
        }
        reference
    }
    lexicalSymbol is ValueLexicalSymbol -> {
        ValueReference(lexicalSymbol)
    }
    lexicalSymbol is OperatorLexicalSymbol -> {
        OperatorReference(lexicalSymbol)
    }
    else -> SymbolReference(lexicalSymbol)
}

