package com.example.weatherapp

import com.example.weatherapp.services.WeatherService

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.models.Current
import com.example.weatherapp.models.Forecast
import com.example.weatherapp.models.Location
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
        .baseUrl("https://api.weatherapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val weatherService: WeatherService = retrofit.create(WeatherService::class.java)


    fun fetchWeather(location: String = "Halifax, Canada") {
        viewModelScope.launch {
            try {
                val response = weatherService.getWeather(
                    apiKey = "3e38794920a945d8a49115240251710",
                    location = location,
                    days = 14
                )
                _weather.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

//    init {
//
//        val weather = Weather(
//            current = Current(
//                weather = "Partly Cloudy",
//                image = R.drawable.part_cloudy,
//                condition = "Overcast",
//                temperature = "Temperature: 14°C",
//                precipitationType = "Precipitation: N/A",
//                precipitationAmount = "Amount: N/A",
//                windDirection = "Wind Direction: NE",
//                windSpeed = "Wind Speed: 19 km/h"
//
//            ),
//            forecast = listOf(
//                Forecast(
//                    date = "Today",
//                    condition = "Partly Cloudy",
//                    image = R.drawable.part_cloudy,
//                    temperatureHigh = "14°C",
//                    temperatureLow = "8°C",
//                    precipitationType = "Precipitation: N/A",
//                    precipitationAmount = "Amount: N/A",
//                    precipitationProbability = "0%",
//                    windDirection = "Wind Direction:NE",
//                    windSpeed = "Wind Speed:19 km/h",
//                    humidity = "Humidity: 46%"
//                ),
//
//                Forecast(
//                    date = "Tomorrow",
//                    image = R.drawable.storm,
//                    temperatureHigh = "12°C",
//                    temperatureLow = "6°C",
//                    condition = "Rain",
//                    precipitationType = "Precipitation: Rain",
//                    precipitationAmount = "Amount: 5mm",
//                    precipitationProbability = "80%",
//                    windDirection = "Wind Direction:E",
//                    windSpeed = "Wind Speed:25 km/h",
//                    humidity = "Humidity: 70%"
//                ),
//
//                Forecast(
//                    date = "Following Days",
//                    image = R.drawable.sun,
//                    temperatureHigh = "25°C",
//                    temperatureLow = "15°C",
//                    condition = "Sunny",
//                    precipitationType = "Precipitation: N/A",
//                    precipitationAmount = "Amount: N/A",
//                    precipitationProbability = "0%",
//                    windDirection = "Wind Direction:SW",
//                    windSpeed = "Wind Speed:10 km/h",
//                    humidity = "Humidity: 30%"
//                )
//            )
//        )


