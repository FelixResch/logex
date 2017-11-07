package org.web25.felix.logicexpreval

/**
 * Utility class that performs simple platform-dependent tasks.
 *
 * @since 1.0.0
 * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
 */
expect object SystemHelper {

    /**
     * Enables Unicode output if required.
     *
     * This is needed for at least the JVM platform.
     *
     * @since 1.0.0
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     */
    fun enableUnicode()

    /**
     * Prints information about the executing platform, like version, architecture, ... .
     *
     * @since 1.0.0
     * @author Felix Resch <[felix.resch@web25.org](mailto:felix.resch@web25.org)>
     */
    fun printPlatformInfo()
}