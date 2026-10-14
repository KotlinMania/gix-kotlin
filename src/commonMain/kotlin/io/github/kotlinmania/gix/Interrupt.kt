// port-lint: source interrupt.rs
package io.github.kotlinmania.gix

import kotlin.concurrent.atomics.AtomicBoolean
import kotlin.concurrent.atomics.ExperimentalAtomicApi

/**
 * Process-global interrupt handling facilities.
 */
@OptIn(ExperimentalAtomicApi::class)
object Interrupt {
    private val isInterrupted = AtomicBoolean(false)

    /**
     * Returns true if an interrupt has been requested.
     */
    fun isTriggered(): Boolean = isInterrupted.load()

    /**
     * Trigger an interrupt signal.
     */
    fun trigger() {
        isInterrupted.store(true)
    }

    /**
     * Resets the interrupt request to false.
     */
    fun reset() {
        isInterrupted.store(false)
    }
}
