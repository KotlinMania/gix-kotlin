// port-lint: source id.rs
package io.github.kotlinmania.gix

import io.github.kotlinmania.gix.hash.ObjectId

typealias Target = ObjectId

/**
 * An [ObjectId] infused with a [Repository].
 */
data class Id(
    val inner: ObjectId,
    val repo: Repository,
) : Comparable<Id> {
    /**
     * Header information for an object in an odb store.
     */
    data class Header(
        val kind: io.github.kotlinmania.gix.objs.Kind,
        val size: ULong,
    )

    /**
     * Shortening errors.
     */
    sealed class Error {
        data class NotFound(
            val oid: ObjectId,
        ) : Error()
    }

    /**
     * Find the object associated with this object id.
     */
    fun `object`(): Object? = repo.findObject(inner)

    /**
     * Try to find the object associated with this object id.
     */
    fun tryObject(): Object? = repo.tryFindObject(inner)

    /**
     * Find the header associated with this object id.
     */
    fun header(): Header? = null

    /**
     * Try to find the header associated with this object id.
     */
    fun tryHeader(): Header? = null

    /**
     * Turn this instance into its bare [ObjectId].
     */
    fun detach(): ObjectId = inner

    /**
     * Reference access to the inner object ID.
     */
    fun deref(): ObjectId = inner

    /**
     * AsRef access to the inner object ID.
     */
    fun asRef(): ObjectId = inner

    /**
     * Turn this object id into a shortened hex string prefix.
     */
    fun shorten(length: Int = 7): String {
        val hex = inner.toHex()
        val clamped = length.coerceIn(4, hex.length)
        return hex.substring(0, clamped)
    }

    /**
     * Turn this object id into a shortened hex string, or the full hex in fallback cases.
     */
    fun shortenOrId(length: Int = 7): String = shorten(length)

    /**
     * Obtain a platform for traversing ancestors of this commit.
     */
    fun ancestors(): List<ObjectId> = listOf(inner)

    override fun compareTo(other: Id): Int = inner.compareTo(other.inner)

    override fun toString(): String = inner.toHex()

    companion object {
        fun fromId(id: ObjectId, repo: Repository): Id = Id(id, repo)

        fun from(v: Id): ObjectId = v.inner

        fun calculateAutoHexLen(numPackedObjects: ULong): Int {
            var len = 64 - numPackedObjects.countLeadingZeroBits()
            len = (len + 1) / 2
            return maxOf(len, 7)
        }
    }
}
