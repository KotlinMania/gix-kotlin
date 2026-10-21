// port-lint: tests id.rs
package io.github.kotlinmania.gix

import io.github.kotlinmania.gix.hash.ObjectId
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class IdTest {
    // sizeOfOid: unported because memory layout sizing is a Rust semantic without Kotlin equivalent

    @Test
    fun testIdShorten() {
        val repo = Gix.open("/tmp/repo")
        val oid = ObjectId.fromHex("e69de29bb2d1d6434b8b29ae775ad8c2e48c5391")
        val id = Id(oid, repo)

        assertEquals("e69de29", id.shorten(7))
        assertEquals("e69de29bb2", id.shorten(10))
        assertEquals("e69de29", id.shortenOrId(7))
        assertEquals(oid, id.detach())
        assertEquals(oid.toHex(), id.toString())

        val id2 = Id(ObjectId.fromHex("0000000000000000000000000000000000000000"), repo)
        assertTrue(id > id2)
    }

    @Test
    fun testIdOperations() {
        val repo = Gix.open("/tmp/repo")
        val oid = ObjectId.fromHex("e69de29bb2d1d6434b8b29ae775ad8c2e48c5391")
        val id = Id(oid, repo)

        assertEquals(oid, id.deref())
        assertEquals(oid, id.asRef())
        assertEquals(oid, Id.from(id))
        assertEquals(listOf(oid), id.ancestors())
        assertEquals(null, id.`object`())
        assertEquals(null, id.tryObject())
        assertEquals(null, id.header())
        assertEquals(null, id.tryHeader())

        val hexLen = Id.calculateAutoHexLen(100uL)
        assertTrue(hexLen >= 7)
    }
}
