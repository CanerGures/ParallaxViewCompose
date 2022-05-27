package com.example.parallaxdemo.customviews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.parallaxdemo.ui.theme.White

@Composable
fun Chip(
    textTitle: String,
    textNumber: String,
    bgColor: Color,
    titleColor: Color,
    textColor: Color,
    width: Dp,
    modifier: Modifier = Modifier
) {
    Box(

        modifier = modifier
            .width(width)
            .clip(
                RoundedCornerShape(
                    CornerSize(8.dp),
                    CornerSize(8.dp),
                    CornerSize(8.dp),
                    CornerSize(8.dp)
                )
            )
            .background(bgColor),
        contentAlignment = Alignment.Center

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = textTitle,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.caption,
                color = titleColor
            )
            Text(
                textNumber,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
                color = textColor,
                fontFamily = FontFamily.Default
            )
        }
    }
}

@Preview
@Composable
fun ChipPreview() {
    Chip("Guest", textNumber = "1", White, Color.Gray, width = 60.dp, textColor = Color.Black)
}