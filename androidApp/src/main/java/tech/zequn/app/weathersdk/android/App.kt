package tech.zequn.app.weathersdk.android

import android.app.Application
import tech.zequn.app.weathersdk.SDKManager

/**
 * Created by zequn on 2021/6/10.
 * Email: zequntech@gmail.com
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        SDKManager.init(this)
    }
}