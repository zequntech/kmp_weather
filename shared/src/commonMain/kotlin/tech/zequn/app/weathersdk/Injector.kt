package tech.zequn.app.weathersdk

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.http.*

/**
 * Created by zequn on 2021/6/10.
 * Email: zequntech@gmail.com
 */
class Injector(
    private val platformFactory: PlatformFactory,
    private val kvStoreFactory: KVStoreFactory,
    private val httpFactory: HttpFactory,
    private val env: String,
    private val debuggable: Boolean,
) {
    private val platform: Platform by lazy { platformFactory.createPlatform() }

    private val kvStore: KVStore by lazy { kvStoreFactory.createKVStore() }

    private val httpClient: HttpClient by lazy {
        return@lazy httpFactory.createHttpClient().config {
            expectSuccess = false
            install(JsonFeature) {
                serializer = KotlinxSerializer(json = kotlinx.serialization.json.Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                })
                acceptContentTypes += ContentType("text", "html")
            }
        }
    }

    val apiService: ApiService by lazy { ApiService(httpClient) }
}