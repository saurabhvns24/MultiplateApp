package com.example.hiltandroid

import android.util.Log
import javax.inject.Inject

private const val TAG = "UserRepository"

interface UserRepository {
    fun saveUser(userName: String, password: String)
}

class SQLRepository @Inject constructor() : UserRepository {
    override fun saveUser(userName: String, password: String) {
        Log.d(TAG, "saveUser in DB: UserName = $userName password = $password")
    }
}

class FirebaseRepository : UserRepository {
    override fun saveUser(userName: String, password: String) {
        Log.d(TAG, "saveUser in Firebase: UserName = $userName password = $password")
    }
}