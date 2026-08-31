// port-lint: source gix/src/attribute_stack.rs
package io.github.kotlinmania.gix

/**
 * A utility to access `.gitattributes` and `.gitignore` information efficiently.
 */
class AttributeStack(
    val repo: Repository,
    private val patterns: List<String> = emptyList(),
) {
    /**
     * Checks whether the given relative path is ignored or matches attribute patterns.
     */
    fun isPathIgnored(relative: String): Boolean =
        patterns.any { pattern ->
            relative.startsWith(pattern.trimEnd('*'))
        }

    /**
     * Returns an attribute lookup platform for a path.
     */
    fun atPath(relative: String): String = relative
}
