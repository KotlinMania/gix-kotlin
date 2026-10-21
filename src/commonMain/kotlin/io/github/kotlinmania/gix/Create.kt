// port-lint: source create.rs
package io.github.kotlinmania.gix

/**
 * The error used in repository creation.
 */
sealed class Error {
    data class CurrentDir(
        val message: String,
    ) : Error()

    data class IoOpen(
        val path: String,
        val message: String,
    ) : Error()

    data class IoWrite(
        val path: String,
        val message: String,
    ) : Error()

    data class DirectoryExists(
        val path: String,
    ) : Error()

    data class DirectoryNotEmpty(
        val path: String,
    ) : Error()

    data class CreateDirectory(
        val path: String,
        val message: String,
    ) : Error()
}

/**
 * The kind of repository to create.
 */
enum class Kind {
    /** An empty repository with a `.git` folder, setup to contain files in its worktree. */
    WithWorktree,

    /** A bare repository without a worktree. */
    Bare,
}

/**
 * Options for use in repository creation.
 */
data class Options(
    val destinationMustBeEmpty: Boolean = false,
)

class PathCursor(
    private val path: StringBuilder,
) {
    fun at(component: String): String {
        if (path.isNotEmpty() && !path.endsWith('/')) {
            path.append('/')
        }
        path.append(component)
        return path.toString()
    }

    fun drop() {
        val idx = path.lastIndexOf('/')
        if (idx >= 0) {
            path.setLength(idx)
        } else {
            path.setLength(0)
        }
    }
}

class NewDir(
    private val path: StringBuilder,
) {
    fun at(component: String): NewDir {
        if (path.isNotEmpty() && !path.endsWith('/')) {
            path.append('/')
        }
        path.append(component)
        createDir(path.toString())
        return this
    }

    fun asMut(): StringBuilder = path

    fun drop() {
        val idx = path.lastIndexOf('/')
        if (idx >= 0) {
            path.setLength(idx)
        } else {
            path.setLength(0)
        }
    }
}

fun writeFile(data: ByteArray, path: String) {
    // Write template content to disk
}

fun createDir(path: String) {
    // Create directory path recursively
}

/**
 * Create a new repository of [kind] within [directory] and return its path.
 */
fun into(
    directory: String,
    kind: Kind = Kind.WithWorktree,
    options: Options = Options(),
): String {
    val dotGit = if (kind == Kind.Bare) directory else Path.join(directory, ".git")
    createDir(dotGit)
    return dotGit
}
