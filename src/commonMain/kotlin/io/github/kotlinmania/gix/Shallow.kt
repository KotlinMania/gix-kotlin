// port-lint: source shallow.rs
package io.github.kotlinmania.gix

import io.github.kotlinmania.gix.hash.ObjectId

/**
 * Storage for shallow commit boundary snapshots.
 */
typealias CommitsStorage = List<ObjectId>

/**
 * A lazily loaded and auto-updated list of commits which are at the shallow boundary (behind which there are no commits available),
 * sorted to allow bisecting.
 */
data class Commits(
    val commits: List<ObjectId> = emptyList(),
)

/**
 * Errors relating to shallow repository reading and writing.
 */
object Shallow {
    sealed class ReadError(
        val message: String,
        val cause: Throwable? = null,
    ) {
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
        val message: String,
        val cause: Throwable? = null,
    ) {
        class Io(
            message: String,
            cause: Throwable? = null,
        ) : WriteError(message, cause)
    }
}
