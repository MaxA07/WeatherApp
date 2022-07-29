package com.example.weatherapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.model.Weather
import com.example.weatherapp.model.WeatherModel
import com.example.weatherapp.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class WeatherViewModel(private val repository: Repository): ViewModel() {
    val myResponse: MutableLiveData<Response<WeatherModel>> = MutableLiveData()
    fun getWeather() {
        viewModelScope.launch {
            val response = repository.getWeather()
            myResponse.value = response

        }
    }
}