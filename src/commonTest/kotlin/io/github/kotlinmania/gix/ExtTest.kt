package io.github.kotlinmania.gix

import io.github.kotlinmania.gix.ext.attach
import io.github.kotlinmania.gix.hash.ObjectId
import io.github.kotlinmania.gix.objs.Entry
import io.github.kotlinmania.gix.objs.EntryMode
import io.github.kotlinmania.gix.objs.Tree
import kotlin.test.Test
import kotlin.test.assertEquals

class ExtTest {
    @Test
    fun testAttachments() {
        val repo = Gix.open("/tmp/repo")
        val oid = ObjectId.fromHex("e69de29bb2d1d6434b8b29ae775ad8c2e48c5391")

        val attachedId = oid.attach(repo)
        assertEquals(oid, attachedId.inner)

        val entry = Entry(EntryMode.Blob, "test.txt", oid)
        val attachedEntry = entry.attach(repo)
        assertEquals(entry, attachedEntry.entry)

        val tree = Tree(listOf(entry))
        val attachedTree = tree.attach(repo)
        assertEquals(tree, attachedTree.tree)

        val ref = Reference("refs/heads/main", oid.toHex(), repo)
        val attachedRef = ref.attach(repo)
        assertEquals(ref.name, attachedRef.name)

        val revSpec = "HEAD~1".attach(repo)
        assertEquals("HEAD~1", revSpec.spec)
    }
}
