package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.example.weatherapp.MainViewModel
import com.example.weatherapp.R

@Composable
fun DailyForecast(mainViewModel: MainViewModel) {

    val weather by mainViewModel.weather.collectAsState()

    for(item in weather?.forecast!!) {

        Column(

            //Today
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
                .padding(10.dp)

        ) {
            Text(
                text = item.date,style = MaterialTheme.typography.titleLarge
            )
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.part_cloudy),
                    contentDescription = "Partly Cloudy Icon*"
                )

            }

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
            }
            Text(
                text = item.temperatureHigh,style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = item.temperatureLow,style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = item.precipitationType,style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = item.windDirection,style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = item.humidity,style = MaterialTheme.typography.titleMedium
            )
        }


        //Tomorrow
        Column(
            //Today
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()

        ) {
            Text(
                text = item.date,style = MaterialTheme.typography.titleLarge

            )
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Image(
                    painter = painterResource(id = R.drawable.sun),
                    contentDescription = "Sunny Icon*"
                )
            }
            Text(
                text = item.temperatureHigh,style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = item.temperatureLow,style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = item.precipitationType,style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = item.windDirection,style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = item.humidity,style = MaterialTheme.typography.titleMedium
            )
        }

        //Following Day
        Column(
            //Today
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Text(
                text = item.date,style = MaterialTheme.typography.titleLarge
            )
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.storm),
                    contentDescription = "Storm Icon*"
                )
            }
            Text(
                text = item.temperatureHigh,style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = item.temperatureLow,style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = item.precipitationType,style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = item.windDirection,style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = item.humidity,style = MaterialTheme.typography.titleMedium
            )
        }


    }
}








