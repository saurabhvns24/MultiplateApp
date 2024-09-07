package com.example.moviesapp.di

import com.example.moviesapp.data.MovieDataSource
import com.example.moviesapp.data.MovieRepository
import com.example.moviesapp.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideDataSource(apiService: ApiService): MovieDataSource {
        return MovieDataSource(apiService)
    }

    @Provides
    fun provideMovieDataSource(dataSource: MovieDataSource): MovieRepository {
        return MovieRepository(dataSource)
    }
}