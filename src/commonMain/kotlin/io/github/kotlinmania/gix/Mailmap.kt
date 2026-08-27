// port-lint: source mailmap.rs
package io.github.kotlinmania.gix

/**
 * Errors returned by mailmap loading operations.
 */
object Mailmap {
    sealed class LoadError(
        message: String,
        cause: Throwable? = null,
    ) : Exception(message, cause) {
        class Io(
            message: String,
            cause: Throwable? = null,
        ) : LoadError(message, cause)

        class BlobSpec(
            message: String,
            cause: Throwable? = null,
        ) : LoadError(message, cause)

        class PathInterpolate(
            message: String,
            cause: Throwable? = null,
        ) : LoadError(message, cause)

        class FindExisting(
            message: String,
            cause: Throwable? = null,
        ) : LoadError(message, cause)
    }
}
