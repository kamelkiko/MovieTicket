package com.kamel.movieticket.screen.ticket.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kamel.movieticket.R
import com.kamel.movieticket.ui.theme.PrimaryLight

@Composable
fun PairChairs(
    pair: Pair<ChairState, ChairState>,
    modifier: Modifier = Modifier,
    size: Int = 75,
    currentPrice: Double,
    currentCount: Int,
    onClickChar: (Double, Int) -> Unit,
    onClickCharSelected: (Double, Int) -> Unit,
) {
    var pairState by remember {
        mutableStateOf(pair)
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.chair_container),
            contentDescription = "",
            modifier = Modifier.size((size * 2 + 38).dp),
            tint = if ((pairState.first == pairState.second) && (pairState.second == ChairState.Selected)) {
                PrimaryLight.copy(alpha = 0.38f)
            } else if ((pairState.first == pairState.second) && (pairState.second == ChairState.Taken)) {
                DarkGray.copy(alpha = 0.2f)
            } else {
                DarkGray.copy(alpha = 0.6f)
            }
        )
        Row(
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            ChairItem(chairState = pairState.first, modifier = Modifier.size(size.dp)) {
                pairState = pairState.copy(first = it.nextState())
                if (pairState.first == ChairState.Selected)
                    onClickChar(currentPrice, currentCount)
                if (pairState.first == ChairState.Available)
                    onClickCharSelected(currentPrice, currentCount)
            }
            ChairItem(chairState = pairState.second, modifier = Modifier.size(size.dp)) {
                pairState = pairState.copy(second = it.nextState())
                if (pairState.second == ChairState.Selected)
                    onClickChar(currentPrice, currentCount)
                if (pairState.second == ChairState.Available)
                    onClickCharSelected(currentPrice, currentCount)
            }
        }
    }
}