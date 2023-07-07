package com.kamel.movieticket.screen.state

import com.kamel.movieticket.domain.model.Movie

data class DetailsUiState(
    val movie: Movie = Movie(),
)
