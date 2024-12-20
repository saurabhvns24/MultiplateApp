package com.example.moviesapp.ui_layer

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.moviesapp.model.Movie
import com.example.moviesapp.navigation.MovieNavigationItem

public const val TAG = "MovieListScreen"

@Composable
fun MovieListScreen(navController: NavController, viewModel: MovieViewModel = hiltViewModel()) {
    val result = viewModel.movieList.value
    if (result.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
    if (result.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = result.error)
        }
    }
    result.data?.let {
        LazyColumn() {
            items(result.data) {
                MovieItem(it) {
                    navController.navigate(MovieNavigationItem.MovieDetails.route+"/${it}")
                }
            }
        }
    }
}

@Composable
fun MovieItem(it: Movie, onClick: (String) -> Unit) {
    AsyncImage(
        model = "https://image.tmdb.org/t/p/w500/${it.poster_path}", contentDescription = "",
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .padding(vertical = 4.dp)
            .clickable { onClick.invoke(it.id.toString()) }, contentScale = ContentScale.Crop
    )
}
