// port-lint: tests gix/src/env.rs
package io.github.kotlinmania.gix

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class EnvTest {
    @Test
    fun testAgent() {
        assertTrue(Env.agent().startsWith("gix-kotlin-"))
    }

    @Test
    fun testCollateFetchError() {
        val openErr = Env.Collate.FetchError.Open("Failed to open")
        assertTrue(openErr.isCorrupted())
        assertFalse(openErr.isSpurious())

        val connectErr = Env.Collate.FetchError.Connect("Connection dropped")
        assertFalse(connectErr.isCorrupted())
        assertTrue(connectErr.isSpurious())
    }
}
