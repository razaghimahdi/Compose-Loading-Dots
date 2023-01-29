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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.razzaghi.compose_loading_dots.core.Dot
import com.razzaghi.compose_loading_dots.core.DotsLoadingController
import com.razzaghi.compose_loading_dots.core.DotsLoadingController.Companion.DEFAULT_CIRCLE_DOTS_COUNT
import com.razzaghi.compose_loading_dots.core.DotsLoadingController.Companion.END_FADE_VALUE
import com.razzaghi.compose_loading_dots.core.DotsLoadingController.Companion.START_FADE_VALUE
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LoadingCircleFady(
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

    controller.initCircleCordinate()

    val startValue = START_FADE_VALUE
    val endValue = END_FADE_VALUE

    val size = controller.calculateCircleLoadingSize(controller.selectedDotsSize.value)

    Box(
        modifier = modifier.size(size.dp),
        contentAlignment = Alignment.Center
    ) {


        for (index in 0 until DEFAULT_CIRCLE_DOTS_COUNT) {

            val animAlpha = remember { Animatable(startValue) }


            LaunchedEffect(controller) {
                delay(((controller.duration / DEFAULT_CIRCLE_DOTS_COUNT) * index).toLong())
                launch {
                    animAlpha.animateTo(
                        endValue,
                        animationSpec = infiniteRepeatable(
                            animation = tween(
                                durationMillis = controller.duration,
                                easing = controller.selectedEasing
                            ),
                            repeatMode = RepeatMode.Reverse,
                        ),
                    )
                }
            }

            Box(
                contentAlignment = Alignment.Center,
            ) {
                Dot(
                    size = controller.selectedDotsSize,
                    color = controller.selectedDotsColor,
                    alpha = { animAlpha.value },
                    yOffset = { controller.circleDotsYCor[index] },
                    xOffset = { controller.circleDotsXCor[index] },
                )
            }


        }

    }


}