package tech.zequn.app.weathersdk

import cocoapods.MMKV.MMKV
import kotlin.native.concurrent.freeze

/**
 * Created by zequn on 2021/6/10.
 * Email: zequntech@gmail.com
 */
@ThreadLocal
object SDKManager {
    private lateinit var env: String
    private var debuggable: Boolean = true

    val injector: Injector by lazy {
        Injector(PlatformFactory(), KVStoreFactory(), env, debuggable)
    }

    fun init(env: String = "dev", debuggable: Boolean = true) {
        this.env = env
        this.debuggable = debuggable
        MMKV.initialize()
        injector.freeze()
    }
}