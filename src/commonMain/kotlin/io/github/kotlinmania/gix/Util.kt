// port-lint: source util.rs
package io.github.kotlinmania.gix

import kotlin.concurrent.atomics.AtomicBoolean
import kotlin.concurrent.atomics.ExperimentalAtomicApi

/**
 * An atomic boolean flag representation that can be shared or owned.
 */
@OptIn(ExperimentalAtomicApi::class)
class OwnedOrStaticAtomicBool(
    private val flag: AtomicBoolean = AtomicBoolean(false),
) {
    fun get(): Boolean = flag.load()

    fun set(value: Boolean) {
        flag.store(value)
    }

    fun swap(value: Boolean): Boolean = flag.exchange(value)

    companion object {
        fun default(): OwnedOrStaticAtomicBool = OwnedOrStaticAtomicBool(AtomicBoolean(false))
    }
}
