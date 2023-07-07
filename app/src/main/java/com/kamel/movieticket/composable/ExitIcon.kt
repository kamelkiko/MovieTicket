package com.kamel.movieticket.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kamel.movieticket.R
import com.kamel.movieticket.ui.theme.BlurExitColor

@Composable
fun ExitIcon(
    modifier: Modifier = Modifier,
    iconColor: Color = Color.White,
    backgroundColor: Color = BlurExitColor,
    onCLick: () -> Unit,
) {
    Box(
        modifier = modifier
            .size(40.dp)
            .background(color = backgroundColor, shape = CircleShape)
            .clickable(onClick = onCLick),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            modifier = Modifier
                .border(width = 2.dp, shape = CircleShape, color = Color.White)
                .size(24.dp)
                .padding(4.dp),
            imageVector = Icons.Rounded.Clear,
            contentDescription = stringResource(id = R.string.close),
            tint = iconColor,
        )
    }
}