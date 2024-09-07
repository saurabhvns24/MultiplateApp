package com.example.moviesapp.data

import com.example.moviesapp.network.ApiService


class MovieDataSource(private val apiService: ApiService) {
    suspend fun getMovieList() =
        apiService.getMovieList(apiKey = "98f9399ec2c8af3c5a719b3fa990c122")

    suspend fun getMovieDetails(id: String) =
        apiService.getMovieDetails(id = id, apiKey = "98f9399ec2c8af3c5a719b3fa990c122")
}