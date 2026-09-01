// port-lint: source revision/spec/parse/error.rs
package io.github.kotlinmania.gix.revision.spec.parse

import io.github.kotlinmania.gix.hash.ObjectId
import io.github.kotlinmania.gix.objs.Kind

/**
 * Additional information about candidates that caused ambiguity during revision parsing.
 */
sealed class CandidateInfo {
    data class FindError(
        val source: String,
    ) : CandidateInfo()

    data class ObjectCandidate(
        val kind: Kind,
    ) : CandidateInfo()

    data class TagCandidate(
        val name: String,
    ) : CandidateInfo()

    data class CommitCandidate(
        val date: String,
        val title: String,
    ) : CandidateInfo()
}

/**
 * Formats an ambiguity error message for candidate object IDs.
 */
fun formatAmbiguousError(prefix: String, candidates: List<ObjectId>): String =
    "Short id $prefix is ambiguous. Candidates are:\n" +
        candidates.joinToString("\n") { "\t${it.toHex()}" }
