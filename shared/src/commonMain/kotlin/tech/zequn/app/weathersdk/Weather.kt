package tech.zequn.app.weathersdk

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by zequn on 2021/6/10.
 * Email: zequntech@gmail.com
 */
@Serializable
data class Weather(
    @SerialName("weatherinfo")
    val weatherinfo: WeatherInfo,
)

@Serializable
data class WeatherInfo(
    @SerialName("city")
    val city: String,
    @SerialName("cityid")
    val cityid: String,
    @SerialName("temp1")
    val temp1: String,
    @SerialName("temp2")
    val temp2: String,
    @SerialName("weather")
    val weather: String,
    @SerialName("img1")
    val img1: String,
    @SerialName("img2")
    val img2: String,
    @SerialName("ptime")
    val ptime: String
)