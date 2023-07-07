package com.kamel.movieticket.screen.viewModel

import androidx.lifecycle.ViewModel
import com.kamel.movieticket.data.movies
import com.kamel.movieticket.domain.model.Movie
import com.kamel.movieticket.screen.state.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getMovies()
    }

    private fun getMovies() {
        _state.update {
            it.copy(
                movies = movies,
            )
        }
    }

    fun onSwipeMovie(movie: Movie) {
        _state.update {
            it.copy(
                blurImage = movie.imageDrawable,
                currentMovie = movie
            )
        }
    }

    fun onClickChip() {
        if (_state.value.isSelectedChip!!)
            _state.update {
                it.copy(
                    isSelectedChip = false,
                    movies = movies.shuffled(),
                )
            }
        else
            _state.update {
                it.copy(
                    isSelectedChip = true,
                    movies = movies.shuffled(),
                )
            }
    }
}