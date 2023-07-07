package com.kamel.movieticket.screen.ticket.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kamel.movieticket.composable.SpacerHorizontal
import com.kamel.movieticket.ui.theme.PrimaryLight

@Composable
fun SelectedRadioItem(
    chairState: ChairState
) {
    val name = when (chairState) {
        ChairState.Available -> "Available"
        ChairState.Taken -> "Taken"
        ChairState.Selected -> "Selected"
    }
    val color = when (chairState) {
        ChairState.Available -> Color(0xDEFFFFFF)
        ChairState.Taken -> DarkGray
        ChairState.Selected -> PrimaryLight
    }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(12.dp)
                .clip(CircleShape)
                .background(color)
        )
        SpacerHorizontal(space = 8)
        Text(
            text = name,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Normal,
            color = Color(0x99FFFFFF),
            fontSize = 14.sp
        )
    }
}