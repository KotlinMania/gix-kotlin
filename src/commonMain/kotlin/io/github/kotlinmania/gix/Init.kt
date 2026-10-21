// port-lint: source init.rs
package io.github.kotlinmania.gix

/**
 * The name of the branch to use if none is configured via git configuration.
 */
const val DEFAULT_BRANCH_NAME: String = "main"

/**
 * The error returned by repository initialization.
 */
sealed class InitError {
    data class CurrentDir(
        val message: String,
    ) : InitError()

    data class Init(
        val message: String,
    ) : InitError()

    data class Open(
        val message: String,
    ) : InitError()

    data class InvalidBranchName(
        val name: String,
        val message: String,
    ) : InitError()

    data class EditHeadForDefaultBranch(
        val message: String,
    ) : InitError()
}

/**
 * Create a repository with worktree within [directory], creating intermediate directories as needed.
 */

/**
 * Create a repository with worktree within [directory], creating intermediate directories as needed.
 */
@OptIn(kotlin.experimental.ExperimentalObjCName::class)
@kotlin.native.ObjCName("initRepo", swiftName = "initRepo")
fun init(directory: String): ThreadSafeRepository =
    ThreadSafeRepository.init(directory)

/**
 * Similar to [init], but allows determining how exactly to open the newly created repository.
 */
fun initOpts(directory: String): ThreadSafeRepository =
    ThreadSafeRepository.initOpts(directory)
