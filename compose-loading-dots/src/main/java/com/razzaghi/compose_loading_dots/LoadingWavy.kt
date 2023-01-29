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

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.razzaghi.compose_loading_dots.core.Dot
import com.razzaghi.compose_loading_dots.core.DotsLoadingController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


 


@Composable
fun LoadingWavy(
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

    val size = controller.calculateWavyLoadingSize(controller.selectedDotsSize.value)

    Row(
        modifier = modifier,
    ) {

        for (index in 1..controller.selectedDotsCount) {

            val startValue = controller.selectedDotsSize.value / 3
            val endValue = -controller.selectedDotsSize.value / 3

            val yPosition = remember { Animatable(startValue) }

            LaunchedEffect(yPosition) {
                delay(((controller.duration / controller.selectedDotsCount) * index).toLong())
                launch {
                    yPosition.animateTo(
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
                modifier = Modifier.size(size.dp),
                contentAlignment = Alignment.Center
            ) {
                Dot(
                    size = controller.selectedDotsSize,
                    color = controller.selectedDotsColor,
                    yOffset = { yPosition.value }
                )
            }
        }
    }


}
