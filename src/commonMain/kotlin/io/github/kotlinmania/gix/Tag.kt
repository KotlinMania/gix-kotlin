// port-lint: source tag.rs
package io.github.kotlinmania.gix

/**
 * Error returned by tag operations on a repository.
 */
sealed class TagError(
    message: String,
    cause: Throwable? = null,
) : Exception(message, cause) {
    class ReferenceNameValidation(
        message: String,
        cause: Throwable? = null,
    ) : TagError(message, cause)

    class WriteObject(
        message: String,
        cause: Throwable? = null,
    ) : TagError(message, cause)

    class ReferenceEdit(
        message: String,
        cause: Throwable? = null,
    ) : TagError(message, cause)

    class DateParseError(
        message: String,
        cause: Throwable? = null,
    ) : TagError(message, cause)
}
