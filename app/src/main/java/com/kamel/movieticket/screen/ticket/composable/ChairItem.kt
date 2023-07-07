package com.kamel.movieticket.screen.ticket.composable

import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.res.painterResource
import com.kamel.movieticket.R
import com.kamel.movieticket.ui.theme.PrimaryLight

@Composable
fun ChairItem(
    chairState: ChairState,
    modifier: Modifier = Modifier,
    ocClickChair: (ChairState) -> Unit,
) {
    val tintColor = when (chairState) {
        ChairState.Available -> Color(0xDEFFFFFF)
        ChairState.Taken -> DarkGray
        ChairState.Selected -> PrimaryLight
    }

    val animatedTintColor by animateColorAsState(
        targetValue = tintColor,
        animationSpec = tween(200, easing = FastOutSlowInEasing), label = ""
    )

    Crossfade(
        targetState = chairState,
        animationSpec = tween(200, easing = FastOutSlowInEasing), label = "",
    ) { state ->
        IconButton(
            onClick = { ocClickChair(state) },
            modifier = modifier,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.chair),
                contentDescription = null,
                tint = animatedTintColor,
                modifier = modifier,
            )
        }
    }
}