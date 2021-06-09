package tech.zequn.app.weathersdk

import platform.Foundation.NSUUID

actual class PlatformFactory {
    actual fun createPlatform(): Platform {
        return object : Platform {
            override val platform = "ios"

            override fun generateUUID() = NSUUID().UUIDString()

            override fun storageDir(): String {
                TODO("Not yet implemented")
            }
        }
    }
}