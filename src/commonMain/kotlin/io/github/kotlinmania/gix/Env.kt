// port-lint: source env.rs
package io.github.kotlinmania.gix

/**
 * Utilities to handle program arguments, identification agent strings, and collated errors.
 */
object Env {
    private const val VERSION = "0.1.0"

    /**
     * Returns the name of the agent for identification towards a remote server.
     */
    fun agent(): String = "gix-kotlin-$VERSION"

    /**
     * Utilities to collate errors of common operations into one error type.
     */
    object Collate {
        /**
         * An error combining failure modes when opening a repository, finding remotes, and fetching.
         */
        sealed class FetchError(
            message: String,
            cause: Throwable? = null,
        ) : Exception(message, cause) {
            class Open(
                message: String,
                cause: Throwable? = null,
            ) : FetchError(message, cause)

            class FindExistingReference(
                message: String,
                cause: Throwable? = null,
            ) : FetchError(message, cause)

            class RemoteInit(
                message: String,
                cause: Throwable? = null,
            ) : FetchError(message, cause)

            class FindExistingRemote(
                message: String,
                cause: Throwable? = null,
            ) : FetchError(message, cause)

            class Connect(
                message: String,
                cause: Throwable? = null,
            ) : FetchError(message, cause)

            class PrepareFetch(
                message: String,
                cause: Throwable? = null,
            ) : FetchError(message, cause)

            class Fetch(
                message: String,
                cause: Throwable? = null,
            ) : FetchError(message, cause)

            class Other(
                message: String,
                cause: Throwable? = null,
            ) : FetchError(message, cause)

            fun isSpurious(): Boolean =
                when (this) {
                    is Connect, is PrepareFetch, is Fetch -> true
                    else -> false
                }

            fun isCorrupted(): Boolean =
                when (this) {
                    is Open -> true
                    else -> false
                }
        }
    }
}
