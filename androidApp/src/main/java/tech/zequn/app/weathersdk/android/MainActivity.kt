package tech.zequn.app.weathersdk.android

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import tech.zequn.app.weathersdk.SDKManager


class MainActivity : AppCompatActivity() {
    private lateinit var mainScope: CoroutineScope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainScope = MainScope()
        findViewById<Button>(R.id.text_view).setOnClickListener {
            mainScope.launch(Dispatchers.IO) {
                val weather = SDKManager.injector.apiService.fetchWeather()
                launch(Dispatchers.Main) {
                    findViewById<TextView>(R.id.tv_weather).text = String.format(
                        "城市：%s\n温度：%s\n天气：%s\n",
                        weather.weatherinfo.city,
                        "${weather.weatherinfo.temp1}~${weather.weatherinfo.temp2}",
                        weather.weatherinfo.weather,
                    )
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainScope.cancel()
    }
}
