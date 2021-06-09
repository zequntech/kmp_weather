package tech.zequn.app.weathersdk


import cocoapods.MMKV.MMKV

/**
 * Created by zequn on 4/2/21.
 * Email: zequntech@gmail.com
 */
actual class KVStoreFactory {
    private val mmkv: MMKV by lazy { MMKV.defaultMMKV()!! }

    actual fun createKVStore(): KVStore {
        return object : KVStore {
            override fun putInt(key: String, t: Int): KVStore {
                mmkv.setInt32(t, key)
                return this
            }

            override fun putLong(key: String, t: Long): KVStore {
                mmkv.setInt64(t, key)
                return this
            }

            override fun putBoolean(key: String, t: Boolean): KVStore {
                mmkv.setBool(t, key)
                return this
            }

            override fun putDouble(key: String, t: Double): KVStore {
                mmkv.setDouble(t, key)
                return this
            }

            override fun putFloat(key: String, t: Float): KVStore {
                mmkv.setFloat(t, key)
                return this
            }

            override fun putString(key: String, t: String): KVStore {
                mmkv.setString(t, key)
                return this
            }

            override fun getInt(key: String, default: Int): Int {
                return mmkv.getInt32ForKey(key, default)
            }

            override fun getLong(key: String, default: Long): Long {
                return mmkv.getInt64ForKey(key, default)
            }

            override fun getDouble(key: String, default: Double): Double {
                return mmkv.getDoubleForKey(key, default)
            }

            override fun getFloat(key: String, default: Float): Float {
                return mmkv.getFloatForKey(key, default)
            }

            override fun getBoolean(key: String, default: Boolean): Boolean {
                return mmkv.getBoolForKey(key, default)
            }

            override fun getString(key: String, default: String): String {
                return mmkv.getStringForKey(key, default) ?: default
            }

            override fun remove(key: String): KVStore {
                mmkv.removeValueForKey(key)
                return this
            }

            override fun removeAll(): KVStore {
                mmkv.removeValuesForKeys(mmkv.allKeys())
                return this
            }

            override fun keys(): Set<String> {
                return mmkv.allKeys().map { it.toString() }.toSet()
            }
        }
    }
}