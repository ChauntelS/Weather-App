package com.example.weatherapp.models

import com.google.gson.annotations.SerializedName

data class Weather(
    val location: Location,
    val current: Current,
    val forecast: Forecast
)

data class Location(
    val name: String,
    val region: String,
    val country: String,
    @SerializedName("lat") val latitude: Double,
    @SerializedName("lon") val longitude: Double,
    val tz_id: String,
    val localtime_epoch: Int,
    val localtime: String
)
data class Current(
    @SerializedName("temp_c") val temperature: Float,
    @SerializedName("condition") val condition: Condition,
    @SerializedName ("wind_kph") val windSpeed: Float,
    @SerializedName("wind_dir") val windDirection: String,
    @SerializedName ("precip_mm") val precipitationAmount: Double,
)

data class Condition(
    val text: String,
    val icon: String,
)

data class Forecast(
    @SerializedName("forecastday") val forecastDays: List<ForecastDay>

    )

data class ForecastDay(
    @SerializedName("date") val date: String,
    @SerializedName("day") val day: Day
)

data class Day(
    @SerializedName("maxtemp_c") val maxTemp: Float,
    @SerializedName ( "mintemp_c") val minTemp: Float,
//    val avgtemp_c: Double,
//    val avgtemp_f: Double,
    @SerializedName("maxwind_kph") val maxWind: Float,
    @SerializedName ("totalprecip_mm") val precipitationAmount: Float,
    @SerializedName ("daily_chance_of_rain") val rainChance: Int,
//    val totalsnow_cm: Double,
//    val avgvis_km: Double,
    @SerializedName("avghumidity") val avgHumidity: Float,
//    val daily_will_it_rain: Int,
//    val daily_chance_of_rain: Int,
//    val daily_will_it_snow: Int,
//    val daily_chance_of_snow: Int,
    val condition: Condition
//    val uv: Double

)
