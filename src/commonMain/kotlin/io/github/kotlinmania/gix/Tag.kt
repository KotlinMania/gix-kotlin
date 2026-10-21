// port-lint: source tag.rs
package io.github.kotlinmania.gix

/**
 * Error returned by tag operations on a repository.
 */
sealed class TagError(
    open val message: String,
    open val cause: String? = null,
) {
    class ReferenceNameValidation(
        override val message: String,
        override val cause: String? = null,
    ) : TagError(message, cause)

    class WriteObject(
        override val message: String,
        override val cause: String? = null,
    ) : TagError(message, cause)

    class ReferenceEdit(
        override val message: String,
        override val cause: String? = null,
    ) : TagError(message, cause)

    class DateParseError(
        override val message: String,
        override val cause: String? = null,
    ) : TagError(message, cause)
}
