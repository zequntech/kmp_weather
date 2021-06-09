package tech.zequn.app.weathersdk

import android.annotation.SuppressLint
import android.content.Context
import com.tencent.mmkv.MMKV

/**
 * Created by zequn on 2021/6/10.
 * Email: zequntech@gmail.com
 */
@SuppressLint("StaticFieldLeak")
object SDKManager {
    private lateinit var context: Context
    private lateinit var env: String
    private var debuggable: Boolean = true

    val injector: Injector by lazy {
        Injector(PlatformFactory(context), KVStoreFactory(), HttpFactory(), env, debuggable)
    }

    fun init(context: Context, env: String = "dev", debuggable: Boolean = true) {
        this.context = context.applicationContext
        MMKV.initialize(this.context)
        this.env = env
        this.debuggable = debuggable
    }
}