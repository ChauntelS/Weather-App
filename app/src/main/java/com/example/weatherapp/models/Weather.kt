package com.example.weatherapp.models

import com.google.gson.annotations.SerializedName

import android.health.connect.datatypes.units.Temperature
import android.media.Image
import java.util.concurrent.locks.Condition

data class Weather(
    val location: Location,
    val current: Current,
    val forecast: Forecast
)

data class Location(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,
    val tz_id: String,
    val localtime_epoch: Int,
    val localtime: String
)
data class Current(
    val last_updated_epoch: Int,
    val last_updated: String,
    val temp_c: Double,
    val is_day: Int,
    val condition: Condition,
    val wind_kph: Double,
    val wind_degree: Int,
    val wind_dir: String,
    val pressure_mb: Double,
    val precip_mm: Double,
    val humidity: Int,
    val cloud: Int,
    val feelslike_c: Double,
    val windchill_c: Double,
    val heatindex_c: Double,
    val dewpoint_c: Double,
    val vis_km: Double,
    val uv: Double,
    val gust_kph: Double,
    val short_rad: Double,
    val dif_rad: Double,
    val dni: Double,
    val gti: Double
)

data class Forecast(
    @SerializedName("forecastday") val forecastDays: List<ForecastDay>

    )

data class Condition(
    val text: String,
    val icon: String,
    val code: Int
)

data class ForecastDay(
    val date: String,
    val date_epoch: Int,
    val day: Day
)

data class Day(
    val maxtemp_c: Double,
    val mintemp_c: Double,
    val avgtemp_c: Double,
    val avgtemp_f: Double,
    val maxwind_kph: Double,
    val totalprecip_mm: Double,
    val totalsnow_cm: Double,
    val avgvis_km: Double,
    val avghumidity: Double,
    val daily_will_it_rain: Int,
    val daily_chance_of_rain: Int,
    val daily_will_it_snow: Int,
    val daily_chance_of_snow: Int,
    val condition: Condition,
    val uv: Double

)
