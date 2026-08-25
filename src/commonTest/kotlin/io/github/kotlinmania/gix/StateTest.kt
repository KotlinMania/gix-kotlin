package io.github.kotlinmania.gix

import kotlin.test.Test
import kotlin.test.assertEquals

class StateTest {
    @Test
    fun testInProgressValues() {
        val values = InProgress.values()
        assertEquals(10, values.size)
        assertEquals(InProgress.ApplyMailbox, InProgress.valueOf("ApplyMailbox"))
        assertEquals(InProgress.RebaseInteractive, InProgress.valueOf("RebaseInteractive"))
    }
}
