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

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun Dot(
    size: Dp = 25.dp,
    color: Color = MaterialTheme.colors.primary,
    yOffset: () -> Float = { 0F },
    xOffset: () -> Float = { 0F },
    alpha: () -> Float = { 1F }
) {

    Canvas(
        modifier = Modifier
            .padding(horizontal = 3.dp)
            .size(size = size)
            .offset(y = yOffset().dp, x = xOffset().dp)
            .alpha(alpha())
    ) {
        drawCircle(
            color = color,
        )
    }

}
