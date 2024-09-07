package com.example.moviesapp.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moviesapp.ui_layer.MovieListScreen
import com.example.moviesapp.ui_layer.details.MovieDetailsScreen

private const val TAG = "MovieNavigation"
@Composable
fun MovieNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = MovieNavigationItem.MovieList.route) {
        composable(MovieNavigationItem.MovieList.route) {
            MovieListScreen(navController)
        }
        composable(MovieNavigationItem.MovieDetails.route + "/{id}") {
            val id = it.arguments?.getString("id")
            Log.d(TAG, "MovieNavigation: ${id}")
            MovieDetailsScreen()
        }
    }
}