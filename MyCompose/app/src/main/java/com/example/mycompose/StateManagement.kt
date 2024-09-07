package com.example.mycompose

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun StateManagement() {
    var user = ""
    var state = remember {
        mutableStateOf("")
    }

    TextField(value = state.value, onValueChange = {
        state.value = it
    })
}