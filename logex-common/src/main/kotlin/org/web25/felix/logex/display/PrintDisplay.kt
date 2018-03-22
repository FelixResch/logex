package org.web25.felix.logex.display

import org.web25.felix.logex.EvaluationResult

object PrintDisplay : ResultDisplay {

    override fun display(result: EvaluationResult) {
        val valuesNames = result.valuesNames


        val headerLength = valuesNames.map { it.length }

        //TOP line
        print("\u250c")
        headerLength.forEachIndexed { index, length ->
            if(index == 0) {
                print("\u2500")
            } else {
                print("\u252c\u2500")
            }
            (1..length).forEach { print("\u2500") }
            print("\u2500")
        }
        println("\u2565\u2500\u2500\u2500\u2510")

        valuesNames.forEach { print("\u2502 $it ") }
        println("\u2551 Q \u2502")

        //Separator line

        print("\u251c")
        headerLength.forEachIndexed { index, length ->
            if(index == 0) {
                print("\u2500")
            } else {
                print("\u253c\u2500")
            }
            (1..length).forEach { print("\u2500") }
            print("\u2500")
        }
        println("\u256B\u2500\u2500\u2500\u2524")


        result.forEach { evaluationLineResult ->
            evaluationLineResult.variation.forEachIndexed { index, it ->
                print("\u2502 ")
                (2..headerLength[index]).forEach { print(" ") }
                print(if(it) "\u2713" else "\u2717")
                print(" ")
            }
            print("\u2551 ")
            print(if(evaluationLineResult.result) "\u2713" else "\u2717")
            println(" \u2502")
        }

        //BOTTOM line

        print("\u2514")
        headerLength.forEachIndexed { index, length ->
            if(index == 0) {
                print("\u2500")
            } else {
                print("\u2534\u2500")
            }
            (1..length).forEach { print("\u2500") }
            print("\u2500")
        }
        println("\u2568\u2500\u2500\u2500\u2518")
    }
}