package com.example.workmanagerpoc

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

private const val TAG = "FlowsActivity"

class FlowsActivity : AppCompatActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_flows)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        /* GlobalScope.launch {
             val data: Flow<Int> = producer()
             data.collect{
 //                Log.d(TAG, "onCreate: ${it}")
             }
         }*/
        /* val job = GlobalScope.launch {
             val data: Flow<Int> = producer()
             data.collect {
                 Log.d(TAG, "onCreate: $it")
             }
         }
         GlobalScope.launch {
             delay(3500)
             job.cancel()
         }*/
//        Multiple consumer
        /*   GlobalScope.launch {
               val data: Flow<Int> = producer()
               data.collect {
                   Log.d(TAG, "onCreate1: $it")
               }
           }
           GlobalScope.launch {
               val data: Flow<Int> = producer()
               data.collect {
                   delay(2000)
                   Log.d(TAG, "onCreate2: $it")
               }
           }
           GlobalScope.launch {
               val data: Flow<Int> = producer()
               data.collect {
                   delay(2500)
                   Log.d(TAG, "onCreate3: $it")
               }
           }*/
        // Event function (onStart,onCompletion,onEach
        /*GlobalScope.launch {
            val data: Flow<Int> = producer()
            data.onStart {
                Log.d(TAG, "onCreate: Starting out.")
            }.onCompletion {
                Log.d(TAG, "onCreate: Completion done.")
            }.onEach {
                Log.d(TAG, "onCreate: Value emit - $it")
            }.collect {
                Log.d(TAG, "onCreate: $it")
            }
        }*/
        // operator in flow .map{}, .filter{}

        GlobalScope.launch {
            val time = measureTimeMillis {
                producer()
                    .buffer(capacity = 1)// to make execution fast.
                    .collect {
                        delay(1500)
                        Log.d(TAG, "onCreate: $it")
                    }
            }
            Log.d(TAG, "onCreate: Measure time - $time")
        }
    }

    private fun producer() = flow<Int> {
        listOf(1, 2, 3, 4, 5, 6, 7).forEach {
//            Log.d(TAG, "producer: $it")
            delay(1000)
            emit(it)
        }
    }
}