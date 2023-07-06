package com.kamel.movieticket.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.kamel.movieticket.R

@Composable
fun PosterImage(modifier: Modifier = Modifier, painter: Painter, contentDescription: String) {
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds,
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewPosterImage() {
    PosterImage(
        painter = painterResource(id = R.drawable.poster_movie),
        contentDescription = ""
    )
}