package com.example.weatherreport.activity.splashScreen

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.ViewModel
import com.example.weatherreport.activity.splashScreen.weather.WeatherDetailActivity
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

class WelcomeScreenViewModel (): ViewModel() {

    fun goToWeatherReport(activity: Activity)
    {
        val backgroundExecutor: ScheduledExecutorService =
            Executors.newSingleThreadScheduledExecutor()
        backgroundExecutor.schedule({

            activity.startActivity(Intent(activity, WeatherDetailActivity::class.java))
            activity.finish()

        }, 3, TimeUnit.SECONDS)
    }
}