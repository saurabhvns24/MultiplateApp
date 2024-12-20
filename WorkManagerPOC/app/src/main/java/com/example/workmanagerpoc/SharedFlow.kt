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
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

private const val TAG = "SharedFlow"

class SharedFlow : AppCompatActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalScope.launch(Dispatchers.Main) {
            producer()
                .collect {
                    Log.d(TAG, "onCreate1: $it")
                }

        }
        GlobalScope.launch(Dispatchers.Main) {
            producer()
                .collect {
                    delay(2500)
                    Log.d(TAG, "onCreate2: $it")
                }

        }
    }

    /* private fun producer() = flow<Int> {
         listOf(1, 2, 3, 4, 5, 6, 7).forEach {
             delay(1000)
             emit(it)
         }
     }*/
//    @OptIn(DelicateCoroutinesApi::class)
    private fun producer(): Flow<Int> {
        val mutableSharedFlow = MutableSharedFlow<Int>()
        GlobalScope.launch {
            listOf(1, 2, 3, 4, 5, 6, 7).forEach {
                mutableSharedFlow.emit(it)
                delay(1000)
            }
        }
        return mutableSharedFlow
    }

}