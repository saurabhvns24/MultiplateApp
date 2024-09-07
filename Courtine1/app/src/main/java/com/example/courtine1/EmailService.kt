package com.example.courtine1

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

private const val TAG = "EmailService"

interface NotificationService{
    fun send(to: String, from: String, body: String?)
}
@Singleton
class EmailService @Inject constructor() : NotificationService{
    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "send Email: $to $from $body")
    }
}

class MessageService @Inject constructor(var retryCount:Int) : NotificationService{
    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "send Message: $to $from $body retry count value $retryCount")
    }
}