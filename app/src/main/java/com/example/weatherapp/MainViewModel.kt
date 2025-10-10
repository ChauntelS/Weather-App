package com.example.weatherapp

import androidx.lifecycle.ViewModel
import com.example.weatherapp.models.Current
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {

    private val _current = MutableStateFlow<Current?>(null)
    val current = _current.asStateFlow()


    init {


        val current = Current(
            weather = "Partly Cloudy",
            image = R.drawable.part_cloudy,
            condition = "Overcast",
            temperature = "Temperature: 14°C",
            precipitationType = "Precipitation: N/A",
            precipitationAmount = "Amount: N/A",
            windDirection = "Wind Direction: NE",
            windSpeed = "Wind Speed: 19 km/h"

        )

        _current.value = current

    }
}