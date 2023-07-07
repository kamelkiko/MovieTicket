package com.kamel.movieticket.screen.state

import com.kamel.movieticket.R
import com.kamel.movieticket.domain.model.Movie

data class HomeUiState(
    val movies: List<Movie> = emptyList(),
    val blurImage: Int = R.drawable.movie_2,
    val isSelectedChip: Boolean = true,
    val currentMovie: Movie = Movie(),
)
