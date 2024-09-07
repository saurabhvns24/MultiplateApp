package com.example.courtine1

import android.provider.ContactsContract
import android.util.Log
import javax.inject.Inject

private const val TAG = "UserRepository"

interface UserRepository {
    fun saveUser(email: String, password: String)
}

class SQLRepository @Inject constructor() : UserRepository {
    override fun saveUser(email: String, password: String) {
        Log.d(TAG, "saveUser in DB: $email $password")
    }
}

class FirebaseRepository @Inject constructor() : UserRepository {
    override fun saveUser(email: String, password: String) {
        Log.d(TAG, "saveUser in Firebase: $email $password")
    }
}