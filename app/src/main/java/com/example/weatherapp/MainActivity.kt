package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.repository.Repository
import com.example.weatherapp.screens.MainFragment
import com.example.weatherapp.viewmodels.WeatherViewModelFactory
import com.example.weatherapp.viewmodels.WeatherViewModel


class MainActivity : AppCompatActivity() {
    lateinit var viewModel: WeatherViewModel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = Repository()
        val viewModelFactory = WeatherViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(WeatherViewModel::class.java)
        viewModel.getWeather()
        viewModel.myResponse.observe(this, Observer { response ->

            if (response.isSuccessful) {
                Log.d("asd", response.body()?.main?.temp.toString())
                binding.text.text = response.body()?.main?.temp.toString()
            }

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.place_holder, MainFragment.newInstance())
                .commit()
        })

    }
}
