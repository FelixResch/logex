package org.web25.felix.logicexpreval.parser.lex

class OperatorFinder {

    private val operatorTypes: MutableList<OperatorType> = mutableListOf()

    infix fun load(operatorType: OperatorType) {
        this.operatorTypes.add(operatorType)
    }

}