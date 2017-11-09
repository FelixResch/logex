package org.web25.felix.system

/**
 * Simple interface for loggers.
 *
 * The details of the implementation are left to the implementer but should follow the basic logical
 * guidelines of any logging system.
 *
 * @since 1.0.0
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 */
interface Logger {

    /**
     * Logs a message of level debug
     *
     * @param message Anything that should be logged
     * @since 1.0.0
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     */
    fun debug(message: Any)

}