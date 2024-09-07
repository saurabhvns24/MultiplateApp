package com.example.courtine1

import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NotificationServiceModule::class, UserRepositoryModule::class])
interface UserRegistrationComponent {

    fun injection(mainActivity: MainActivity)

 /*   @Component.Factory
    interface Factory {
        fun create(@BindsInstance retryCount: Int): UserRepositoryModule
    }
*/
}