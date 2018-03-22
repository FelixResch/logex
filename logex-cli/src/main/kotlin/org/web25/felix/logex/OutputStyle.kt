package org.web25.felix.logex

import org.web25.felix.logex.display.AsciiPrintDisplay
import org.web25.felix.logex.display.PrintDisplay
import org.web25.felix.logex.display.ResultDisplay

enum class OutputStyle(val resultDisplay: ResultDisplay) {
    UNICODE_SIMPLE(PrintDisplay),
    ASCII_SIMPLE(AsciiPrintDisplay),
}
