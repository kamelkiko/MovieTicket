package com.kamel.movieticket.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ActorItem(image: Int) {
    Image(
        modifier = Modifier
            .size(64.dp)
            .clip(shape = CircleShape),
        painter = painterResource(id = image),
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )

}