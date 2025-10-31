package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.weatherapp.MainViewModel


@Composable
fun DailyForecast(mainViewModel: MainViewModel) {

    val weather by mainViewModel.weather.collectAsState()
    val forecastDays = weather?.forecast?.forecastDays

    if(!forecastDays.isNullOrEmpty()) {

        LazyColumn(

            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)

        ) {
            items(forecastDays) { forecastDay ->
                val day = forecastDay.day
                val date = forecastDay.date

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = date,
                        style = MaterialTheme.typography.titleLarge,

                    )
                    Text(
                        text = day.condition.text,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Image(
                        painter = rememberAsyncImagePainter("https:${day.condition.icon}"),
                        contentDescription = "Weather Icon",
                        modifier = Modifier
                            .size(80.dp)
                    )
                    Text(
                        text = "High: ${day.maxTemp} °C" +
                                "Low: ${day.minTemp} °C",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "${day.condition.text}. " +
                                "Chance of Rain: ${day.rainChance}%" +
                                " Precipitation: ${day.precipitationAmount} mm" +
                                " Wind: ${day.maxWind} kph." +
                                " Humidity: ${day.avgHumidity}%",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier
                            .fillMaxSize()
                            .absolutePadding()
                            .padding(top = 16.dp)

                    )

                }
            }
        }
    }
}








