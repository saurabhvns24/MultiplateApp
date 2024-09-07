package com.example.hiltandroid

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class UserApplication : Application() {
    @Inject

    override fun onCreate() {
        super.onCreate()
    }
}