package org.web25.felix.logicexpreval.parser.ref

import org.web25.felix.logicexpreval.parser.lex.symbols.BracketLexicalSymbol
import org.web25.felix.logicexpreval.parser.lex.symbols.LexicalSymbol
import org.web25.felix.logicexpreval.parser.lex.symbols.OperatorLexicalSymbol
import org.web25.felix.logicexpreval.parser.lex.symbols.ValueLexicalSymbol

fun reference(lexicalSymbol: LexicalSymbol, context: ParserContext) = when {
    lexicalSymbol is BracketLexicalSymbol -> {
        val matching = context.brackets[lexicalSymbol]

        val reference = BracketReference(lexicalSymbol)
        if (matching != null) {
            reference.matching = matching
            matching.matching = reference
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

