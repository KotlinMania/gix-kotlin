// port-lint: source shallow.rs
package io.github.kotlinmania.gix

import io.github.kotlinmania.gix.hash.ObjectId

/**
 * A list of commits at the shallow boundary behind which no commits are available.
 */
data class ShallowCommits(
    val commits: List<ObjectId> = emptyList(),
) {
    fun isEmpty(): Boolean = commits.isEmpty()

    fun contains(id: ObjectId): Boolean = commits.contains(id)
}

/**
 * Errors relating to shallow repository reading and writing.
 */
object Shallow {
    sealed class ReadError(
        message: String,
        cause: Throwable? = null,
    ) : Exception(message, cause) {
        class Io(
            message: String,
            cause: Throwable? = null,
        ) : ReadError(message, cause)

        class Parse(
            message: String,
            cause: Throwable? = null,
        ) : ReadError(message, cause)
    }

    sealed class WriteError(
        message: String,
        cause: Throwable? = null,
    ) : Exception(message, cause) {
        class Io(
            message: String,
            cause: Throwable? = null,
        ) : WriteError(message, cause)
    }
}
