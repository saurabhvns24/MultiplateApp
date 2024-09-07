package com.example.dagger2

import javax.inject.Inject

class UserRegistrationService @Inject constructor(
    private val userRepository: UserRepository,
    private val emailService: EmailService
) {
    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        emailService.sendEmail(email, "no_reply@gmail.com", "User register successful")
    }
}

/*
* Unit Testing
* Single Responsibility
* LifeTime of these objects
* Extensible
* */