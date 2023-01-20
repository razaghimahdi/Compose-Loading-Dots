package com.razzaghi.composeloaddots

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.razzaghi.composeloaddots.components.Dot
import com.razzaghi.composeloaddots.components.LoadingBiggy
import com.razzaghi.composeloaddots.components.LoadingFady
import com.razzaghi.composeloaddots.components.LoadingWavy
import com.razzaghi.composeloaddots.ui.theme.ComposeLoadDotsTheme

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