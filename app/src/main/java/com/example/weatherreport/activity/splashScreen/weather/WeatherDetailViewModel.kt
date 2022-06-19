package com.example.weatherreport.activity.splashScreen.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.data.Resource
import com.example.weather.model.weatherModel.WeatherResponse
import com.example.weather.repository.WeatherRepository
import kotlinx.coroutines.launch

class WeatherDetailViewModel (private var weatherRepository: WeatherRepository) : ViewModel() {


    private val _weatherResponse : MutableLiveData<Resource<WeatherResponse>> = MutableLiveData()
    val weatherResponse : LiveData<Resource<WeatherResponse>>
        get() = _weatherResponse


    fun getWeatherInfo(latitude : String , longitude : String
    ) = viewModelScope.launch {
        _weatherResponse.value = weatherRepository.getWeatherInformation(latitude,longitude,"hourly,minutely","ae1c4977a943a50eaa7da25e6258d8b2","Metric","4")
    }
}