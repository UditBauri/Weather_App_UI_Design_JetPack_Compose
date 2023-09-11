package com.example.practice_ui_design

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice_ui_design.ui.theme.Practice_UI_DesignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherPage()
        }
    }
}

@Composable
fun WeatherPage(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, start = 16.dp, end = 16.dp)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.couple),
                contentDescription = null,
                modifier = Modifier
                    .width(250.dp)
                    .height(325.dp)
            )
            Column(
                modifier = Modifier
                    .padding(top = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "11°",
                    color = Color.Black,
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "New York City",
                    color = Color.DarkGray,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(top = 16.dp)
                )
                Text(
                    text = "Rainy to partly cloudy.\nWind WSW at 10 km/h to 15 km/h",
                    color = Color.Gray,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(vertical = 24.dp)
                )
            }
            // this code is for InfoTable to Add Information!
            Box(
                modifier = Modifier
                    .padding(10.dp)
            ){
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .background(Color.DarkGray)
                ){
                    Row (
                        modifier = Modifier
                            .padding(8.dp)
                    ){
                        InfoTable(
                            iconRes = R.drawable.humidity96,
                            title = "Humidity",
                            subtitle = "85%",
                            modifier = Modifier
                                .weight(1f)
                        )
                        InfoTable(
                            iconRes = R.drawable.sunrise,
                            title = "UV index",
                            subtitle = "78%",
                            modifier = Modifier
                                .weight(1f)
                        )
                    }
                    Divider(color = Color.White)
                    Row (
                        modifier = Modifier
                            .padding(8.dp)
                    ){
                        InfoTable(
                            iconRes = R.drawable.sunset,
                            title = "SunRise",
                            subtitle = "77%",
                            modifier = Modifier
                                .weight(1f)
                        )
                        InfoTable(
                            iconRes = R.drawable.sunset,
                            title = "SunSet",
                            subtitle = "72%",
                            modifier = Modifier
                                .weight(1f)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun InfoTable(
    @DrawableRes
    iconRes:Int,
    title:String,
    subtitle:String,
    modifier:Modifier
){
    Box(
        modifier = Modifier
            .padding(8.dp)
    ){
        Row (modifier = modifier){
            Image(painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .padding(end = 25.dp)
                    .width(28.dp)
            )
            Column {
                Text(
                    text = title,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = subtitle,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}