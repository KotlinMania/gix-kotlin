// port-lint: source gix/src/filter.rs
package io.github.kotlinmania.gix

/**
 * Filter errors and pipeline options.
 */
object Filter {
    /**
     * EOL and CRLF roundtrip options.
     */
    enum class CrlfRoundTripCheck {
        Disabled,
        Warn,
        Fail,
    }

    /**
     * Configuration options for Git filters.
     */
    data class PipelineOptions(
        val autoCrlf: Boolean = false,
        val eol: String? = null,
        val crlfRoundTripCheck: CrlfRoundTripCheck = CrlfRoundTripCheck.Disabled,
    )
}
