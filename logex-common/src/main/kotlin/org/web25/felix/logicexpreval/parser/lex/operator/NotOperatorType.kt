package org.web25.felix.logicexpreval.parser.lex.operator

import org.web25.felix.logicexpreval.parser.lex.OperatorType

/**
 * Operator type for the **NOT** operator.
 *
 * This operator will match with the following glyphs/glyph groups: `¬`, `-not`, `!`.
 *
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 * @since 1.0.0
 */
class NotOperatorType : OperatorType {

    override val unicodeRepresentation: Char = '\u00AC'

    override val name: String = "not"

    override val operatorMatchers: List<String> = listOf("\u00AC", "-not", "!")
}