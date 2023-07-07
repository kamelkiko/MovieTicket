package com.kamel.movieticket.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import com.kamel.movieticket.R
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun MovieCard() {
    val pagerState = rememberPagerState(initialPage = 1)
    val moviesList = listOf(
        R.drawable.movie_1,
        R.drawable.movie_2,
        R.drawable.movie_3,
    )
    Column(modifier = Modifier.fillMaxSize()) {

        HorizontalPager(
            count = 3,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 80.dp),
            modifier = Modifier
                .height(350.dp)
                .fillMaxWidth(),
        ) { page ->
            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.graphicsLayer {
                    val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
                    lerp(
                        start = 0.90f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = scale
                        scaleY = scale
                    }
                    alpha = lerp(
                        start = 1f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                }
            ) {
                Image(
                    painter = painterResource(id = moviesList[page]),
                    contentDescription = stringResource(
                        id = R.string.poster_movie
                    )
                )
            }
        }
    }
}
