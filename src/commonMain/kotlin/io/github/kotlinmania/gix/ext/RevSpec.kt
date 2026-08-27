// port-lint: source gix/src/ext/rev_spec.rs
package io.github.kotlinmania.gix.ext

import io.github.kotlinmania.gix.Repository

/**
 * A revision specification attached to a repository.
 */
data class AttachedRevSpec(
    val spec: String,
    val repo: Repository,
)

/**
 * Attach repository to a revision specification string.
 */
fun String.attach(repo: Repository): AttachedRevSpec = AttachedRevSpec(this, repo)
