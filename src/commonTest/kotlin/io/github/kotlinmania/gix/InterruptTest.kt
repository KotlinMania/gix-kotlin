// port-lint: tests interrupt.rs
package io.github.kotlinmania.gix

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class InterruptTest {
    @Test
    fun testInterruptLifecycle() {
        Interrupt.reset()
        assertFalse(Interrupt.isTriggered())

        Interrupt.trigger()
        assertTrue(Interrupt.isTriggered())

        Interrupt.reset()
        assertFalse(Interrupt.isTriggered())
    }
}
