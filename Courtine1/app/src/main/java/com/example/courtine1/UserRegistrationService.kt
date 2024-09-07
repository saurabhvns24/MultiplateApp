package com.example.courtine1

import android.provider.ContactsContract
import javax.inject.Inject

class UserRegistrationService @Inject constructor(
    private val userRepository: UserRepository,
    @MessageQualifier
    private val notificationService: NotificationService
) {
    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        notificationService.send(email, "noreply@gmail.com", "You successful register")
    }
}

/*
* Unit Testing
* Lifetime of these objects
* Single Responsibility
* Extensible
*/