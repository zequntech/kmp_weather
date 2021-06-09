package tech.zequn.app.weathersdk

import io.ktor.client.*
import io.ktor.client.engine.ios.*

actual class HttpFactory {
    actual fun createHttpClient(): HttpClient {
        return HttpClient(Ios) {

        }
    }
}