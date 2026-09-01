// port-lint: source lib.rs
package io.github.kotlinmania.gix

import io.github.kotlinmania.gix.hash.ObjectId as HashObjectId
import io.github.kotlinmania.gix.objs.Entry as ObjsEntry
import io.github.kotlinmania.gix.objs.EntryKind as ObjsEntryKind
import io.github.kotlinmania.gix.objs.EntryMode as ObjsEntryMode
import io.github.kotlinmania.gix.objs.Kind as ObjsKind
import io.github.kotlinmania.gix.objs.Tree as ObjsTree

typealias ObjectId = HashObjectId
typealias Tree = ObjsTree
typealias Entry = ObjsEntry
typealias EntryKind = ObjsEntryKind
typealias EntryMode = ObjsEntryMode
typealias Kind = ObjsKind

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
