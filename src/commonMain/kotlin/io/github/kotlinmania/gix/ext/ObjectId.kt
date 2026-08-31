// port-lint: source gix/src/ext/object_id.rs
package io.github.kotlinmania.gix.ext

import io.github.kotlinmania.gix.Id
import io.github.kotlinmania.gix.Repository
import io.github.kotlinmania.gix.hash.ObjectId

/**
 * Infuses this object ID with repository access.
 */
fun ObjectId.attach(repo: Repository): Id = Id.fromId(this, repo)
