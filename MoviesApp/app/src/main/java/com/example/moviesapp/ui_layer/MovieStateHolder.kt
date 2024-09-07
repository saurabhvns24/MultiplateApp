package com.example.moviesapp.ui_layer

import com.example.moviesapp.model.Movie

data class MovieStateHolder (val isLoading:Boolean = false,
                             val data: List<Movie>? = null,
                             val error:String = "")