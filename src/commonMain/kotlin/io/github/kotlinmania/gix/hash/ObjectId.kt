// port-lint: source gix/src/id.rs
package io.github.kotlinmania.gix.hash

/**
 * An object identifier representing a Git SHA-1 (20 bytes) or SHA-256 (32 bytes) hash.
 */
class ObjectId private constructor(
    private val rawBytes: ByteArray,
) : Comparable<ObjectId> {
    val bytes: ByteArray
        get() = rawBytes.copyOf()

    val kind: Kind
        get() =
            when (rawBytes.size) {
                20 -> Kind.Sha1
                32 -> Kind.Sha256
                else -> error("Invalid object ID length: ${rawBytes.size}")
            }

    fun asBytes(): ByteArray = bytes

    fun toHex(): String {
        val chars = CharArray(rawBytes.size * 2)
        var i = 0
        for (b in rawBytes) {
            val v = b.toInt() and 0xFF
            chars[i++] = HEX_DIGITS[v ushr 4]
            chars[i++] = HEX_DIGITS[v and 0x0F]
        }
        return chars.concatToString()
    }

    fun isNull(): Boolean = rawBytes.all { it == 0.toByte() }

    override fun toString(): String = toHex()

    override fun equals(other: Any?): Boolean =
        other is ObjectId && rawBytes.contentEquals(other.rawBytes)

    override fun hashCode(): Int = rawBytes.contentHashCode()

    override fun compareTo(other: ObjectId): Int {
        val minLen = minOf(rawBytes.size, other.rawBytes.size)
        for (i in 0 until minLen) {
            val a = rawBytes[i].toInt() and 0xFF
            val b = other.rawBytes[i].toInt() and 0xFF
            if (a != b) return a.compareTo(b)
        }
        return rawBytes.size.compareTo(other.rawBytes.size)
    }

    enum class Kind(
        val byteSize: Int,
    ) {
        Sha1(20),
        Sha256(32),
    }

    companion object {
        private const val HEX_DIGITS = "0123456789abcdef"

        fun fromBytes(bytes: ByteArray): ObjectId {
            require(bytes.size == 20 || bytes.size == 32) {
                "ObjectId must be 20 or 32 bytes, got ${bytes.size}"
            }
            return ObjectId(bytes.copyOf())
        }

        fun fromHex(hex: String): ObjectId {
            require(hex.length == 40 || hex.length == 64) {
                "ObjectId hex string must be 40 or 64 characters, got ${hex.length}"
            }
            val byteLength = hex.length / 2
            val bytes = ByteArray(byteLength)
            for (i in 0 until byteLength) {
                val hi = parseHexNibble(hex[i * 2])
                val lo = parseHexNibble(hex[i * 2 + 1])
                bytes[i] = ((hi shl 4) or lo).toByte()
            }
            return ObjectId(bytes)
        }

        fun nullSha1(): ObjectId = ObjectId(ByteArray(20))

        fun nullSha256(): ObjectId = ObjectId(ByteArray(32))

        private fun parseHexNibble(c: Char): Int =
            when (c) {
                in '0'..'9' -> c - '0'
                in 'a'..'f' -> c - 'a' + 10
                in 'A'..'F' -> c - 'A' + 10
                else -> throw IllegalArgumentException("Invalid hex character: $c")
            }
    }
}
