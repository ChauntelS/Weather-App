package com.example.weatherapp

import com.example.weatherapp.services.WeatherService

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.models.Weather
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {


    private val _weather = MutableStateFlow<Weather?>(null)
    val weather = _weather.asStateFlow()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.weatherapi.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val weatherService: WeatherService = retrofit.create(WeatherService::class.java)

    private val apiKey = "3e38794920a945d8a49115240251710"



    fun fetchWeather(lat: Double, lon: Double) {
        viewModelScope.launch {
            try {
                val response =
                    weatherService.getWeather(apiKey, "$lat,$lon", 3, "no", "no")
                _weather.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


}



