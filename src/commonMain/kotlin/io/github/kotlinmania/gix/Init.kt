// port-lint: source gix/src/init.rs
package io.github.kotlinmania.gix

/**
 * The name of the branch to use if none is configured via git configuration.
 */
const val DEFAULT_BRANCH_NAME: String = "main"

/**
 * Errors returned by repository initialization.
 */
sealed class InitError(
    message: String,
    cause: Throwable? = null,
) : Exception(message, cause) {
    class CurrentDir(
        message: String,
        cause: Throwable? = null,
    ) : InitError(message, cause)

    class Create(
        message: String,
        cause: Throwable? = null,
    ) : InitError(message, cause)

    class Open(
        message: String,
        cause: Throwable? = null,
    ) : InitError(message, cause)

    class InvalidBranchName(
        message: String,
        cause: Throwable? = null,
    ) : InitError(message, cause)

    class EditHeadForDefaultBranch(
        message: String,
        cause: Throwable? = null,
    ) : InitError(message, cause)
}
