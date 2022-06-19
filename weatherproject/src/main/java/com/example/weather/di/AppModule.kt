package com.example.weather.di

import com.example.weather.data.AuthApi
import com.example.weather.data.RemoteDataSource
import com.example.weather.repository.BaseRepository

class AppModule {

 companion object {
     fun provideAuthApi(remoteDataSource: RemoteDataSource) : AuthApi {
         return remoteDataSource.buildApi(AuthApi::class.java)
     }

     fun provideBaseRepository(repository: BaseRepository) : BaseRepository {
         return repository
     }
 }

}