package com.example.weatherapp.repository

import com.example.weatherapp.api.RetrofitInstance
import com.example.weatherapp.model.WeatherModel
import retrofit2.Response

class Repository {
    suspend fun getWeather(): Response<WeatherModel> {
        return RetrofitInstance.api.getData()
    }
}