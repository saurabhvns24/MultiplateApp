package com.example.moviesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.moviesapp.navigation.MovieNavigation
import com.example.moviesapp.ui.theme.MoviesAppTheme
import com.example.moviesapp.ui_layer.MovieListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val navController = rememberNavController()
    MovieNavigation(navController)
//    val show = remember {
//        mutableStateOf(false)
//    }
//    Button(onClick = { show.value = !show.value}) {
//        Text(text = "Please click here")
//    }
//    if (show.value){
//        MovieListScreen()
//    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MoviesAppTheme {
        Greeting("Android")
    }
}