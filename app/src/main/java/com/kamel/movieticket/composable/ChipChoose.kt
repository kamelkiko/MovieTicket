package com.kamel.movieticket.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChipChoose(tag: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .width(126.dp)
            .height(32.dp)
            .border(0.2.dp, Color.White, shape = CircleShape)
            .padding(4.dp),
        shape = RoundedCornerShape(64.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
    ) {
        Text(
            text = tag,
            style = MaterialTheme.typography.titleMedium,
            fontSize = 13.sp,
            fontWeight = MaterialTheme.typography.bodyMedium.fontWeight,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
        )
    }
}