// port-lint: source util.rs
package io.github.kotlinmania.gix

/**
 * An atomic boolean flag representation that can be shared or owned.
 */
class OwnedOrStaticAtomicBool(
    private var flag: Boolean = false,
) {
    fun get(): Boolean = flag

    fun set(value: Boolean) {
        flag = value
    }

    fun swap(value: Boolean): Boolean {
        val prev = flag
        flag = value
        return prev
    }

    companion object {
        fun default(): OwnedOrStaticAtomicBool = OwnedOrStaticAtomicBool(false)
    }
}
