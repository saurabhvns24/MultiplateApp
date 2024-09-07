package com.example.moviesapp.ui_layer.details

import com.example.moviesapp.model.details.MovieDetail

data class MovieDetailStateHolder(
    val isLoading: Boolean = false,
    val data: MovieDetail? = null,
    val error: String = ""
)
