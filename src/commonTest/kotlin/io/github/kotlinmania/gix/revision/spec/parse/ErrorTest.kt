// port-lint: tests revision/spec/parse/error.rs
package io.github.kotlinmania.gix.revision.spec.parse

import io.github.kotlinmania.gix.Repository
import io.github.kotlinmania.gix.hash.ObjectId
import io.github.kotlinmania.gix.objs.Kind
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ErrorTest {
    @Test
    fun testCandidateInfoFmt() {
        val findErr = CandidateInfo.FindError("failed lookup")
        assertEquals("lookup error: failed lookup", findErr.fmt())
        assertEquals("lookup error: failed lookup", findErr.toString())

        val objCandidate = CandidateInfo.Object(Kind.Blob)
        assertEquals("Blob", objCandidate.fmt())

        val tagCandidate = CandidateInfo.Tag("v1.0")
        assertEquals("tag \"v1.0\"", tagCandidate.fmt())

        val commitCandidate = CandidateInfo.Commit("2026-10-20", "Initial commit")
        assertEquals("commit 2026-10-20 \"Initial commit\"", commitCandidate.fmt())
    }

    @Test
    fun testOrderValues() {
        val orders = Order.values()
        assertEquals(5, orders.size)
        assertTrue(Order.Tag < Order.Commit)
        assertTrue(Order.Commit < Order.Tree)
        assertTrue(Order.Tree < Order.Blob)
        assertTrue(Order.Blob < Order.Invalid)
    }

    @Test
    fun testAmbiguousFormatting() {
        val repo = Repository(workTree = "/tmp/repo", gitDir = "/tmp/repo/.git")
        val oid1 = ObjectId.fromHex("e69de29bb2d1d6434b8b29ae775ad8c2e48c5391")
        val oid2 = ObjectId.fromHex("0000000000000000000000000000000000000000")

        val result = ambiguous(listOf(oid1, oid2), "e69d", repo)
        assertTrue(result.contains("Short id e69d is ambiguous. Candidates are:"))
        assertTrue(result.contains("e69de29"))

        val backwardCompatibleResult = formatAmbiguousError("e69d", listOf(oid1))
        assertTrue(backwardCompatibleResult.contains("Short id e69d is ambiguous."))
    }
}
