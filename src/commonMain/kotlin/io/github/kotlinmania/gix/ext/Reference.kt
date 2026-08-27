// port-lint: source gix/src/ext/reference.rs
package io.github.kotlinmania.gix.ext

import io.github.kotlinmania.gix.Reference
import io.github.kotlinmania.gix.Repository

/**
 * Extensions for Git references.
 */
fun Reference.attach(repo: Repository): Reference = Reference(name, target, repo)
