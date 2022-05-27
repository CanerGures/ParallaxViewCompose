package com.example.parallaxdemo.customviews

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parallaxdemo.ui.theme.White
import com.example.parallaxdemo.R

@Composable
fun DateChipView(
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = modifier
                .width(80.dp)
                .height(62.dp)
                .clip(
                    RoundedCornerShape(
                        CornerSize(8.dp),
                        CornerSize(0.dp),
                        CornerSize(0.dp),
                        CornerSize(8.dp)
                    )
                )
                .background(White),
            contentAlignment = Alignment.Center

        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Check-in",
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(8.dp),
                    style = MaterialTheme.typography.caption,
                    color = Color.Gray
                )
                Text(
                    "30 Aug",
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
                    color = Color.Black,
                    fontFamily = FontFamily.Default
                )
            }
        }
        Box(
            modifier = modifier
                .width(20.dp)
                .height(62.dp)
                .background(White),
            contentAlignment = Alignment.Center

        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_forward),
                    "",
                    modifier = Modifier
                        .height(12.dp)
                        .width(12.dp)
                )
            }
        }
        Box(
            modifier = modifier
                .width(80.dp)
                .height(62.dp)
                .clip(
                    RoundedCornerShape(
                        CornerSize(0.dp),
                        CornerSize(8.dp),
                        CornerSize(8.dp),
                        CornerSize(0.dp)
                    )
                )
                .background(White),
            contentAlignment = Alignment.Center

        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Check-out",
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(8.dp),
                    style = MaterialTheme.typography.caption,
                    color = Color.Gray
                )
                Text(
                    "15 Sep",
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
                    color = Color.Black,
                    fontFamily = FontFamily.Default
                )
            }
        }
    }
}

@Preview
@Composable
fun DateChipViewPreview() {
    DateChipView()
}