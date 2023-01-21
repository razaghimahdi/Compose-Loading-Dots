package com.razzaghi.compose_loading_dots

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun Dot(
    size: Dp = 25.dp,
    color: Color = MaterialTheme.colors.primary,
    yOffset: ()->Float = { 0F }
) {

    Canvas(
        modifier = Modifier
            .padding(horizontal = 3.dp)
            .size(size = size)
            .offset(y = yOffset().dp)
    ) {
        drawCircle(
            color = color,
        )
    }

}
