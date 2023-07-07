package com.kamel.movieticket.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kamel.movieticket.R
import com.kamel.movieticket.composable.CardTime
import com.kamel.movieticket.composable.ChipChoose
import com.kamel.movieticket.composable.GenericChips
import com.kamel.movieticket.composable.MovieCard
import com.kamel.movieticket.composable.MovieName
import com.kamel.movieticket.composable.SpacerHorizontal
import com.kamel.movieticket.composable.SpacerVertical
import com.kamel.movieticket.ui.theme.Black87

@Composable
fun HomeScreen(navHostController: NavHostController) {
    HomeContent(navHostController = navHostController)
}

@Composable
private fun HomeContent(navHostController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Image(
            painterResource(id = R.drawable.movie_2),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.45f)
                .blur(20.dp),
            contentScale = ContentScale.FillBounds
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.45f)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Transparent,
                            Color(0x5EFFFFFF),
                        )
                    )
                )
        )
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 32.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                ChipChoose(tag = "Now Streaming")
                SpacerHorizontal(space = 8)
                ChipChoose(tag = "Coming Soon")
            }
            SpacerVertical(space = 16)
            MovieCard()
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.38f)
                .align(alignment = Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CardTime(
                painter = painterResource(id = R.drawable.clock),
                contentDescription = stringResource(
                    id = R.string.time
                ),
                time = "2h 23m",
                backgroundColor = Color.Transparent,
                color = Black87,
            )
            SpacerVertical(space = 8)
            MovieName("Fantastic Beats: The Secrets of Dumbledore")
            SpacerVertical(space = 32)
            GenericChips()
        }
    }
}