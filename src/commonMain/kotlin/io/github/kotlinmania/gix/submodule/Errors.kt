// port-lint: source submodule/errors.rs
package io.github.kotlinmania.gix.submodule

/**
 * Error hierarchy for submodule operations.
 */
object Errors {
    sealed class OpenModulesFile(
        open val message: String,
        open val cause: String? = null,
    ) {
        class Configuration(
            override val message: String,
            override val cause: String? = null,
        ) : OpenModulesFile(message, cause)

        class Io(
            override val message: String,
            override val cause: String? = null,
        ) : OpenModulesFile(message, cause)
    }

    sealed class Modules(
        open val message: String,
        open val cause: String? = null,
    ) {
        class OpenModulesFileError(
            override val message: String,
            override val cause: String? = null,
        ) : Modules(message, cause)

        class OpenIndex(
            override val message: String,
            override val cause: String? = null,
        ) : Modules(message, cause)

        class FindExistingBlob(
            override val message: String,
            override val cause: String? = null,
        ) : Modules(message, cause)

        class FindHeadRef(
            override val message: String,
            override val cause: String? = null,
        ) : Modules(message, cause)

        class PeelHeadRef(
            override val message: String,
            override val cause: String? = null,
        ) : Modules(message, cause)

        class PeelObjectToCommit(
            override val message: String,
            override val cause: String? = null,
        ) : Modules(message, cause)

        class TreeFromCommit(
            override val message: String,
            override val cause: String? = null,
        ) : Modules(message, cause)
    }

    sealed class IsActive(
        open val message: String,
        open val cause: String? = null,
    ) {
        class InitIsActivePlatform(
            override val message: String,
            override val cause: String? = null,
        ) : IsActive(message, cause)

        class QueryIsActive(
            override val message: String,
            override val cause: String? = null,
        ) : IsActive(message, cause)

        class InitAttributes(
            override val message: String,
            override val cause: String? = null,
        ) : IsActive(message, cause)

        class ObtainIndex(
            override val message: String,
            override val cause: String? = null,
        ) : IsActive(message, cause)
    }

    sealed class FetchRecurse(
        open val message: String,
        open val cause: String? = null,
    ) {
        class ModuleBoolean(
            override val message: String,
            override val cause: String? = null,
        ) : FetchRecurse(message, cause)

        class ConfigurationFallback(
            override val message: String,
            override val cause: String? = null,
        ) : FetchRecurse(message, cause)
    }

    sealed class Open(
        open val message: String,
        open val cause: String? = null,
    ) {
        class OpenRepository(
            override val message: String,
            override val cause: String? = null,
        ) : Open(message, cause)

        class PathConfiguration(
            override val message: String,
            override val cause: String? = null,
        ) : Open(message, cause)

        class WorktreeDirInaccessible(
            override val message: String,
            override val cause: String? = null,
        ) : Open(message, cause)
    }

    sealed class IndexId(
        open val message: String,
        open val cause: String? = null,
    ) {
        class PathConfiguration(
            override val message: String,
            override val cause: String? = null,
        ) : IndexId(message, cause)

        class Index(
            override val message: String,
            override val cause: String? = null,
        ) : IndexId(message, cause)
    }

    sealed class HeadId(
        open val message: String,
        open val cause: String? = null,
    ) {
        class HeadCommit(
            override val message: String,
            override val cause: String? = null,
        ) : HeadId(message, cause)

        class CommitTree(
            override val message: String,
            override val cause: String? = null,
        ) : HeadId(message, cause)

        class PeelTree(
            override val message: String,
            override val cause: String? = null,
        ) : HeadId(message, cause)

        class PathConfiguration(
            override val message: String,
            override val cause: String? = null,
        ) : HeadId(message, cause)
    }
}
