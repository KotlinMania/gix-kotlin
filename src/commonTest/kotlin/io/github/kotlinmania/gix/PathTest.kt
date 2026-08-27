// port-lint: tests gix/src/path.rs
package io.github.kotlinmania.gix

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class PathTest {
    @Test
    fun testNormalize() {
        assertEquals("a/b/c", Path.normalize("a/./b/../b/c"))
        assertEquals("/a/b", Path.normalize("/a/b/c/.."))
        assertEquals("src/main", Path.normalize("src/./main"))
    }

    @Test
    fun testJoin() {
        assertEquals("a/b", Path.join("a", "b"))
        assertEquals("a/b", Path.join("a/", "/b"))
        assertEquals("a", Path.join("a", ""))
        assertEquals("b", Path.join("", "b"))
    }

    @Test
    fun testParent() {
        assertEquals("/a/b", Path.parent("/a/b/c"))
        assertEquals("src", Path.parent("src/main"))
        assertEquals("/", Path.parent("/a"))
        assertNull(Path.parent("a"))
    }
}
