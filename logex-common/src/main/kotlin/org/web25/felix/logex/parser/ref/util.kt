package org.web25.felix.logex.parser.ref

import org.web25.felix.logex.parser.lex.symbols.*
import org.web25.felix.system.SystemHelper

/**
 * Builds a [Reference] from a [LexicalSymbol].
 *
 * This method is used for mapping purposes during parsing.
 *
 * @param lexicalSymbol The symbol that should be converted to a [Reference]
 * @param context The [ParserContext] of the current parsing operation.
 * @since 1.0.0
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 */
fun reference(lexicalSymbol: LexicalSymbol, context: ParserContext) = when {
    lexicalSymbol is BracketLexicalSymbol -> {
        val matching = context.brackets[SystemHelper.objectId(lexicalSymbol)]

        val reference = BracketReference(lexicalSymbol)
        if (matching != null) {
            reference.matching = matching
            matching.matching = reference
        } else {
            if(lexicalSymbol is OpeningBracketLexicalSymbol) {
                context.brackets[SystemHelper.objectId(lexicalSymbol.closingBracket)] = reference
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

