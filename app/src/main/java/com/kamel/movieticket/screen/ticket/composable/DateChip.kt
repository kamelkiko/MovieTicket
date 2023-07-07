package com.kamel.movieticket.screen.ticket.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kamel.movieticket.composable.Chip
import com.kamel.movieticket.screen.ticket.Day
import com.kamel.movieticket.ui.theme.Black87
import com.kamel.movieticket.ui.theme.DarkGray
import com.kamel.movieticket.ui.theme.LightGray

@Composable
fun DateChip(
    day: Day,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    doWhenSelect: (Day) -> Unit
) {
    Chip(
        text = day.dayNumber.toString(),
        isSelected = isSelected,
        unSelectedTextColor = Black87,
        backgroundColors = listOf(DarkGray, LightGray),
        borderColor = Color(0x14000000),
        modifier = modifier.padding(horizontal = 8.dp),
        doWhenClick = {
            doWhenSelect(day)
        }
    ) {
        Text(
            text = day.dayName,
            color = Color(0x61000000),
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Normal,
            fontSize = 11.sp
        )
    }
}