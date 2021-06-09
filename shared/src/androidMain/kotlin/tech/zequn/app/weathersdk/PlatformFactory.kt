package tech.zequn.app.weathersdk

import android.content.Context
import java.util.*

actual class PlatformFactory(private val context: Context) {

    actual fun createPlatform(): Platform {
        return object : Platform {
            override val platform: String = "Android"

            override fun generateUUID(): String = UUID.randomUUID().toString()

            override fun storageDir(): String {
                return context.getExternalFilesDir("mpp")!!.path
            }
        }
    }
}