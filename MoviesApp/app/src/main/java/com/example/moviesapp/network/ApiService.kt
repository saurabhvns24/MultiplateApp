package com.example.moviesapp.network

import com.example.moviesapp.model.MoviesListResponse
import com.example.moviesapp.model.details.MovieDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("3/movie/popular")
    suspend fun getMovieList(@Query("api_key") apiKey: String): MoviesListResponse

    @GET("3/movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") id: String,
        @Query("api_key") apiKey: String
    ): MovieDetail
}