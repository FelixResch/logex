package org.web25.felix.logicexpreval

actual object SystemHelper {
    actual fun enableUnicode() {
        System.setProperty("file.encoding", "UTF-8")
    }

    actual fun printPlatformInfo() {
        println("Platform implementation version: ${LogexJvmInfo.version}")
    }
}