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
    val temperature: Double,
    val precipitationType: String,
    val precipitationAmount: Double,
    val windDirection: String,
    val windSpeed: Double
)

data class Forecast(
    val date: String,
    val image: Int,
    val temperatureHigh: Double,
    val temperatureLow: Double,
    val condition: String,
    val precipitationType: String,
    val precipitationAmount: Double,
    val precipitationProbability: Double,
    val windDirection: String,
    val windSpeed: Double,
    val humidity: Double
    )

