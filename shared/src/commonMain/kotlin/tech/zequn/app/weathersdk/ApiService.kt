package tech.zequn.app.weathersdk

import io.ktor.client.*
import io.ktor.client.request.*

/**
 * Created by zequn on 2021/6/10.
 * Email: zequntech@gmail.com
 */
class ApiService(private val httpClient: HttpClient) {
    suspend fun fetchWeather(): Weather {
        return httpClient.get<Weather>("http://www.weather.com.cn/data/cityinfo/101200101.html")
    }
}