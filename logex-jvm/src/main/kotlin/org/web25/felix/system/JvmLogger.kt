package org.web25.felix.system

/**
 * Simple implementation of [Logger] for the JVM
 *
 * @since 1.0.0
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 */
class JvmLogger(val debug: Boolean) : Logger {

    override fun debug(message: Any) {
        if(debug) {
            println(message)
        }
    }

}