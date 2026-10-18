package io.github.kotlinmania.gix

/**
 * Main entry point for repository discovery and opening.
 */
object Gix {
    /**
     * Discover a Git repository starting from [directory].
     */
    fun discover(directory: String): Repository = Repository(workTree = directory, gitDir = "$directory/.git")

    /**
     * Open an existing Git repository at [directory].
     */
    fun open(directory: String): Repository = Repository(workTree = directory, gitDir = "$directory/.git")

    /**
     * Initialize a new Git repository at [directory].
     */
    fun init(directory: String, isBare: Boolean = false): Repository =
        if (isBare) {
            Repository(workTree = null, gitDir = directory, isBare = true)
        } else {
            Repository(workTree = directory, gitDir = "$directory/.git", isBare = false)
        }
}
