package org.web25.felix.logicexpreval.parser.ref

import org.web25.felix.logicexpreval.parser.lex.symbols.BracketLexicalSymbol
import org.web25.felix.logicexpreval.parser.lex.symbols.OpeningBracketLexicalSymbol

class ParserContext {

    val brackets = mutableMapOf<BracketLexicalSymbol, BracketReference>()
    val closures = mutableListOf<ClosureReference>()
    var closureCounter = 0
}

