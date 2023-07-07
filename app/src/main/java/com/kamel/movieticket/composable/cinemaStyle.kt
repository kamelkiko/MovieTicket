package com.kamel.movieticket.composable

import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.graphicsLayer

@Stable
fun Modifier.cinemaStyle(clipRatio: Float = 0.8f, rotationX: Float = -35f): Modifier {
    return then(
        Modifier
            .drawWithContent {
                val path = Path().apply {
                    val yRatio = 0.25f
                    moveTo(0f, size.height * yRatio)
                    lineTo(0f, size.height)
                    quadraticBezierTo(
                        size.width / 2,
                        size.height * clipRatio,
                        size.width,
                        size.height
                    )
                    lineTo(size.width, size.height * yRatio)
                    quadraticBezierTo(
                        size.width / 2,
                        0f,
                        0f,
                        size.height * yRatio,
                    )
                }
                clipPath(path = path) {
                    this@drawWithContent.drawContent()
                }
            }
            .graphicsLayer { this.rotationX = rotationX }
    )
}