// port-lint: source state.rs
package io.github.kotlinmania.gix

/**
 * Tell what operation is currently in progress.
 */
enum class InProgress {
    /** A mailbox is being applied. */
    ApplyMailbox,

    /** A rebase is happening while a mailbox is being applied. */
    ApplyMailboxRebase,

    /** A git bisect operation has not yet been concluded. */
    Bisect,

    /** A cherry pick operation. */
    CherryPick,

    /** A cherry pick with multiple commits pending. */
    CherryPickSequence,

    /** A merge operation. */
    Merge,

    /** A rebase operation. */
    Rebase,

    /** An interactive rebase operation. */
    RebaseInteractive,

    /** A revert operation. */
    Revert,

    /** A revert operation with multiple commits pending. */
    RevertSequence,
}
