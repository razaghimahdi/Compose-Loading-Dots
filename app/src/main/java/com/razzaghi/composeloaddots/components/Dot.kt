package com.razzaghi.composeloaddots.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.razzaghi.composeloaddots.ui.theme.ComposeLoadDotsTheme


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


@Preview(showBackground = true)
@Composable
fun DefaultDotPreview() {
    ComposeLoadDotsTheme {
        Dot()
    }
}