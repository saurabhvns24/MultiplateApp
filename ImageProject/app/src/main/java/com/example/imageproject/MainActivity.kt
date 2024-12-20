package com.example.imageproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.imageproject.ui.theme.ImageProjectTheme
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val json = resources.openRawResource(R.raw.json_file).bufferedReader().use { it.readText() }

        val viewModel: ImageViewModel by viewModels()
        setContent {
            viewModel.loadImages(json)
            ImageGrid(viewModel)
           /* ImageProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }*/
        }
        val imageList = Gson().fromJson(json, Array<ImageData>::class.java).map {
            "${it.thumbnail.domain}/${it.thumbnail.basePath}/0/${it.thumbnail.key}"
        }
        prefetchImages(this, imageList)
    }
}

/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ImageProjectTheme {
        Greeting("Android")
    }
}*/
