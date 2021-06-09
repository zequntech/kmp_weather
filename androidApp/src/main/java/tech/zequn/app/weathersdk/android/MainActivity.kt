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
                    findViewById<TextView>(R.id.tv_weather).setText(weather.toString())
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainScope.cancel()
    }
}
