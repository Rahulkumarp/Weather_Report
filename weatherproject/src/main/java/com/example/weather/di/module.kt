package com.example.weather

import com.example.weather.data.RemoteDataSource
import com.example.weather.di.AppModule
import com.example.weather.repository.WeatherRepository
import org.koin.dsl.module

val libraryModule = module {
    single { RemoteDataSource() }
    single { AppModule.provideAuthApi(get())}
    single { WeatherRepository(get()) }
}