package io.github.kotlinmania.gix

import io.github.kotlinmania.gix.hash.ObjectId
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class IdTest {
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
}
