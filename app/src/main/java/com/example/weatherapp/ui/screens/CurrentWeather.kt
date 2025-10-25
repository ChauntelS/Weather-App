package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.weatherapp.MainViewModel
import com.example.weatherapp.R



@Composable
fun CurrentWeather(mainViewModel: MainViewModel) {

    val weather by mainViewModel.weather.collectAsState()

    val current = weather?.current

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(all = 16.dp)

    ) {
        //title of weather
        Text(
            text = current?.condition.toString(),
            style = MaterialTheme.typography.titleLarge
        )

        Image(
            painter = rememberAsyncImagePainter("https:${current?.condition.icon}"),
            contentScale = "Weather Icon",
            modifier = Modifier
                .size(120.dp)
        )
        Text(
            text = "${current?.temp_c} °C",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = "Precipitation: ${current?.precip_mm} mm",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "Wind: ${current?.wind_kph} kph ${current?.wind_dir}",
            style = MaterialTheme.typography.bodyMedium
        )


    }
}
