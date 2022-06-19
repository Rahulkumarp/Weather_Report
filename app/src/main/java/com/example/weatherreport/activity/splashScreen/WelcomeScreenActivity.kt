package com.example.weatherreport.activity.splashScreen

import android.os.Bundle
import com.example.weatherreport.R
import com.example.weatherreport.databinding.ActivitySplashScreenBinding
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.koin.androidx.viewmodel.ext.android.viewModel


class WelcomeScreenActivity : AppCompatActivity() {

    private val viewModel : WelcomeScreenViewModel by viewModel()
    lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen)

        viewModel.goToWeatherReport(this)

    }

}