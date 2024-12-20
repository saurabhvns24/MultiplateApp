package com.example.workmanagerpoc

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.system.measureTimeMillis

private const val TAG = "FlowCoroutine"

class FlowCoroutine : AppCompatActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalScope.launch(Dispatchers.Main) {
            producer()
                .flowOn(Dispatchers.IO)
                .collect {
                    delay(1500)
                    Log.d(TAG, "onCreate: $it ${Thread.currentThread().name}")
                }

        }
    }

    private fun producer() = flow<Int> {
//        withContext(Dispatchers.IO) {
        listOf(1, 2, 3, 4, 5, 6, 7).forEach {
            Log.d(TAG, "producer: $${Thread.currentThread().name}")
            delay(1000)
            emit(it)
        }
//        }
    }
}