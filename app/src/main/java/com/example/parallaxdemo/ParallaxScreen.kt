package com.example.parallaxdemo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.parallaxdemo.ParallaxView
import com.example.parallaxdemo.SensorData
import com.example.parallaxdemo.SensorDataManager
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

@Composable
fun ParallaxScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    var data by remember { mutableStateOf<SensorData?>(null) }

    DisposableEffect(Unit) {
        val dataManager = SensorDataManager(context)
        dataManager.init()

        val job = scope.launch {
            dataManager.data
                .receiveAsFlow()
                .onEach { data = it }.collect()
        }

        onDispose {
            dataManager.cancel()
            job.cancel()
        }
    }

    Box(modifier = modifier) {
        ParallaxView(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            depthMultiplier = 20,
            data = data
        )
    }
}