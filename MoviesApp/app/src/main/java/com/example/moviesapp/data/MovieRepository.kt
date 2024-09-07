package com.example.moviesapp.data

import com.example.moviesapp.common.Resource
import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.details.MovieDetail

class MovieRepository(private val dataSource: MovieDataSource) {
    suspend fun getMovieList(): Resource<List<Movie>> {
        return try {
            Resource.Success(data =dataSource.getMovieList().results)
        } catch (e: Exception) {
            Resource.Error(message = e.message.toString())
        }
    }
    suspend fun getMovieDetails(id:String): Resource<MovieDetail> {
        return try {
            Resource.Success(data =dataSource.getMovieDetails(id))
        } catch (e: Exception) {
            Resource.Error(message = e.message.toString())
        }
    }
}