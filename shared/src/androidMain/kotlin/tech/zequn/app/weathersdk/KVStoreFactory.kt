package tech.zequn.app.weathersdk

import com.tencent.mmkv.MMKV

/**
 * Created by zequn on 4/2/21.
 * Email: zequntech@gmail.com
 */
private class KVStoreImpl : KVStore {
    private val mmkv: MMKV by lazy { MMKV.defaultMMKV()!! }
    override fun putInt(key: String, t: Int): KVStore {
        mmkv.putInt(key, t)
        return this
    }

    override fun putLong(key: String, t: Long): KVStore {
        mmkv.putLong(key, t)
        return this
    }

    override fun putBoolean(key: String, t: Boolean): KVStore {
        mmkv.putBoolean(key, t)
        return this
    }

    override fun putDouble(key: String, t: Double): KVStore {
        mmkv.putString(key, t.toString())
        return this
    }

    override fun putFloat(key: String, t: Float): KVStore {
        mmkv.putFloat(key, t)
        return this
    }

    override fun putString(key: String, t: String): KVStore {
        mmkv.putString(key, t)
        return this
    }

    override fun getInt(key: String, default: Int): Int {
        return mmkv.getInt(key, default)
    }

    override fun getLong(key: String, default: Long): Long {
        return mmkv.getLong(key, default)
    }

    override fun getDouble(key: String, default: Double): Double {
        return mmkv.getString(key, default.toString())?.toDouble() ?: default
    }

    override fun getFloat(key: String, default: Float): Float {
        return mmkv.getFloat(key, default)
    }

    override fun getBoolean(key: String, default: Boolean): Boolean {
        return mmkv.getBoolean(key, default)
    }

    override fun getString(key: String, default: String): String {
        return mmkv.getString(key, default) ?: default
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
        return mmkv.allKeys()?.toSet() ?: setOf()
    }
}

actual class KVStoreFactory {

    actual fun createKVStore(): KVStore {
        return KVStoreImpl()
    }
}