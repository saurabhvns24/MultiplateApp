package com.example.courtine1

import dagger.Module
import dagger.Provides

@Module
class NotificationServiceModule (private val retry:Int ){
    @MessageQualifier
    @Provides
    fun getMessageService():NotificationService{
        return MessageService(retry)
    }

    @EmailQualifier
    @Provides
    fun getEmailService(emailService: EmailService):NotificationService{
        return emailService
    }
}