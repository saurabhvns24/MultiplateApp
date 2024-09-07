package com.example.courtine1

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
 class UserRepositoryModule {

    @Provides
    fun getFirebaseRepository(firebaseRepository: FirebaseRepository) : UserRepository {
        return firebaseRepository
    }
    /*@Binds
    abstract fun getSQLRepository(sqlRepository: SQLRepository) :UserRepository*/

}