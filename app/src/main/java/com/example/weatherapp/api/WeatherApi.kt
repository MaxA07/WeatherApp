package com.example.weatherapp.api

import com.example.weatherapp.model.WeatherModel
import retrofit2.Response
import retrofit2.http.GET

interface WeatherApi {

    @GET("data/2.5/weather?q=volgograd&appid=6f740a9f7d4c766a8115e18f9863b32f")
    suspend fun getData(): Response<WeatherModel>
}