package com.example.workmanagerpoc

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

private const val TAG = "ChannelsActivity"

class ChannelsActivity : AppCompatActivity() {
    private val channel = Channel<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_channels)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        producer()
        consumer()
    }

    private fun producer() {
        CoroutineScope(Dispatchers.Main).launch {
            channel.send(3)
            channel.send(4)
            channel.send(1)
            channel.send(2)
        }
    }

    private fun consumer() {
        CoroutineScope(Dispatchers.Main).launch {
            Log.d(TAG, "consumer: ${channel.receive()}")
            Log.d(TAG, "consumer: ${channel.receive()}")
            Log.d(TAG, "consumer: ${channel.receive()}")

//            channel.receive()
//            channel.receive()
        }
    }
}