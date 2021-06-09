package tech.zequn.app.weathersdk

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import okhttp3.CipherSuite.Companion.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256
import okhttp3.CipherSuite.Companion.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256
import okhttp3.CipherSuite.Companion.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.TlsVersion
import java.util.concurrent.TimeUnit


actual class HttpFactory(private val okHttpClient: OkHttpClient = createDefaultOKHttpClient()) {
    actual fun createHttpClient(): HttpClient {
        return HttpClient(OkHttp) {
            engine {
                preconfigured = okHttpClient
            }
        }
    }
}

private fun createDefaultOKHttpClient(): OkHttpClient {
    val connectionSpec: ConnectionSpec = ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
        .tlsVersions(TlsVersion.TLS_1_2)
        .cipherSuites(
            TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
            TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
            TLS_DHE_RSA_WITH_AES_128_GCM_SHA256
        )
        .build()
    val builder: OkHttpClient.Builder = OkHttpClient.Builder()
        .protocols(listOf(Protocol.HTTP_1_1))
        .retryOnConnectionFailure(true)
        .connectionSpecs(listOf(connectionSpec, ConnectionSpec.CLEARTEXT))
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
    val okHttpClient: OkHttpClient = builder.build()
    okHttpClient.dispatcher.maxRequestsPerHost = Int.MAX_VALUE
    okHttpClient.dispatcher.maxRequests = Int.MAX_VALUE
    return okHttpClient
}


