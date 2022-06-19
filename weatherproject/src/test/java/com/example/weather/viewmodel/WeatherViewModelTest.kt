package com.example.weather.viewmodel

import com.example.weather.BaseUnitTestViewModel
import com.example.weather.data.Resource
import com.example.weather.model.weatherModel.WeatherResponse
import com.example.weather.repository.WeatherRepository
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response

class WeatherViewModelTest : BaseUnitTestViewModel(){


    private lateinit var weatherViewModel: WeatherViewModel
    //   private val context = mockk<Context>()

    private lateinit var repository: WeatherRepository

    @Before
    fun setUp(){
        repository = mockk()
        weatherViewModel= spyk(WeatherViewModel(repository))
    }




    @Test
    fun `test getWeatherInfo on success`(){
        val response = Resource.Success(mockk<WeatherResponse>{
            every { lat } returns 51.5099
        })
        coEvery { repository.getWeatherInformation("51.509865","-0.118092","hourly,minutely","ae1c4977a943a50eaa7da25e6258d8b2","Metric","4") } returns response
        weatherViewModel.getWeatherInfo()
        Assert.assertTrue(weatherViewModel.weatherResponse.value is Resource<WeatherResponse>)
        Assert.assertEquals(weatherViewModel.weatherResponse.value ,response)
        weatherViewModel.weatherResponse.observeForever {
            when(it){
                is Resource.Success ->{
                    assertEquals(it.value.lat, 51.5099)
                }
                is Resource.Failure -> TODO()
                else -> {}
            }
        }
    }
    @Test
    fun `test getWeatherInfo on exception`(){
        coEvery { repository.getWeatherInformation("","-0.118092","hourly,minutely","ae1c4977a943a50eaa7da25e6258d8b2","Metric","4") } throws HttpException(
            Response.error<Any>(400, "Nothing to geocode"
                .toResponseBody("plain/text".toMediaTypeOrNull())
            )
        )

        weatherViewModel.getWeatherInfo()
        Assert.assertFalse(weatherViewModel.weatherResponse.value is Resource<WeatherResponse>)
        weatherViewModel.weatherResponse.observeForever {
            when(it){
                is Resource.Failure ->{
                    Assert.assertEquals(it.errorCode, 400)
                }
                else -> {}
            }
        }
    }
}

