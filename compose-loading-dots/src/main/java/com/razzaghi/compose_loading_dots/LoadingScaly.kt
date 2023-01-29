/*
 * Copyright (C) 2022 razaghimahdi (Mahdi Razzaghi Ghaleh)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.razzaghi.compose_loading_dots


import android.util.Log
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.razzaghi.compose_loading_dots.core.Dot
import com.razzaghi.compose_loading_dots.core.DotsLoadingController
import com.razzaghi.compose_loading_dots.core.LoadingStatus
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch



@Composable
fun LoadingScaly(
    controller: DotsLoadingController,
    modifier: Modifier = Modifier,
    dotsCount: Int? = null,
    dotsSize: Dp? = null,
    dotsColor: Color? = null,
    duration: Int? = null,
    easing: Easing? = null
) {

    if (easing != null) {
        controller.updateSelectedEasing(easing)
    }
    if (dotsCount != null) {
        controller.updateSelectedDotsCount(dotsCount)
    }
    if (dotsSize != null) {
        controller.updateSelectedDotsSize(dotsSize)
    }
    if (dotsColor != null) {
        controller.updateSelectedDotsColor(dotsColor)
    }
    if (duration != null) {
        controller.updateSelectedDotsDuration(duration)
    }


    val size = controller.calculateScalyLoadingSize(controller.selectedDotsSize.value)


    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        for (index in 0 until controller.selectedDotsCount) {

            val startValue = controller.selectedDotsSize.value
            val endValue = 0F

            val animSize = remember { Animatable(startValue) }

            LaunchedEffect(animSize) {
                delay(((controller.duration / controller.selectedDotsCount) * index).toLong())
                launch {
                    animSize.animateTo(
                        endValue,
                        animationSpec = infiniteRepeatable(
                            animation = tween(
                                durationMillis = controller.duration,
                                easing = controller.selectedEasing
                            ), repeatMode = RepeatMode.Reverse
                        ),
                    )

                }
            }



            Box(
                modifier = Modifier.size((size / 2).dp),
                contentAlignment = Alignment.Center
            ) {
                Dot(size = animSize.value.dp, color = controller.selectedDotsColor)
            }


        }
    }

}
