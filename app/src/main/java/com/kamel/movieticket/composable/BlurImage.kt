package com.kamel.movieticket.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun BlurImage(
    imageDrawable: Int,
    modifier: Modifier = Modifier,
) {
    Image(
        painterResource(id = imageDrawable),
        contentDescription = null,
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.45f)
            .blur(20.dp),
        contentScale = ContentScale.FillBounds
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.45f)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Transparent,
                        Color(0x5EFFFFFF),
                        Color.Transparent,
                    )
                )
            )
    )
}