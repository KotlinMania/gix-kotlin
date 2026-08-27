// port-lint: source gix/src/submodule/errors.rs
package io.github.kotlinmania.gix.submodule

/**
 * Error hierarchy for submodule operations.
 */
object Errors {
    sealed class OpenModulesFile(message: String, cause: Throwable? = null) : Exception(message, cause) {
        class Configuration(message: String, cause: Throwable? = null) : OpenModulesFile(message, cause)
        class Io(message: String, cause: Throwable? = null) : OpenModulesFile(message, cause)
    }

    sealed class Modules(message: String, cause: Throwable? = null) : Exception(message, cause) {
        class OpenModulesFileError(message: String, cause: Throwable? = null) : Modules(message, cause)
        class OpenIndex(message: String, cause: Throwable? = null) : Modules(message, cause)
        class FindExistingBlob(message: String, cause: Throwable? = null) : Modules(message, cause)
        class FindHeadRef(message: String, cause: Throwable? = null) : Modules(message, cause)
        class PeelHeadRef(message: String, cause: Throwable? = null) : Modules(message, cause)
        class PeelObjectToCommit(message: String, cause: Throwable? = null) : Modules(message, cause)
        class TreeFromCommit(message: String, cause: Throwable? = null) : Modules(message, cause)
    }

    sealed class IsActive(message: String, cause: Throwable? = null) : Exception(message, cause) {
        class InitIsActivePlatform(message: String, cause: Throwable? = null) : IsActive(message, cause)
        class QueryIsActive(message: String, cause: Throwable? = null) : IsActive(message, cause)
        class InitAttributes(message: String, cause: Throwable? = null) : IsActive(message, cause)
        class ObtainIndex(message: String, cause: Throwable? = null) : IsActive(message, cause)
    }

    sealed class FetchRecurse(message: String, cause: Throwable? = null) : Exception(message, cause) {
        class ModuleBoolean(message: String, cause: Throwable? = null) : FetchRecurse(message, cause)
        class ConfigurationFallback(message: String, cause: Throwable? = null) : FetchRecurse(message, cause)
    }

    sealed class Open(message: String, cause: Throwable? = null) : Exception(message, cause) {
        class OpenRepository(message: String, cause: Throwable? = null) : Open(message, cause)
        class PathConfiguration(message: String, cause: Throwable? = null) : Open(message, cause)
        class WorktreeDirInaccessible(message: String, cause: Throwable? = null) : Open(message, cause)
    }

    sealed class IndexId(message: String, cause: Throwable? = null) : Exception(message, cause) {
        class PathConfiguration(message: String, cause: Throwable? = null) : IndexId(message, cause)
        class Index(message: String, cause: Throwable? = null) : IndexId(message, cause)
    }

    sealed class HeadId(message: String, cause: Throwable? = null) : Exception(message, cause) {
        class HeadCommit(message: String, cause: Throwable? = null) : HeadId(message, cause)
        class CommitTree(message: String, cause: Throwable? = null) : HeadId(message, cause)
        class PeelTree(message: String, cause: Throwable? = null) : HeadId(message, cause)
        class PathConfiguration(message: String, cause: Throwable? = null) : HeadId(message, cause)
    }
}
