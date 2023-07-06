package com.kamel.movieticket.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kamel.movieticket.ui.theme.LightGray

@Composable
fun CardTag(tag: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .border(width = 0.1.dp, shape = CircleShape, color = LightGray)
            .padding(4.dp),
    ) {
        Text(
            text = tag,
            style = MaterialTheme.typography.titleSmall,
            fontSize = 14.sp,
            softWrap = true,
            fontWeight = MaterialTheme.typography.bodySmall.fontWeight,
            textAlign = TextAlign.Center,
            color = Color.Black,
            modifier = Modifier
                .background(Color.White)
                .padding(4.dp)
        )
    }
}