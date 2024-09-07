package com.example.courtine1

import android.app.Application

class MyApplication: Application() {
    lateinit var userRegistrationComponent: UserRegistrationComponent
    override fun onCreate() {
        super.onCreate()
        userRegistrationComponent = DaggerUserRegistrationComponent.builder().
        notificationServiceModule(NotificationServiceModule(4)).build()
    }
}