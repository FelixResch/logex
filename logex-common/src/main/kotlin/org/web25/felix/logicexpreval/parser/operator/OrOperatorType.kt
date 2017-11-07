package org.web25.felix.logicexpreval.parser.operator

/**
 * Operator type for the **OR** operator.
 *
 * This operator will match with the following glyphs/glyph groups: `∨`, `-or`, `|`.
 *
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 * @since 1.0.0
 */
class OrOperatorType : OperatorType {

    override val unicodeRepresentation: Char = '\u2228'

    override val name: String = "or"

    override val operatorMatchers: List<String> = listOf("\u2228", "|", "-or")

}