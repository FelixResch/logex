package org.web25.felix.system

class JvmLogger(val debug: Boolean) : Logger {

    override fun debug(message: Any) {
        if(debug) {
            println(message)
        }
    }

}