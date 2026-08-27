// port-lint: source gix/src/push.rs
package io.github.kotlinmania.gix

/**
 * All possible values of `push.default`.
 */
enum class PushDefault {
    /** Do not push anything unless a refspec is provided explicitly. */
    Nothing,

    /** Push the current branch to update a remote branch with the same name. */
    Current,

    /** Push the current branch to the upstream tracking branch. */
    Upstream,

    /** Push the current branch with the same name to the remote. */
    Simple,

    /** Push all matching branches to remote. */
    Matching,
}
