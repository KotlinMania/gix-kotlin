// port-lint: source mailmap.rs
package io.github.kotlinmania.gix

/**
 * Errors returned by mailmap loading operations.
 */
object Mailmap {
    sealed class LoadError(
        open val message: String,
        open val cause: String? = null,
    ) {
        class Io(
            override val message: String,
            override val cause: String? = null,
        ) : LoadError(message, cause)

        class BlobSpec(
            override val message: String,
            override val cause: String? = null,
        ) : LoadError(message, cause)

        class PathInterpolate(
            override val message: String,
            override val cause: String? = null,
        ) : LoadError(message, cause)

        class FindExisting(
            override val message: String,
            override val cause: String? = null,
        ) : LoadError(message, cause)
    }
}
