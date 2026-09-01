// port-lint: source object/mod.rs
package io.github.kotlinmania.gix.objs

/**
 * The kind of an object in Git (Commit, Tree, Blob, or Tag).
 */
enum class Kind {
    Commit,
    Tree,
    Blob,
    Tag,
}
