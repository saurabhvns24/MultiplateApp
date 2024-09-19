package com.example.mymultiplateformapplication.android

import android.app.Application
import com.example.mymultiplateformapplication.android.di.databaseModule
import com.example.mymultiplateformapplication.android.di.viewModelModule
import com.example.mymultiplateformapplication.di.sharedKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyMultiplateFormApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val module = sharedKoinModule + viewModelModule + databaseModule
        startKoin {
            androidContext(this@MyMultiplateFormApplication)
            modules(module)
        }
    }
}