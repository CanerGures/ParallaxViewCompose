package com.example.parallaxdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parallaxdemo.customviews.Chip
import com.example.parallaxdemo.customviews.DateChipView
import com.example.parallaxdemo.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ParallaxDemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ParallaxDemoTheme {
        MainScreen()
    }
}

@Composable
fun MainScreen() {

    Column {
        Column(
            modifier = Modifier
                .padding(top = 50.dp)
        ) {
            ParallaxScreen()
        }
        Column(modifier = Modifier.padding(top = 42.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            CornerSize(18.dp),
                            CornerSize(18.dp),
                            CornerSize(18.dp),
                            CornerSize(18.dp)
                        )
                    )
                    .background(Gray)
            ) {
                Column(modifier = Modifier) {
                    Box(
                        modifier = Modifier
                            .height(100.dp)
                            .clip(
                                RoundedCornerShape(
                                    CornerSize(18.dp),
                                    CornerSize(18.dp),
                                    CornerSize(18.dp),
                                    CornerSize(18.dp)
                                )
                            )
                            .background(White),
                        contentAlignment = Alignment.Center,

                        ) {
                        Row {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Puerto Rico Private Island",
                                    modifier = Modifier.padding(start = 16.dp),
                                    style = MaterialTheme.typography.h1
                                )
                                Row(
                                    modifier = Modifier
                                        .padding(top = 12.dp),
                                    horizontalArrangement = Arrangement.End,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .height(40.dp)
                                            .width(64.dp)
                                            .clip(
                                                RoundedCornerShape(
                                                    CornerSize(8.dp),
                                                    CornerSize(8.dp),
                                                    CornerSize(8.dp),
                                                    CornerSize(8.dp)
                                                )
                                            )
                                            .background(orangeBg),
                                        contentAlignment = Alignment.Center

                                    ) {
                                        Row {
                                            Image(
                                                painter = painterResource(id = R.drawable.ic_baseline_star_24),
                                                "",
                                                modifier = Modifier
                                                    .padding(start = 8.dp)
                                                    .height(24.dp)
                                                    .width(24.dp)
                                            )
                                            Text(
                                                text = "4.9",
                                                textAlign = TextAlign.Start,
                                                modifier = Modifier.padding(
                                                    start = 6.dp,
                                                    end = 6.dp,
                                                    bottom = 4.dp,
                                                    top = 4.dp
                                                ),
                                                style = MaterialTheme.typography.caption,
                                                color = White
                                            )
                                        }
                                    }
                                    Text(
                                        text = "(420 Reviews)",
                                        modifier = Modifier.padding(start = 16.dp),
                                        textAlign = TextAlign.Start
                                    )
                                }
                            }

                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "$ 145",
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.SemiBold,
                                    style = MaterialTheme.typography.body2,
                                    color = orangeBg
                                )
                                Text(
                                    text = "/ per night",
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.Normal,
                                    style = MaterialTheme.typography.body1
                                )
                            }
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        DateChipView(Modifier)
                        Chip(
                            textTitle = "Guest",
                            textNumber = "3",
                            bgColor = White,
                            titleColor = Color.Gray,
                            textColor = Black,
                            width = 60.dp
                        )
                        Chip(
                            textTitle = "Room",
                            textNumber = "1",
                            bgColor = White,
                            titleColor = Color.Gray,
                            textColor = Black,
                            width = 60.dp
                        )
                    }
                    Card(
                        backgroundColor = Blue, modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .padding(top = 3.dp)
                            .clip(
                                RoundedCornerShape(
                                    CornerSize(12.dp),
                                    CornerSize(12.dp),
                                    CornerSize(12.dp),
                                    CornerSize(12.dp)
                                )
                            )
                            .padding(16.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = "Book Now", color = White)
                        }
                    }
                }
            }
        }
    }
}