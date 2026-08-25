// port-lint: source types.rs
package io.github.kotlinmania.gix

import io.github.kotlinmania.gix.hash.ObjectId
import io.github.kotlinmania.gix.objs.Kind

/**
 * A worktree checkout containing the files of the repository in consumable form.
 */
data class Worktree(
    val parent: Repository,
    val path: String,
)

/**
 * Possible kinds of a HEAD reference.
 */
enum class HeadKind {
    Unborn,
    Symbolic,
    Detached,
}

/**
 * The head reference, as created from looking at `.git/HEAD`, able to represent all of its possible states.
 */
data class Head(
    val kind: HeadKind,
    val repo: Repository,
)

/**
 * A decoded object with a reference to its owning repository.
 */
class Object(
    val id: ObjectId,
    val kind: Kind,
    val data: ByteArray,
    val repo: Repository,
) {
    fun detached(): ObjectDetached = ObjectDetached(id, kind, data.copyOf())

    fun detach(): ObjectDetached = detached()

    fun toId(): Id = Id(id, repo)

    override fun equals(other: Any?): Boolean =
        other is Object && id == other.id && kind == other.kind && data.contentEquals(other.data)

    override fun hashCode(): Int = id.hashCode() * 31 + kind.hashCode()

    override fun toString(): String = "${kind}(${id.toHex()})"
}

/**
 * A blob along with access to its owning repository.
 */
data class Blob(
    val id: ObjectId,
    val data: ByteArray,
    val repo: Repository,
) {
    override fun equals(other: Any?): Boolean =
        other is Blob && id == other.id && data.contentEquals(other.data)

    override fun hashCode(): Int = id.hashCode() * 31 + data.contentHashCode()
}

/**
 * A decoded tag object with access to its owning repository.
 */
data class Tag(
    val id: ObjectId,
    val data: ByteArray,
    val repo: Repository,
) {
    override fun equals(other: Any?): Boolean =
        other is Tag && id == other.id && data.contentEquals(other.data)

    override fun hashCode(): Int = id.hashCode() * 31 + data.contentHashCode()
}

/**
 * A decoded commit object with access to its owning repository.
 */
data class Commit(
    val id: ObjectId,
    val data: ByteArray,
    val repo: Repository,
) {
    override fun equals(other: Any?): Boolean =
        other is Commit && id == other.id && data.contentEquals(other.data)

    override fun hashCode(): Int = id.hashCode() * 31 + data.contentHashCode()
}

/**
 * A detached, self-contained object, without access to its source repository.
 */
data class ObjectDetached(
    val id: ObjectId,
    val kind: Kind,
    val data: ByteArray,
) {
    fun attach(repo: Repository): Object = Object(id, kind, data.copyOf(), repo)

    override fun equals(other: Any?): Boolean =
        other is ObjectDetached && id == other.id && kind == other.kind && data.contentEquals(other.data)

    override fun hashCode(): Int = id.hashCode() * 31 + kind.hashCode()

    override fun toString(): String = "${kind}(${id.toHex()})"
}

/**
 * A reference that points to an object or reference, with access to its source repository.
 */
data class Reference(
    val name: String,
    val target: String,
    val repo: Repository,
) {
    fun detach(): String = target
}

/**
 * A thread-local handle to interact with a repository from a single thread.
 */
class Repository(
    val workTree: String? = null,
    val gitDir: String = "",
    val isBare: Boolean = workTree == null,
) {
    fun workdir(): String? = workTree

    fun toThreadSafe(): ThreadSafeRepository = ThreadSafeRepository(workTree, gitDir, isBare)
}

/**
 * A thread-safe repository container.
 */
class ThreadSafeRepository(
    val workTree: String? = null,
    val gitDir: String = "",
    val isBare: Boolean = workTree == null,
) {
    fun toThreadLocal(): Repository = Repository(workTree, gitDir, isBare)
}

/**
 * A remote which represents a way to interact with hosts for remote clones of the parent repository.
 */
data class Remote(
    val name: String? = null,
    val url: String? = null,
    val pushUrl: String? = null,
    val repo: Repository,
)

/**
 * A utility to make matching against pathspecs simple.
 */
data class Pathspec(
    val repo: Repository,
    val patterns: List<String> = emptyList(),
) {
    fun detach(): PathspecDetached = PathspecDetached(patterns)
}

/**
 * Like [Pathspec], but without a Repository reference and with minimal API.
 */
data class PathspecDetached(
    val patterns: List<String> = emptyList(),
)

/**
 * A stand-in for the submodule of a particular name.
 */
data class Submodule(
    val name: String,
    val repo: Repository,
)
