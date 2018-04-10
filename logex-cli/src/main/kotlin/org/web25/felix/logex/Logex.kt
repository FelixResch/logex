package org.web25.felix.logex

import org.web25.felix.system.SystemHelper
import picocli.CommandLine

fun main(args: Array<String>) {
    val app = CommandLine.populateCommand(Logex(), *args)
    if (app.helpRequested) {
        CommandLine.usage(app, System.out)
    } else {
        app.run()
    }

}

class Logex : Runnable {

    @CommandLine.Option(names = ["-z", "--zeros-first"], description = ["If the 0s should start at the bottom"])
    val zerosFirst: Boolean = false

    @CommandLine.Parameters(description = ["The parts of the logical expression"])
    lateinit var expression: List<String>

    @CommandLine.Option(names = ["-h", "--help"], description = ["Prints this help message and exits"])
    val helpRequested: Boolean = false

    @CommandLine.Option(names = ["-d", "--debug"], description = ["Prints debug information"])
    val printDebug: Boolean = false

    @CommandLine.Option(names = ["-v", "--version"], description = ["Prints the version of the logex library and the client implementation"])
    val versionRequested: Boolean = false

    @CommandLine.Option(names = ["--suppress-ast"], description = ["Don't print the AST"])
    val suppressAst: Boolean = false

    @CommandLine.Option(names = ["-s", "--silent"], description = ["Only print the table"])
    val silent: Boolean = false

    @CommandLine.Option(names = ["-f", "--output-format", "--output-style"], description = ["Select the format, in which the table should be printed"])
    val outputStyle: OutputStyle = OutputStyle.UNICODE_SIMPLE;

    override fun run() {
        if (versionRequested) {
            println("logex common core version: ${LogexCommonInfo.version}")
            SystemHelper.printPlatformInfo()
            return
        }
        SystemHelper.enableUnicode()
        if (printDebug)
            SystemHelper.enableDebug()
        val logicExpression = LogicExpression.parse(expression)
        if (!silent)
            logicExpression.printExpression()
        if (!silent && !suppressAst)
            ASTPrinter.printAST(logicExpression.rootExpressionNode)
        val result = logicExpression.execute()
        result.print(outputStyle.resultDisplay)
    }


}