// port-lint: source ext/tree.rs
package io.github.kotlinmania.gix.objs

import io.github.kotlinmania.gix.hash.ObjectId

/**
 * Git file and object mode within a tree entry.
 */
enum class EntryMode(
    val octalMode: Int,
) {
    Tree(16384), // 0o040000
    Blob(33188), // 0o100644
    BlobExecutable(33261), // 0o100755
    Link(40960), // 0o120000
    Commit(57344), // 0o160000
    ;

    val isTree: Boolean
        get() = this == Tree

    val isBlob: Boolean
        get() = this == Blob || this == BlobExecutable

    val isBlobExecutable: Boolean
        get() = this == BlobExecutable

    val isLink: Boolean
        get() = this == Link

    val isCommit: Boolean
        get() = this == Commit

    val kind: EntryKind
        get() =
            when (this) {
                Tree -> EntryKind.Tree
                Blob -> EntryKind.Blob
                BlobExecutable -> EntryKind.BlobExecutable
                Link -> EntryKind.Link
                Commit -> EntryKind.Commit
            }

    fun toOctalString(): String =
        when (this) {
            Tree -> "040000"
            Blob -> "100644"
            BlobExecutable -> "100755"
            Link -> "120000"
            Commit -> "160000"
        }

    companion object {
        fun fromOctal(mode: Int): EntryMode? =
            when (mode) {
                16384 -> Tree
                33188 -> Blob
                33261 -> BlobExecutable
                40960 -> Link
                57344 -> Commit
                else -> null
            }
    }
}

/**
 * Kind of entry in a Git tree.
 */
enum class EntryKind {
    Tree,
    Blob,
    BlobExecutable,
    Link,
    Commit,
}

/**
 * A single entry in a Git tree object.
 */
data class Entry(
    val mode: EntryMode,
    val filename: String,
    val oid: ObjectId,
) : Comparable<Entry> {
    override fun compareTo(other: Entry): Int {
        val cmp = filename.compareTo(other.filename)
        return if (cmp != 0) cmp else mode.compareTo(other.mode)
    }
}

/**
 * A decoded Git tree object containing a list of entries.
 */
class Tree(
    val entries: List<Entry>,
) {
    constructor() : this(emptyList())

    fun findEntry(filename: String): Entry? = entries.firstOrNull { it.filename == filename }

    val size: Int
        get() = entries.size

    val isEmpty: Boolean
        get() = entries.isEmpty()

    override fun equals(other: Any?): Boolean = other is Tree && entries == other.entries

    override fun hashCode(): Int = entries.hashCode()

    override fun toString(): String = "Tree(entries=$entries)"
}
