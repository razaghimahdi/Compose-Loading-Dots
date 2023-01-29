package com.razzaghi.composeloadingdots

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.razzaghi.compose_loading_dots.*
import com.razzaghi.compose_loading_dots.core.rememberDotsLoadingController
import com.razzaghi.composeloadingdots.ui.theme.ComposeLoadDotsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLoadDotsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    SampleLoading()


                }
            }
        }
    }

}

@Composable
fun SampleLoading() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val rememberDotsLoadingWavyController = rememberDotsLoadingController()
        val rememberDotsLoadingFadyController = rememberDotsLoadingController()
        val rememberDotsLoadingBiggyController = rememberDotsLoadingController()
        val rememberLoadingScalyController = rememberDotsLoadingController()
        val rememberLoadingDancingController = rememberDotsLoadingController()
        val rememberLoadingCircleFadyController = rememberDotsLoadingController()


        LoadingWavy(
            controller = rememberDotsLoadingWavyController,
            modifier = Modifier.padding(vertical = 8.dp),
        )

        LoadingFady(
            controller = rememberDotsLoadingFadyController,
            modifier = Modifier.padding(vertical = 8.dp),
        )

        LoadingBiggy(
            controller = rememberDotsLoadingBiggyController,
            modifier = Modifier.padding(vertical = 8.dp),
        )

        LoadingScaly(
            controller = rememberLoadingScalyController,
            modifier = Modifier.padding(vertical = 8.dp,),
        )

        LoadingDancing(
            controller = rememberLoadingDancingController,
            modifier = Modifier.padding(vertical = 8.dp),
        )

        LoadingCircleFady(
            controller = rememberLoadingCircleFadyController,
            modifier = Modifier.padding(vertical = 8.dp),
        )


    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeLoadDotsTheme {
        SampleLoading()
    }
}