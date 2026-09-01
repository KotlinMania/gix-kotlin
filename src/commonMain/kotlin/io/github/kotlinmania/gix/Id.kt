// port-lint: source id.rs
package io.github.kotlinmania.gix

import io.github.kotlinmania.gix.hash.ObjectId

/**
 * An [ObjectId] infused with a [Repository].
 */
data class Id(
    val inner: ObjectId,
    val repo: Repository,
) : Comparable<Id> {
    /**
     * Turn this instance into its bare [ObjectId].
     */
    fun detach(): ObjectId = inner

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
    fun shortenOrId(length: Int = 7): String =
        try {
            shorten(length)
        } catch (_: Exception) {
            inner.toHex()
        }

    override fun compareTo(other: Id): Int = inner.compareTo(other.inner)

    override fun toString(): String = inner.toHex()

    companion object {
        fun fromId(id: ObjectId, repo: Repository): Id = Id(id, repo)
    }
}
