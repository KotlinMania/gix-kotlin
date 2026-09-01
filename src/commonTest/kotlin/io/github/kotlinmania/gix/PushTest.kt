// port-lint: tests push.rs
package io.github.kotlinmania.gix

import kotlin.test.Test
import kotlin.test.assertEquals

class PushTest {
    @Test
    fun testPushDefaultValues() {
        val values = PushDefault.values()
        assertEquals(5, values.size)
        assertEquals(PushDefault.Simple, PushDefault.valueOf("Simple"))
        assertEquals(PushDefault.Matching, PushDefault.valueOf("Matching"))
    }
}
