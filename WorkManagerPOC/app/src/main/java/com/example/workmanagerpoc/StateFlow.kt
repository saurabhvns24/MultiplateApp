package com.example.workmanagerpoc

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

private const val TAG = "StateFlow"

class StateFlow : AppCompatActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalScope.launch(Dispatchers.Main) {
            val result = producer()
            delay(8000)
            result.collect {
                Log.d(TAG, "onCreate2: $it")
            }

        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    /*private fun producer(): Flow<Int> {
        val mutableSharedFlow = MutableSharedFlow<Int>()
        GlobalScope.launch {
            listOf(1, 2, 3, 4, 5, 6, 7).forEach {
                Log.d(TAG, "producer: $it")
                mutableSharedFlow.emit(it)
                delay(1000)
            }
        }
        return mutableSharedFlow
    }*/
    private fun producer(): Flow<Int> {
        val mutableStateFlow = MutableStateFlow<Int>(0)
        GlobalScope.launch {
            delay(2000)
            mutableStateFlow.emit(20)
            delay(2000)
            mutableStateFlow.emit(30)
            delay(2000)
            mutableStateFlow.emit(40)
        }
        return mutableStateFlow
    }
}