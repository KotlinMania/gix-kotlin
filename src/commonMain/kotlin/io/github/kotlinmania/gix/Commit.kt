// port-lint: source commit.rs
package io.github.kotlinmania.gix

import io.github.kotlinmania.gix.hash.ObjectId

/**
 * An empty list of parent object IDs.
 */
val NO_PARENT_IDS: List<ObjectId> = emptyList()

/**
 * Error returned by commit operations on a repository.
 */
sealed class CommitError(
    message: String,
    cause: Throwable? = null,
) : Exception(message, cause) {
    class ParseTime(
        message: String,
        cause: Throwable? = null,
    ) : CommitError(message, cause)

    class CommitterMissing(
        message: String = "Committer identity is not configured",
    ) : CommitError(message)

    class AuthorMissing(
        message: String = "Author identity is not configured",
    ) : CommitError(message)

    class ReferenceNameValidation(
        message: String,
        cause: Throwable? = null,
    ) : CommitError(message, cause)

    class WriteObject(
        message: String,
        cause: Throwable? = null,
    ) : CommitError(message, cause)

    class ReferenceEdit(
        message: String,
        cause: Throwable? = null,
    ) : CommitError(message, cause)
}

/**
 * Support types and configuration for git describe operations.
 */
object Describe {
    /**
     * A selector to choose what kind of references should contribute to describe names.
     */
    enum class SelectRef {
        /** Only use annotated tags for names. */
        AnnotatedTags,

        /** Use all tags for names, annotated or plain reference. */
        AllTags,

        /** Use all references, including local branch names. */
        AllRefs,
    }

    /**
     * The outcome of a git describe operation.
     */
    data class Outcome(
        val name: String,
        val depth: Int,
        val id: ObjectId,
    ) {
        fun format(hexLen: Int = 7): String {
            val prefix = id.toHex().take(hexLen)
            return if (depth == 0) name else "$name-$depth-g$prefix"
        }
    }

    /**
     * The result of resolving a describe query on a commit.
     */
    data class Resolution(
        val outcome: Outcome,
        val id: Id,
    ) {
        fun format(): String = outcome.format()
    }
}
