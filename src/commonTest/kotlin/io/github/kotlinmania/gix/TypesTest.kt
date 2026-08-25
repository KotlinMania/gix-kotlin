package io.github.kotlinmania.gix

import io.github.kotlinmania.gix.hash.ObjectId
import io.github.kotlinmania.gix.objs.Kind
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TypesTest {
    @Test
    fun testRepositoryAndThreadSafe() {
        val repo = Gix.open("/tmp/test-repo")
        assertEquals("/tmp/test-repo", repo.workdir())
        assertEquals("/tmp/test-repo/.git", repo.gitDir)
        assertFalse(repo.isBare)

        val threadSafe = repo.toThreadSafe()
        assertEquals("/tmp/test-repo", threadSafe.workTree)
        assertEquals("/tmp/test-repo/.git", threadSafe.gitDir)

        val localAgain = threadSafe.toThreadLocal()
        assertEquals(repo.workTree, localAgain.workTree)

        val bareRepo = Gix.init("/tmp/bare-repo", isBare = true)
        assertTrue(bareRepo.isBare)
    }

    @Test
    fun testObjectAndDetached() {
        val repo = Gix.open("/tmp/repo")
        val oid = ObjectId.fromHex("e69de29bb2d1d6434b8b29ae775ad8c2e48c5391")
        val data = byteArrayOf(1, 2, 3, 4)
        val obj = Object(oid, Kind.Blob, data, repo)

        assertEquals(oid, obj.id)
        assertEquals(Kind.Blob, obj.kind)
        assertEquals(oid, obj.toId().detach())

        val detached = obj.detach()
        assertEquals(oid, detached.id)
        assertEquals(Kind.Blob, detached.kind)

        val reattached = detached.attach(repo)
        assertEquals(obj, reattached)
    }

    @Test
    fun testBlobCommitTag() {
        val repo = Gix.open("/tmp/repo")
        val oid = ObjectId.fromHex("e69de29bb2d1d6434b8b29ae775ad8c2e48c5391")
        val data = byteArrayOf(10, 20)

        val blob = Blob(oid, data, repo)
        assertEquals(oid, blob.id)

        val commit = Commit(oid, data, repo)
        assertEquals(oid, commit.id)

        val tag = Tag(oid, data, repo)
        assertEquals(oid, tag.id)
    }

    @Test
    fun testHeadAndReference() {
        val repo = Gix.open("/tmp/repo")
        val head = Head(HeadKind.Symbolic, repo)
        assertEquals(HeadKind.Symbolic, head.kind)

        val ref = Reference("refs/heads/main", "e69de29bb2d1d6434b8b29ae775ad8c2e48c5391", repo)
        assertEquals("refs/heads/main", ref.name)
        assertEquals("e69de29bb2d1d6434b8b29ae775ad8c2e48c5391", ref.detach())
    }

    @Test
    fun testWorktreeAndSubmodule() {
        val repo = Gix.open("/tmp/repo")
        val wt = Worktree(repo, "/tmp/repo/wt")
        assertEquals("/tmp/repo/wt", wt.path)

        val sub = Submodule("my-submodule", repo)
        assertEquals("my-submodule", sub.name)
    }
}
