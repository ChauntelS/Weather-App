package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.weatherapp.MainViewModel

fun getWeatherGradient(condition: String): Brush {
    val lower = condition.lowercase()

    return when {
        "sun" in lower || "sunny" in lower || "clear" in lower -> {
            Brush.verticalGradient(
                colors = listOf(Color(0xFFFFC107), Color(0xFFFFEB3B))   // orange to yellow
            )
        }
        "rain" in lower || "drizzle" in lower || "shower" in lower -> {
            Brush.verticalGradient(
                colors = listOf(Color(0xFF90A4AE), Color(0xFFB3E5FC))   // gray to light blue
            )
        }
        "cloud" in lower || "overcast" in lower -> {
            Brush.verticalGradient(
                colors = listOf(Color(0xFFE0E0E0), Color(0xFFFFFFFF))   // light gray to white
            )
        }
        "snow" in lower || "ice" in lower -> {
            Brush.verticalGradient(
                colors = listOf(Color(0xFFB3E5FC), Color(0xFFE1F5FE))   //light blue to white
            )
        }
        "fog" in lower || "mist" in lower -> {
            Brush.verticalGradient(
                colors = listOf(Color(0xFFB0BEC5), Color(0xFFECEFF1))   //grayish blue to very light gray
            )
        }
        else -> {
            Brush.verticalGradient(
                colors = listOf(Color(0xFFB3E5FC), Color(0xFFE1F5FE))   // default
            )
        }
    }


}

@Composable
fun CurrentWeather(mainViewModel: MainViewModel) {

    val weather by mainViewModel.weather.collectAsState()

    val current = weather?.current

    if (current != null) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    getWeatherGradient(current.condition.text)
                )
                .padding(all = 16.dp)

        ) {
            //title of weather
            Text(
                text = current.condition.text,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Image(
                painter = rememberAsyncImagePainter("https:${current.condition.icon}"),
                contentDescription = "Weather Icon",
                modifier = Modifier
                    .size(120.dp)
            )
            Text(
                text = "Temp:${current.temperature} °C",
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Feels like: ${current.feelsLike} °C",
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center

            )
            Text(
                text = "Amount: ${current.precipitationAmount} mm",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Wind Speed: ${current.windSpeed}kph"+
                        "\nWind Direction: ${current.windDirection}",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )

        }
    }
}