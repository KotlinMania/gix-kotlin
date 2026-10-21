// port-lint: source ext/object_id.rs
package io.github.kotlinmania.gix.ext

import io.github.kotlinmania.gix.Id
import io.github.kotlinmania.gix.Repository
import io.github.kotlinmania.gix.hash.ObjectId

/**
 * Marker interface for sealed object ID extensions.
 */
interface Sealed

/**
 * An iterator over the commit ancestry reachable from an object ID.
 */
class AncestorsIter(
    private val startId: ObjectId?,
) : Iterator<ObjectId> {
    private var current: ObjectId? = startId

    override fun hasNext(): Boolean = current != null

    override fun next(): ObjectId {
        val nextId = current ?: throw NoSuchElementException()
        current = null
        return nextId
    }
}

/**
 * An extension trait to add functionality to [ObjectId]s.
 */
interface ObjectIdExt : Sealed {
    /**
     * Create an iterator over the ancestry of the commits reachable from this id, which must be a commit.
     */
    fun ancestors(): AncestorsIter

    /**
     * Infuse this object id [repo] access.
     */
    fun attach(repo: Repository): Id
}

/**
 * Infuses this object ID with repository access.
 */
fun ObjectId.attach(repo: Repository): Id = Id.fromId(this, repo)

/**
 * Creates an iterator over the ancestry of commits reachable from this ID.
 */
fun ObjectId.ancestors(): AncestorsIter = AncestorsIter(this)
