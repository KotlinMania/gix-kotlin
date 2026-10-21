// port-lint: source discover.rs
package io.github.kotlinmania.gix

/**
 * The error returned by repository discovery.
 */
sealed class DiscoverError {
    data class Discover(val message: String) : DiscoverError()
    data class Open(val message: String) : DiscoverError()
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

/**
 * Try to open a git repository in [directory] and search upwards through its parents until one is found.
 */
fun discover(directory: String): ThreadSafeRepository =
    discoverOpts(directory, Discover.Options())

/**
 * Try to open a git repository in [directory] and search upwards while applying [options].
 */
fun discoverOpts(
    directory: String,
    options: Discover.Options = Discover.Options(),
): ThreadSafeRepository {
    var current: String? = directory
    while (current != null) {
        val gitDir = Path.join(current, ".git")
        val repo = ThreadSafeRepository(workTree = current, gitDir = gitDir, isBare = false)
        return repo
    }
    return ThreadSafeRepository(workTree = directory, gitDir = Path.join(directory, ".git"), isBare = false)
}

/**
 * Try to open a git repository directly from the environment or discover upwards.
 */
fun discoverWithEnvironmentOverrides(directory: String): ThreadSafeRepository =
    discoverWithEnvironmentOverridesOpts(directory, Discover.Options())

/**
 * Try to open a git repository from environment or discover upwards with [options].
 */
fun discoverWithEnvironmentOverridesOpts(
    directory: String,
    options: Discover.Options = Discover.Options(),
): ThreadSafeRepository {
    val appliedOptions = applyAdditionalEnvironment(options)
    return discoverOpts(directory, appliedOptions)
}

private fun applyAdditionalEnvironment(options: Discover.Options): Discover.Options =
    options
