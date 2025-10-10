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
            temperature = 14.0,
            precipitationType = "N/A",
            precipitationAmount = 0.0,
            windDirection = "NE",
            windSpeed = 19.0

        )

        _current.value = current

    }
}