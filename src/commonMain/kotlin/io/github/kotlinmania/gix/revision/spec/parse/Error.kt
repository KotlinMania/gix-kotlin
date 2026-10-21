// port-lint: source revision/spec/parse/error.rs
package io.github.kotlinmania.gix.revision.spec.parse

import io.github.kotlinmania.gix.Object
import io.github.kotlinmania.gix.Repository
import io.github.kotlinmania.gix.hash.ObjectId
import io.github.kotlinmania.gix.objs.Kind

/**
 * Additional information about candidates that caused ambiguity.
 */
sealed class CandidateInfo {
    /**
     * An error occurred when looking up the object in the database.
     */
    data class FindError(
        val source: String,
    ) : CandidateInfo() {
        override fun toString(): String = fmt()
    }

    /**
     * The candidate is an object of the given [kind].
     */
    data class Object(
        val kind: Kind,
    ) : CandidateInfo() {
        override fun toString(): String = fmt()
    }

    /**
     * The candidate is a tag.
     */
    data class Tag(
        val name: String,
    ) : CandidateInfo() {
        override fun toString(): String = fmt()
    }

    /**
     * The candidate is a commit.
     */
    data class Commit(
        val date: String,
        val title: String,
    ) : CandidateInfo() {
        override fun toString(): String = fmt()
    }

    fun fmt(): String =
        when (this) {
            is FindError -> "lookup error: $source"
            is Tag -> "tag \"$name\""
            is Object -> kind.toString()
            is Commit -> "commit $date \"$title\""
        }

    override fun toString(): String = fmt()
}

/**
 * Sort order for ambiguous candidate kinds.
 */
enum class Order {
    Tag,
    Commit,
    Tree,
    Blob,
    Invalid,
}

/**
 * Formats an ambiguity error message for candidate object IDs.
 */
fun ambiguous(candidates: List<ObjectId>, prefix: String, repo: Repository): String {
    val candidateTuples = candidates.map { oid ->
        val obj = repo.findObject(oid)
        val order = when (obj?.kind) {
            Kind.Tag -> Order.Tag
            Kind.Commit -> Order.Commit
            Kind.Tree -> Order.Tree
            Kind.Blob -> Order.Blob
            null -> Order.Invalid
        }
        Triple(oid, obj, order)
    }.sortedWith(compareBy<Triple<ObjectId, Object?, Order>> { it.third }.thenBy { it.first })

    val infoList = candidateTuples.map { (oid, obj, _) ->
        val info = when (obj?.kind) {
            Kind.Tree, Kind.Blob -> CandidateInfo.Object(obj.kind)
            Kind.Tag -> CandidateInfo.Tag(oid.toHex())
            Kind.Commit -> CandidateInfo.Commit("", oid.toHex())
            null -> CandidateInfo.FindError("object not found")
        }
        val shortened = oid.toHex().take(7)
        "\t$shortened $info"
    }

    return "Short id $prefix is ambiguous. Candidates are:\n" + infoList.joinToString("\n")
}

/**
 * Backward compatibility helper for formatting ambiguity error messages.
 */
fun formatAmbiguousError(prefix: String, candidates: List<ObjectId>): String =
    "Short id $prefix is ambiguous. Candidates are:\n" +
        candidates.joinToString("\n") { "\t${it.toHex()}" }
