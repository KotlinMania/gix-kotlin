// port-lint: source gix/src/path.rs
package io.github.kotlinmania.gix

/**
 * Path utilities for Git repositories and working trees.
 */
object Path {
    /**
     * Normalizes a repository-relative or absolute file path by resolving '.' and '..' components.
     */
    fun normalize(path: String): String {
        val isAbsolute = path.startsWith("/") || (path.length > 2 && path[1] == ':' && (path[2] == '/' || path[2] == '\\'))
        val separator = if (path.contains('\\') && !path.contains('/')) '\\' else '/'
        val parts = path.split('/', '\\')
        val stack = mutableListOf<String>()

        for (part in parts) {
            when {
                part.isEmpty() || part == "." -> continue
                part == ".." -> {
                    if (stack.isNotEmpty() && stack.last() != "..") {
                        stack.removeAt(stack.size - 1)
                    } else if (!isAbsolute) {
                        stack.add(part)
                    }
                }
                else -> stack.add(part)
            }
        }

        val result = stack.joinToString(separator.toString())
        return if (isAbsolute && !result.startsWith(separator.toString())) {
            if (path.startsWith("/")) "/$result" else result
        } else {
            result
        }
    }

    /**
     * Combines base path and child path components.
     */
    fun join(base: String, child: String): String {
        if (base.isEmpty()) return child
        if (child.isEmpty()) return base
        val cleanBase = base.trimEnd('/', '\\')
        val cleanChild = child.trimStart('/', '\\')
        return "$cleanBase/$cleanChild"
    }

    /**
     * Returns the parent directory path, or null if root / none.
     */
    fun parent(path: String): String? {
        val normalized = normalize(path).trimEnd('/', '\\')
        val lastSlash = normalized.lastIndexOfAny(charArrayOf('/', '\\'))
        return if (lastSlash > 0) {
            normalized.substring(0, lastSlash)
        } else if (lastSlash == 0) {
            "/"
        } else {
            null
        }
    }
}
