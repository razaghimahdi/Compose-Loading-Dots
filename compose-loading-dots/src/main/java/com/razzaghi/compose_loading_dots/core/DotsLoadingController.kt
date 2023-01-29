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

package com.razzaghi.compose_loading_dots.core

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


/** Creates and remembers a [DotsLoadingController] on the current composer. */
@Composable
fun rememberDotsLoadingController(): DotsLoadingController {
    return remember { DotsLoadingController() }
}


class DotsLoadingController {


    private var _loadingStatus: MutableState<LoadingStatus> =
        mutableStateOf(LoadingStatus.READY_TO_REFERSH)
    internal val loadingStatus get() = _loadingStatus.value

    private var _circleDotsXCor: MutableState<FloatArray> = mutableStateOf(floatArrayOf())
    internal val circleDotsXCor get() = _circleDotsXCor.value

    private var _circleDotsYCor: MutableState<FloatArray> = mutableStateOf(floatArrayOf())
    internal val circleDotsYCor get() = _circleDotsYCor.value

    private var _selectedEasing: MutableState<Easing> = mutableStateOf(LinearEasing)
    internal val selectedEasing get() = _selectedEasing.value

    private var _selectedDotsCount: MutableState<Int> = mutableStateOf(3)
    internal val selectedDotsCount get() = _selectedDotsCount.value

    private var _selectedDotsSize: MutableState<Dp> = mutableStateOf(15.dp)
    internal val selectedDotsSize get() = _selectedDotsSize.value

    private var _selectedDotsColor: MutableState<Color> = mutableStateOf(Color.Blue)
    internal val selectedDotsColor get() = _selectedDotsColor.value

    private var _duration: MutableState<Int> = mutableStateOf(500)
    internal val duration get() = _duration.value


    internal fun updateLoadingStatus(value: LoadingStatus) {
        _loadingStatus.value = value
    }

    fun updateSelectedEasing(value: Easing) {
        _selectedEasing.value = value
    }

    fun updateSelectedDotsCount(value: Int) {
        _selectedDotsCount.value = value
    }

    fun updateSelectedDotsSize(value: Dp) {
        _selectedDotsSize.value = value
    }

    fun updateSelectedDotsColor(value: Color) {
        _selectedDotsColor.value = value
    }

    fun updateSelectedDotsDuration(value: Int) {
        _duration.value = value
    }

    internal fun calculateCircleLoadingSize(size: Float): Float {
        return if (size >= 10) {
            size * 4
        } else {
            size * (size)
        }
    }

    internal fun calculateBiggyLoadingSize(size: Float): Float {
        return if (size >= 10) {
            size * 2
        } else {
            size * (size / 2)
        }
    }

    internal fun calculateScalyLoadingSize(size: Float): Float {
        return if (size > 10) {
            size * 2
        } else if(size==10F) {
            size * (size/3)
        }else {
            size * (size)
        }
    }

    internal fun calculateWavyLoadingSize(size: Float): Float {
        return if (size >= 10) {
            size * 1.5F
        } else {
            size * (size / 2)
        }
    }

    internal fun initCircleCordinate() {
        _circleDotsXCor.value = FloatArray(DEFAULT_CIRCLE_DOTS_COUNT)
        _circleDotsYCor.value = FloatArray(DEFAULT_CIRCLE_DOTS_COUNT)
        val sin45Radius: Float = SIN_45 * (DEFAULT_CIRCLE_DOTS_COUNT * (selectedDotsSize.value / 5))

        for (i in 0 until DEFAULT_CIRCLE_DOTS_COUNT) {
            _circleDotsYCor.value[i] = 0F
            _circleDotsXCor.value[i] = circleDotsYCor[i]
        }

        _circleDotsXCor.value[1] = circleDotsXCor[1] + sin45Radius
        _circleDotsXCor.value[2] =
            circleDotsXCor[2] + DEFAULT_CIRCLE_DOTS_COUNT * (selectedDotsSize.value / 5)
        _circleDotsXCor.value[3] = circleDotsXCor[3] + sin45Radius

        _circleDotsXCor.value[5] = circleDotsXCor[5] - sin45Radius
        _circleDotsXCor.value[6] =
            circleDotsXCor[6] - DEFAULT_CIRCLE_DOTS_COUNT * (selectedDotsSize.value / 5)
        _circleDotsXCor.value[7] = circleDotsXCor[7] - sin45Radius

        _circleDotsYCor.value[0] =
            circleDotsYCor[0] - DEFAULT_CIRCLE_DOTS_COUNT * (selectedDotsSize.value / 5)
        _circleDotsYCor.value[1] = circleDotsYCor[1] - sin45Radius
        _circleDotsYCor.value[3] = circleDotsYCor[3] + sin45Radius

        _circleDotsYCor.value[4] =
            circleDotsYCor[4] + DEFAULT_CIRCLE_DOTS_COUNT * (selectedDotsSize.value / 5)
        _circleDotsYCor.value[5] = circleDotsYCor[5] + sin45Radius
        _circleDotsYCor.value[7] = circleDotsYCor[7] - sin45Radius
    }

    companion object {
        internal const val SIN_45 = 0.7071F
        internal const val DEFAULT_CIRCLE_DOTS_COUNT = 8
        internal const val START_FADE_VALUE = 1.0f
        internal const val END_FADE_VALUE = 0.2f
    }

}