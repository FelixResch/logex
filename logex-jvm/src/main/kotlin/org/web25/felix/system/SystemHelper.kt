package org.web25.felix.system

import org.web25.felix.logex.LogexJvmInfo

actual object SystemHelper {
    actual fun enableUnicode() {
        System.setProperty("file.encoding", "UTF-8")
    }

    actual fun printPlatformInfo() {
        println("Platform implementation version: ${LogexJvmInfo.version}")
    }

    actual val logger: Logger by lazy {
        JvmLogger(debug = false)
    }

    actual fun objectId(any: Any): String {
        return System.identityHashCode(any).toString(16)
    }
}