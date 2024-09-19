package com.example.mymultiplateformapplication.android.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mymultiplateformapplication.Platform

@Composable
fun AboutScreen(onUpButtonClick: () -> Unit) {
    Column {
        Toolbar(onUpButtonClick)
        ContentView()
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(onUpButtonClick: () -> Unit) {
    TopAppBar(title = { Text(text = "About Screen") }, navigationIcon = {
        IconButton(onClick = onUpButtonClick) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Up button"
            )
        }
    })
}

@Composable
fun ContentView() {
    val items = makeItems()
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items) {
            RowView(title = it.first, subtitle = it.second)
        }
    }
}

@Composable
fun RowView(title: String, subtitle: String) {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = title, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
            Text(text = subtitle, style = MaterialTheme.typography.bodyLarge)
        }
        HorizontalDivider()
    }
}

fun makeItems(): List<Pair<String, String>> {
    val platForm = Platform()
    platForm.logSystemInfo()
    return listOf(
        Pair("Operating System", platForm.osName),
        Pair("Operating System Version", platForm.osVersion),
        Pair("Device Model", platForm.deviceModel),
        Pair("Density", platForm.density.toString())
    )
}

