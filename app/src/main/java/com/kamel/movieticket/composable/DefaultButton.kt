package com.kamel.movieticket.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kamel.movieticket.ui.theme.Orange

@Composable
fun DefaultButton(
    title: String,
    modifier: Modifier = Modifier,
    icon: Painter,
    contentDescription: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .width(160.dp)
            .height(64.dp)
            .padding(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Orange
        )
    ) {
        Row {
            Icon(
                painter = icon,
                contentDescription = contentDescription,
                modifier = Modifier.size(24.dp),
                tint = Color.White,
            )
            SpacerHorizontal(space = 8)
            Text(
                text = title,
                style = MaterialTheme.typography.bodySmall.copy(
                    color = Color.White,
                    fontSize = 16.sp
                ),
            )
        }

    }
}