package org.web25.felix.logex.display

import org.web25.felix.logex.EvaluationResult

object AsciiPrintDisplay : ResultDisplay {

    override fun display(result: EvaluationResult) {
        val valuesNames = result.valuesNames


        val headerLength = valuesNames.map { it.length }

        //TOP line
        print("┌")
        headerLength.forEachIndexed { index, length ->
            if(index == 0) {
                print("─")
            } else {
                print("┬─")
            }
            (1..length).forEach { print("─") }
            print("─")
        }
        println("┬───┐")

        valuesNames.forEach { print("│ $it ") }
        println("║ Q │")

        //Separator line

        print("├")
        headerLength.forEachIndexed { index, length ->
            if(index == 0) {
                print("─")
            } else {
                print("┼─")
            }
            (1..length).forEach { print("─") }
            print("─")
        }
        println("┼───┤")


        result.forEach { evaluationLineResult ->
            evaluationLineResult.variation.forEachIndexed { index, it ->
                print("│ ")
                (2..headerLength[index]).forEach { print(" ") }
                print(if(it) "1" else "0")
                print(" ")
            }
            print("║ ")
            print(if(evaluationLineResult.result) "1" else "0")
            println(" │")
        }

        //BOTTOM line

        print("└")
        headerLength.forEachIndexed { index, length ->
            if(index == 0) {
                print("─")
            } else {
                print("┴─")
            }
            (1..length).forEach { print("─") }
            print("─")
        }
        println("┴───┘")
    }
}