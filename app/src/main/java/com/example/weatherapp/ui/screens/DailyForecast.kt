package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.weatherapp.MainViewModel


@Composable
fun DailyForecast(mainViewModel: MainViewModel) {

    val weather by mainViewModel.weather.collectAsState()
    val forecastDays = weather?.forecast?.forecastDays

    if(!forecastDays.isNullOrEmpty()) {

        LazyColumn(

            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color(0xFFB3E5FC), Color(0xFFE1F5FE))
                    )
                )
                .padding(12.dp)

        ) {
            items(forecastDays) { forecastDay ->
                val day = forecastDay.day
                val date = forecastDay.date

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(4.dp, RoundedCornerShape(16.dp)),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White.copy(alpha = 0.9f)
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ){

                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = date,
                        style = MaterialTheme.typography.titleMedium,

                    )
                    //Icon and condition
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter("https:${day.condition.icon}"),
                            contentDescription = "Weather Icon",
                            modifier = Modifier.size(64.dp)
                        )
                        Spacer(Modifier.width(12.dp))
                        Text(
                            text = day.condition.text,
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            textAlign = TextAlign.Center
                        )
                    }
                    //Temperature
                    Text(
                        text = "High: ${day.maxTemp} °C | Low: ${day.minTemp} °C",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                    //Additional details
                    Text(
                        text = """
                                🌧️ Rain: ${day.rainChance}%  |  💧 Precip: ${day.precipitationAmount} mm
                                💨 Wind: ${day.maxWind} kph  |  💦 Humidity: ${day.avgHumidity}%
                            """.trimIndent(),
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )
                    //Astro details
                    Divider(Modifier.padding(vertical = 4.dp))
                    Text(
                        text = "🌅 Sunrise: ${forecastDay.astro.sunrise} | 🌇 Sunset: ${forecastDay.astro.sunset}",
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "🌙 Moon Phase: ${forecastDay.astro.moon_phase}",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Light,
                        textAlign = TextAlign.Center
                    )

                }
            }
        }
    }

    }
}








