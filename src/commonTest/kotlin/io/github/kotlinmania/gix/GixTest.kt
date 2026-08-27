// port-lint: tests lib.rs
package io.github.kotlinmania.gix

import io.github.kotlinmania.gix.hash.ObjectId
import io.github.kotlinmania.gix.objs.Entry
import io.github.kotlinmania.gix.objs.EntryKind
import io.github.kotlinmania.gix.objs.EntryMode
import io.github.kotlinmania.gix.objs.Tree
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class GixTest {
    @Test
    fun testObjectIdSha1() {
        val hex = "e69de29bb2d1d6434b8b29ae775ad8c2e48c5391"
        val oid = ObjectId.fromHex(hex)
        assertEquals(hex, oid.toHex())
        assertEquals(ObjectId.Kind.Sha1, oid.kind)
        assertEquals(20, oid.bytes.size)
        assertFalse(oid.isNull())

        val nullOid = ObjectId.nullSha1()
        assertTrue(nullOid.isNull())
        assertEquals(ObjectId.Kind.Sha1, nullOid.kind)
        assertEquals("0000000000000000000000000000000000000000", nullOid.toHex())
    }

    @Test
    fun testObjectIdSha256() {
        val hex = "ba7816bf8f01cfea414140de5dae2223b00361a396177a9cb410ff61f20015ad"
        val oid = ObjectId.fromHex(hex)
        assertEquals(hex, oid.toHex())
        assertEquals(ObjectId.Kind.Sha256, oid.kind)
        assertEquals(32, oid.bytes.size)
        assertFalse(oid.isNull())

        val nullOid = ObjectId.nullSha256()
        assertTrue(nullOid.isNull())
        assertEquals(ObjectId.Kind.Sha256, nullOid.kind)
        assertEquals("0000000000000000000000000000000000000000000000000000000000000000", nullOid.toHex())
    }

    @Test
    fun testEntryMode() {
        assertEquals(EntryKind.Blob, EntryMode.Blob.kind)
        assertEquals(EntryKind.BlobExecutable, EntryMode.BlobExecutable.kind)
        assertEquals(EntryKind.Tree, EntryMode.Tree.kind)
        assertEquals(EntryKind.Link, EntryMode.Link.kind)
        assertEquals(EntryKind.Commit, EntryMode.Commit.kind)

        assertTrue(EntryMode.Blob.isBlob)
        assertTrue(EntryMode.BlobExecutable.isBlob)
        assertTrue(EntryMode.BlobExecutable.isBlobExecutable)
        assertFalse(EntryMode.Blob.isBlobExecutable)
        assertTrue(EntryMode.Tree.isTree)
        assertTrue(EntryMode.Link.isLink)
        assertTrue(EntryMode.Commit.isCommit)

        assertEquals(EntryMode.Blob, EntryMode.fromOctal(33188))
        assertEquals(EntryMode.BlobExecutable, EntryMode.fromOctal(33261))
        assertEquals(EntryMode.Tree, EntryMode.fromOctal(16384))
        assertEquals(EntryMode.Link, EntryMode.fromOctal(40960))
        assertEquals(EntryMode.Commit, EntryMode.fromOctal(57344))
        assertNull(EntryMode.fromOctal(12345))
    }

    @Test
    fun testTree() {
        val oid1 = ObjectId.fromHex("e69de29bb2d1d6434b8b29ae775ad8c2e48c5391")
        val oid2 = ObjectId.fromHex("ba7816bf8f01cfea414140de5dae2223b00361a3")
        val entry1 = Entry(EntryMode.Blob, "README.md", oid1)
        val entry2 = Entry(EntryMode.Tree, "src", oid2)

        val tree = Tree(listOf(entry1, entry2))
        assertEquals(2, tree.size)
        assertFalse(tree.isEmpty)

        val found = tree.findEntry("README.md")
        assertNotNull(found)
        assertEquals(oid1, found.oid)
        assertEquals(EntryMode.Blob, found.mode)

        assertNull(tree.findEntry("nonexistent"))
    }
}
