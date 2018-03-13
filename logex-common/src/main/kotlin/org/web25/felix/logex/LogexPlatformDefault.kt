package org.web25.felix.logex

import org.web25.felix.logex.display.ResultDisplay

expect object LogexPlatformDefault {

    fun defaultResultDisplay(): ResultDisplay
}