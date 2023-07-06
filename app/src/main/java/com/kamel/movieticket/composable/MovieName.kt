package com.kamel.movieticket.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MovieName(movieName: String) {
    Text(
        text = movieName,
        style = MaterialTheme.typography.titleMedium,
        fontSize = 24.sp,
        softWrap = true,
        color = Color.Black,
        lineHeight = 32.sp,
        fontWeight = MaterialTheme.typography.bodyMedium.fontWeight,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(horizontal = 30.dp),
    )
}