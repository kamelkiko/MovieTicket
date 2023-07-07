package com.kamel.movieticket.screen.ticket.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.kamel.movieticket.composable.Chip
import com.kamel.movieticket.ui.theme.Black87
import com.kamel.movieticket.ui.theme.DarkGray
import com.kamel.movieticket.ui.theme.LightGray

@Composable
fun HourChip(
    hour: String,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    doWhenSelectHour: (String) -> Unit,
) {
    Chip(
        text = hour,
        isSelected = isSelected,
        unSelectedTextColor = Black87,
        backgroundColors = listOf(DarkGray, LightGray),
        borderColor = Color(0x14000000),
        modifier = modifier,
        doWhenClick = {
            doWhenSelectHour(hour)
        }
    )
}