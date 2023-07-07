package com.kamel.movieticket.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import com.kamel.movieticket.domain.model.Movie
import com.kamel.movieticket.screen.home.HomeUiState
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MovieCard(
    state: HomeUiState,
    onSwipe: (Movie) -> Unit,
    onClickCard: (Int) -> Unit,
) {
    val pagerState = rememberPagerState(initialPage = 1)
    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            count = state.movies.size,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 80.dp),
            modifier = Modifier
                .height(350.dp)
                .fillMaxWidth(),
        ) { page ->
            onSwipe(state.movies[pagerState.currentPage])
            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .graphicsLayer {
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
                    .clickable { onClickCard(state.movies[pagerState.currentPage].id!!) }
            ) {
                Image(
                    painter = painterResource(id = state.movies[page].imageDrawable!!),
                    contentDescription = stringResource(
                        id = R.string.poster_movie
                    )
                )
            }
        }
    }
}
