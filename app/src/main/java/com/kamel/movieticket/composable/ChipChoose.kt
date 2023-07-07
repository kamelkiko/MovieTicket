package com.kamel.movieticket.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kamel.movieticket.ui.theme.Orange

@Composable
fun ChipChoose(
    tag: String,
    modifier: Modifier = Modifier,
    background: Color = Color.Transparent,
    onClickChip: () -> Unit,
    isSelectedChip: Boolean,
) {
    Card(
        modifier = if (isSelectedChip) modifier.modifierWithoutBorder() else modifier.modifierWithBorder(),
        shape = RoundedCornerShape(64.dp),
        colors = if (isSelectedChip) CardDefaults.cardColors(containerColor = Orange) else CardDefaults.cardColors(
            containerColor = background
        ),
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
                .clickable(
                    onClick = onClickChip,
                    enabled = !isSelectedChip,
                ).padding(6.dp)
        )
    }
}

@Stable
private fun Modifier.modifierWithBorder(): Modifier {
    return this
        .then(
            Modifier
                .width(126.dp)
                .height(32.dp)
                .border(0.1.dp, Color.White, shape = CircleShape),
        )
}

@Stable
private fun Modifier.modifierWithoutBorder(): Modifier {
    return this
        .then(
            Modifier
                .width(126.dp)
                .height(32.dp),
        )
}