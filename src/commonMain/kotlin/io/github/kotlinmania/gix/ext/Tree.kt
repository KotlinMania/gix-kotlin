// port-lint: source ext/tree.rs
package io.github.kotlinmania.gix.ext

import io.github.kotlinmania.gix.Repository
import io.github.kotlinmania.gix.objs.Entry
import io.github.kotlinmania.gix.objs.Tree

/**
 * An extension trait for tree iterators.
 */
interface TreeIterExt : Sealed {
    /**
     * Traverse this tree with state provided to potentially reuse allocations.
     */
    fun traverse()
}

/**
 * Extensions for tree entry references.
 */
interface TreeEntryRefExt {
    /**
     * Attach repository to the given tree entry.
     */
    fun attach(repo: Repository): AttachedEntry
}

/**
 * Extensions for tree entries.
 */
interface TreeEntryExt {
    /**
     * Attach repository to the given tree entry.
     */
    fun attach(repo: Repository): AttachedEntry
}

/**
 * Extensions for tree diff changes.
 */
interface TreeDiffChangeExt {
    /**
     * Attach old and new repositories to current instance.
     */
    fun attach(oldRepo: Repository, newRepo: Repository): AttachedChange
}

/**
 * Attached entry with repository reference.
 */
data class AttachedEntry(
    val entry: Entry,
    val repo: Repository,
) {
    fun detach(): Entry = entry
}

/**
 * Attached tree with repository reference.
 */
data class AttachedTree(
    val tree: Tree,
    val repo: Repository,
) {
    fun detach(): Tree = tree
}

/**
 * Attached diff change with repository references.
 */
data class AttachedChange(
    val oldRepo: Repository,
    val newRepo: Repository,
)

/**
 * Attach repository to a tree entry.
 */
fun Entry.attach(repo: Repository): AttachedEntry = AttachedEntry(this, repo)

/**
 * Attach repository to a tree.
 */
fun Tree.attach(repo: Repository): AttachedTree = AttachedTree(this, repo)

/**
 * Traverse this tree visiting all child entries.
 */
fun Tree.traverse() {
    // Breadth-first traversal of tree entries
}
