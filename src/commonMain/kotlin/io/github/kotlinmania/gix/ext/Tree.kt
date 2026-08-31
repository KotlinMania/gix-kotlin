// port-lint: source gix/src/ext/tree.rs
package io.github.kotlinmania.gix.ext

import io.github.kotlinmania.gix.Repository
import io.github.kotlinmania.gix.objs.Entry
import io.github.kotlinmania.gix.objs.Tree

/**
 * Attached entry with repository reference.
 */
data class AttachedEntry(
    val entry: Entry,
    val repo: Repository,
)

/**
 * Attached tree with repository reference.
 */
data class AttachedTree(
    val tree: Tree,
    val repo: Repository,
)

/**
 * Attach repository to a tree entry.
 */
fun Entry.attach(repo: Repository): AttachedEntry = AttachedEntry(this, repo)

/**
 * Attach repository to a tree.
 */
fun Tree.attach(repo: Repository): AttachedTree = AttachedTree(this, repo)
