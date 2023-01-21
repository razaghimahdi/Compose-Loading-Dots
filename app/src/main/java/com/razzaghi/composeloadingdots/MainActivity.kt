package com.razzaghi.composeloadingdots

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.razzaghi.compose_loading_dots.LoadingBiggy
import com.razzaghi.compose_loading_dots.LoadingFady
import com.razzaghi.compose_loading_dots.LoadingWavy
import com.razzaghi.composeloadingdots.ui.theme.ComposeLoadDotsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLoadDotsTheme {
                // A surface container using the 'background' color from the theme
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

        LoadingWavy(modifier = Modifier.padding(vertical = 8.dp))

        LoadingFady(modifier = Modifier.padding(vertical = 8.dp))

        LoadingBiggy(modifier = Modifier.padding(vertical = 8.dp))

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeLoadDotsTheme {
        SampleLoading()
    }
}