// port-lint: source gix/src/interrupt.rs
package io.github.kotlinmania.gix

/**
 * Process-global interrupt handling facilities.
 */
object Interrupt {
    private var isInterrupted: Boolean = false

    /**
     * Returns true if an interrupt has been requested.
     */
    fun isTriggered(): Boolean = isInterrupted

    /**
     * Trigger an interrupt signal.
     */
    fun trigger() {
        isInterrupted = true
    }

    /**
     * Resets the interrupt request to false.
     */
    fun reset() {
        isInterrupted = false
    }
}
