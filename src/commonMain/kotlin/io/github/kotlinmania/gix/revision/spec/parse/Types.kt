// port-lint: source gix/src/revision/spec/parse/types.rs
package io.github.kotlinmania.gix.revision.spec.parse

/**
 * A hint to know what to do if refs and object names are equal.
 */
enum class RefsHint {
    /** Prefer object on full length hex sha, use ref otherwise. */
    PreferObjectOnFullLengthHexShaUseRefOtherwise,

    /** Always prefer object matches. */
    PreferObject,

    /** Always prefer reference matches. */
    PreferRef,

    /** Fail on ambiguity between refs and objects. */
    Fail,
}

/**
 * A hint to know which object kind to prefer if multiple objects match a prefix.
 */
enum class ObjectKindHint {
    Commit,
    Committish,
    Tree,
    Treeish,
    Blob,
}

/**
 * Options for parsing revision specifications.
 */
data class Options(
    val refsHint: RefsHint = RefsHint.PreferObjectOnFullLengthHexShaUseRefOtherwise,
    val objectKindHint: ObjectKindHint? = null,
)
