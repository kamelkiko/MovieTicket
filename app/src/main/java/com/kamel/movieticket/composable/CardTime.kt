package com.kamel.movieticket.composable

import androidx.compose.foundation.background
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
import com.kamel.movieticket.ui.theme.TimeBackground

@Composable
fun CardTime(
    modifier: Modifier = Modifier,
    painter: Painter,
    contentDescription: String,
    time: String,
    backgroundColor: Color = TimeBackground,
) {
    Card(
        modifier = modifier
            .background(backgroundColor, shape = RoundedCornerShape(32.dp))
            .clip(shape = RoundedCornerShape(32.dp)),
        elevation = CardDefaults.cardElevation(0.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        )
    ) {
        Row(
            modifier = Modifier
                .width(88.dp)
                .height(32.dp)
                .fillMaxWidth()
                .background(backgroundColor)
                .clip(shape = RoundedCornerShape(32.dp)),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            SpacerHorizontal(space = 8)
            Icon(
                modifier = Modifier
                    .size(16.dp)
                    .alpha(0.6f),
                painter = painter,
                contentDescription = contentDescription,
                tint = Color.White
            )
            SpacerHorizontal(space = 6)
            Text(
                text = time,
                style = TextStyle(
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.W500,
                    fontSize = 14.sp,
                ),
                modifier = Modifier.alpha(0.80f)
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