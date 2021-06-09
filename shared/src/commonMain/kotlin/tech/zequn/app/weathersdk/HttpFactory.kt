package tech.zequn.app.weathersdk

import io.ktor.client.*

expect class HttpFactory {
    fun createHttpClient(): HttpClient
}