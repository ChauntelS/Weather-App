package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import kotlinx.coroutines.sync.Mutex

@Preview
@Composable
fun DailyForecast(){


    Column(

        //Today
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(80.dp)

    ) {
        Text(
            text = "Today's Forecast"
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
            Text(text = "Partly Cloudy")
        }
        Text(
            text = "14°C"
        )
        Text(
            text = "N/A"
        )
        Text(
            text = "Wind 19 km/h NE"
        )
    }

    //Location
    Column (verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Cyan)
            .padding(10.dp)

    ){
        Text(text = "Weather for Halifax, N.S")
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
            text = "Tomorrow's Forecast"
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
            text = "Sunny"
        )
        Text(
            text = "25°C"
        )
        Text(
            text = "N/A"
        )
        Text(
            text = "Wind 3 km/h SW"
        )
    }

    //Following Day
    Column(
        //Today
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(80.dp)
    ) {
        Text(
            text = "Following Day"
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
            text = "Thunder & Lightning"
        )
        Text(
            text = "18°C"
        )
        Text(
            text = "60-75 mm of rainfall"
        )
        Text(
            text = "Wind 3 km/h SW"
        )
    }


    }









