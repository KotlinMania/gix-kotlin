package io.github.kotlinmania.gix

import kotlin.test.Test
import kotlin.test.assertEquals

class KmPathTest {
    @Test
    fun testKmPathIntegration() {
        val path = Path.of("repo", "objects", "pack")
        assertEquals("pack", path.name)
        val parent = path.parent
        assertEquals("objects", parent?.name)
    }
}
