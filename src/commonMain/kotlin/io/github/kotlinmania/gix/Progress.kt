// port-lint: source gix/src/progress.rs
package io.github.kotlinmania.gix

/**
 * Progress tracking interface for long-running Git operations.
 */
interface Progress {
    /**
     * Initializes step count for an operation.
     */
    fun init(max: Int? = null)

    /**
     * Increments the step count by [step].
     */
    fun inc(step: Int = 1)

    /**
     * Sets current progress step to [step].
     */
    fun set(step: Int)

    /**
     * Marks progress as finished.
     */
    fun done()
}

/**
 * A no-op implementation of [Progress].
 */
object DiscardProgress : Progress {
    override fun init(max: Int?) {}
    override fun inc(step: Int) {}
    override fun set(step: Int) {}
    override fun done() {}
}
