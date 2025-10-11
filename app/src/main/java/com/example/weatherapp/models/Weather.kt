package com.example.weatherapp.models

import android.health.connect.datatypes.units.Temperature
import android.media.Image
import java.util.concurrent.locks.Condition

data class Weather(
    val current: Current,
    val forecast: List<Forecast>
)

data class Current(
    val weather: String,
    val image: Int,
    val condition: String,
    val temperature: String,
    val precipitationType: String,
    val precipitationAmount: String,
    val windDirection: String,
    val windSpeed: String
)

data class Forecast(
    val date: String,
    val condition: String,
    val image: Int,
    val temperatureHigh: String,
    val temperatureLow: String,
    val precipitationType: String,
    val precipitationAmount: String,
    val precipitationProbability: String,
    val windDirection: String,
    val windSpeed: String,
    val humidity: String
    )

