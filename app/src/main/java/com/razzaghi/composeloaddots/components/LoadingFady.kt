package com.razzaghi.composeloaddots.components

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.razzaghi.composeloaddots.ui.theme.ComposeLoadDotsTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * By Mahdi Razzaghi Ghaleh at 1/20/2023, check out my gitHub: https://github.com/razaghimahdi
 * */

/**
 * dotsCount: by define that, we choice how many dots we gonna show
 * dotsSize: by define that, we choice what size our dots gonna have
 * selectedDotsColor: by define that, we choice what selected color our dots gonna have
 * unSelectedDotsColor: by define that, we choice what un selected color our dots gonna have
 * */


@Composable
fun LoadingFady(
    modifier: Modifier = Modifier,
    dotsCount: Int = 3,
    dotsSize: Dp = 15.dp,
    selectedDotsColor: Color = MaterialTheme.colors.primary,
    unSelectedDotsColor: Color = MaterialTheme.colors.onPrimary,
    duration: Int = 750
) {

    Row(
        modifier = modifier
    ) {

        for (index in 1..dotsCount) {

            val startValue = selectedDotsColor
            val endValue = unSelectedDotsColor

            val animColor = remember { Animatable(startValue) }

            LaunchedEffect(animColor) {
                delay(((duration / dotsCount) * index).toLong())
                launch {
                    animColor.animateTo(
                      endValue  ,
                        animationSpec = infiniteRepeatable(
                            animation = tween(
                                durationMillis = duration,
                                easing = LinearEasing
                            ), repeatMode = RepeatMode.Reverse
                        ),
                    )
                }
            }

            Dot(size = dotsSize, color = animColor.value)
        }
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultLoadingFadyPreview() {
    ComposeLoadDotsTheme {
        LoadingFady()
    }
}