package com.razzaghi.compose_loading_dots


import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * By Mahdi Razzaghi Ghaleh at 1/20/2023, check out my gitHub: https://github.com/razaghimahdi
 * */

/**
 * dotsCount: by define that, we choice how many dots we gonna show
 * dotsSize: by define that, we choice what size our dots gonna have
 * dotsColor: by define that, we choice what color our dots gonna have
 * */


@Composable
fun LoadingBiggy(
    modifier: Modifier = Modifier,
    dotsCount: Int = 3,
    dotsSize: Dp = 15.dp,
    dotsColor: Color = MaterialTheme.colors.primary,
    duration: Int = 750
) {

    Row(
        modifier = modifier
    ) {

        for (index in 1..dotsCount) {

            val startValue = dotsSize.value
            val endValue = (dotsSize.value)*1.5F

            val animSize = remember { Animatable(startValue) }

            LaunchedEffect(animSize) {
                delay(((duration / dotsCount) * index).toLong())
                launch {
                    animSize.animateTo(
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

            Dot(size = animSize.value.dp, color = dotsColor)
        }
    }


}
