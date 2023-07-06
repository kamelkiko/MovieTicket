package com.kamel.movieticket.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kamel.movieticket.R

@Composable
fun CardTime(
    modifier: Modifier = Modifier,
    painter: Painter,
    contentDescription: String,
    time: String,
) {
    Card(
        modifier = modifier
            .background(Color.DarkGray, shape = RoundedCornerShape(32.dp))
            .clip(shape = RoundedCornerShape(32.dp)),
        elevation = CardDefaults.cardElevation(0.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray
        )
    ) {
        Row(
            modifier = Modifier
                .width(112.dp)
                .height(32.dp)
                .fillMaxWidth()
                .background(Color.DarkGray)
                .clip(shape = RoundedCornerShape(32.dp)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Icon(
                modifier = Modifier
                    .size(24.dp)
                    .alpha(0.6f),
                painter = painter,
                contentDescription = contentDescription,
                tint = Color.White
            )
            Text(
                text = time,
                style = TextStyle(
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                ),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewCardTime() {
    CardTime(
        painter = painterResource(id = R.drawable.clock),
        contentDescription = "",
        time = "2h 23m"
    )
}