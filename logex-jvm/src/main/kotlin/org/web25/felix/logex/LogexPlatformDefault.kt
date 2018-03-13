package org.web25.felix.logex

import org.web25.felix.logex.display.PrintDisplay
import org.web25.felix.logex.display.ResultDisplay

actual object LogexPlatformDefault {

    actual fun defaultResultDisplay(): ResultDisplay = PrintDisplay

}