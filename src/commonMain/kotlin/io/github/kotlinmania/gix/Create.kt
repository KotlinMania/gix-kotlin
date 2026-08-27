// port-lint: source gix/src/create.rs
package io.github.kotlinmania.gix

/**
 * Kind of repository to create.
 */
enum class CreateKind {
    /** An empty repository with a `.git` folder and working tree. */
    WithWorktree,

    /** A bare repository without a working tree. */
    Bare,
}

/**
 * Options for repository creation.
 */
data class CreateOptions(
    val destinationMustBeEmpty: Boolean = false,
)

/**
 * Error returned during repository creation.
 */
sealed class CreateError(message: String, cause: Throwable? = null) : Exception(message, cause) {
    class CurrentDir(message: String, cause: Throwable? = null) : CreateError(message, cause)
    class IoOpen(message: String, cause: Throwable? = null) : CreateError(message, cause)
    class IoWrite(message: String, cause: Throwable? = null) : CreateError(message, cause)
    class DirectoryExists(message: String) : CreateError(message)
    class DirectoryNotEmpty(message: String) : CreateError(message)
    class CreateDirectory(message: String, cause: Throwable? = null) : CreateError(message, cause)
}
