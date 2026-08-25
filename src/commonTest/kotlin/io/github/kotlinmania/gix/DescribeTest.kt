package io.github.kotlinmania.gix

import io.github.kotlinmania.gix.hash.ObjectId
import kotlin.test.Test
import kotlin.test.assertEquals

class DescribeTest {
    @Test
    fun testDescribeOutcomeFormat() {
        val oid = ObjectId.fromHex("e69de29bb2d1d6434b8b29ae775ad8c2e48c5391")
        val outcomeExact = Describe.Outcome("v1.0.0", 0, oid)
        assertEquals("v1.0.0", outcomeExact.format())

        val outcomeAhead = Describe.Outcome("v1.0.0", 3, oid)
        assertEquals("v1.0.0-3-ge69de29", outcomeAhead.format())
    }
}
