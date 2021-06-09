package tech.zequn.app.weathersdk

interface Platform {
    val platform: String

    fun generateUUID(): String

    fun storageDir(): String
}

expect class PlatformFactory {
    fun createPlatform(): Platform
}