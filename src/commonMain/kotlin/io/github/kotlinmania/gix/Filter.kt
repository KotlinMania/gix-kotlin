// port-lint: source filter.rs
package io.github.kotlinmania.gix

import io.github.kotlinmania.gix.hash.ObjectId

/**
 * Filter errors and pipeline options.
 */
object Filter {
    /**
     * EOL and CRLF roundtrip options.
     */
    enum class CrlfRoundTripCheck {
        Disabled,
        Warn,
        Fail,
    }

    /**
     * Configuration options for Git filters.
     */
    data class Options(
        val autoCrlf: Boolean = false,
        val eol: String? = null,
        val crlfRoundTripCheck: CrlfRoundTripCheck = CrlfRoundTripCheck.Disabled,
    )

    /**
     * Error hierarchy for filter pipeline operations.
     */
    sealed class Error {
        data class Driver(
            val name: String,
            val message: String,
        ) : Error()

        data class WorktreeCacheAtPath(
            val message: String,
        ) : Error()

        data class Convert(
            val message: String,
        ) : Error()

        data class MissingWorktree(
            val message: String = "Cannot add worktree files in bare repositories",
        ) : Error()

        data class IO(
            val path: String,
            val message: String,
        ) : Error()
    }

    /**
     * A git pipeline for transforming data to-git and to-worktree.
     */
    class Pipeline(
        val repo: Repository,
    ) {
        companion object {
            fun options(repo: Repository): Options = Options()

            fun new(repo: Repository): Pipeline = Pipeline(repo)
        }

        fun intoParts(): Pipeline = this

        fun convertToGit(src: ByteArray, path: String): ByteArray = src

        fun convertToWorktree(src: ByteArray, path: String): ByteArray = src

        fun worktreeFileToObject(path: String): ObjectId =
            ObjectId.hashSha1(byteArrayOf())

        fun driverContextMut(): Any? = null

        fun extractDrivers(): List<String> = emptyList()
    }
}
