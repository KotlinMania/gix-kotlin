// port-lint: tests gix/src/util.rs
package io.github.kotlinmania.gix

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class UtilTest {
    @Test
    fun testOwnedOrStaticAtomicBool() {
        val flag = OwnedOrStaticAtomicBool.default()
        assertFalse(flag.get())

        flag.set(true)
        assertTrue(flag.get())

        val prev = flag.swap(false)
        assertTrue(prev)
        assertFalse(flag.get())
    }
}
