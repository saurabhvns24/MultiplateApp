package com.example.moviesapp.ui_layer.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.common.Resource
import com.example.moviesapp.data.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {
    val movieDetail = mutableStateOf(MovieDetailStateHolder())

    init {
        movieDetail.value = MovieDetailStateHolder(isLoading = true)
        viewModelScope.launch {
            savedStateHandle.getStateFlow("id", "0").collectLatest {
                getMovieDetail(it)
            }
        }
    }

    private fun getMovieDetail(id: String) = viewModelScope.launch {
        when (val result = movieRepository.getMovieDetails(id)) {
            is Resource.Error -> {
                movieDetail.value = MovieDetailStateHolder(error = result.message.toString())
            }

            is Resource.Success -> {
                movieDetail.value = MovieDetailStateHolder(data = result.data)
            }

            else -> {}
        }
    }
}