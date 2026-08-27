// port-lint: source discover.rs
package io.github.kotlinmania.gix

/**
 * Error returned by repository discovery.
 */
sealed class DiscoverError(
    message: String,
    cause: Throwable? = null,
) : Exception(message, cause) {
    class Discover(
        message: String,
        cause: Throwable? = null,
    ) : DiscoverError(message, cause)

    class Open(
        message: String,
        cause: Throwable? = null,
    ) : DiscoverError(message, cause)
}

/**
 * Discovery options and helpers.
 */
object Discover {
    /**
     * Options for upward repository discovery.
     */
    data class Options(
        val crossFs: Boolean = false,
        val matchCeilingDirOrError: Boolean = true,
    )
}
