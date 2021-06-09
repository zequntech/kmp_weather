package tech.zequn.app.weathersdk

interface KVStore {
    fun putInt(key: String, t: Int): KVStore

    fun putLong(key: String, t: Long): KVStore

    fun putBoolean(key: String, t: Boolean): KVStore

    fun putDouble(key: String, t: Double): KVStore

    fun putFloat(key: String, t: Float): KVStore

    fun putString(key: String, t: String): KVStore

    fun getInt(key: String, default: Int): Int

    fun getLong(key: String, default: Long): Long

    fun getDouble(key: String, default: Double): Double

    fun getFloat(key: String, default: Float): Float

    fun getBoolean(key: String, default: Boolean): Boolean

    fun getString(key: String, default: String): String

    fun remove(key: String): KVStore

    fun removeAll(): KVStore

    fun keys(): Set<String>
}

expect class KVStoreFactory {
    fun createKVStore(): KVStore
}