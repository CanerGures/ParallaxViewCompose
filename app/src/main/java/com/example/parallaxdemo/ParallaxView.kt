package com.example.parallaxdemo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp


@Composable
fun ParallaxView(
    modifier: Modifier = Modifier,
    depthMultiplier: Int = 20,
    data: SensorData?
) {
    val roll by derivedStateOf { (data?.roll ?: 0f) * depthMultiplier }
    val pitch by derivedStateOf { (data?.pitch ?: 0f) * depthMultiplier }

    Box(modifier = modifier) {
        // Glow Shadow
        // Has quicker offset change and in opposite direction to the Image Card
        BackgroundImage(roll, pitch, this)
        // Edge (used to give depth to card when tilted)
        // Has slightly slower offset change than Image Card
        BlurredBox(roll, pitch, this)
        // Image Card
        // The image inside has a parallax shift in the opposite direction
        ContentImage(roll, pitch, this)
    }
}


@Composable
fun BackgroundImage(roll: Float, pitch: Float, boxScope: BoxScope) {
    boxScope.apply {
        Image(
            painter = painterResource(id = R.drawable.beach3),
            modifier = Modifier
                .offset {
                    IntOffset(
                        x = -(roll * 1.5).dp.roundToPx(),
                        y = (pitch * 2).dp.roundToPx()
                    )
                }
                .width(256.dp)
                .height(356.dp)
                .align(Alignment.Center)
                .blur(radius = 24.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
        )
    }
}

@Composable
fun BlurredBox(roll: Float, pitch: Float, boxScope: BoxScope) {
    boxScope.apply {
        Box(
            modifier = Modifier
                .offset {
                    IntOffset(
                        x = (roll * 0.9).dp.roundToPx(),
                        y = -(pitch * 0.9).dp.roundToPx()
                    )
                }
                .width(300.dp)
                .height(400.dp)
                .align(Alignment.Center)
                .background(
                    color = Color.White.copy(alpha = 0.3f),
                    shape = RoundedCornerShape(16.dp)
                ),
        )
    }
}

@Composable
fun ContentImage(roll: Float, pitch: Float, boxScope: BoxScope) {
    boxScope.apply {
        Image(
            painter = painterResource(id = R.drawable.beach3),
            modifier = Modifier
                .offset {
                    IntOffset(
                        x = roll.dp.roundToPx(),
                        y = -pitch.dp.roundToPx()
                    )
                }
                .width(300.dp)
                .height(400.dp)
                .align(Alignment.Center)
                .clip(RoundedCornerShape(16.dp)),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            alignment = BiasAlignment(
                horizontalBias = (roll * 0.005).toFloat(),
                verticalBias = 0f,
            )
        )
    }
}