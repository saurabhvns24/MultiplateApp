package com.resocoder.mvvmbasicstut.utilities

import com.resocoder.mvvmbasicstut.data.FakeDatabase
import com.resocoder.mvvmbasicstut.data.PhoneBookRepository
import com.resocoder.mvvmbasicstut.ui.quotes.PhoneBookViewModelFactory


object InjectorUtils {

    fun provideQuotesViewModelFactory(): PhoneBookViewModelFactory {
        val quoteRepository = PhoneBookRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return PhoneBookViewModelFactory(quoteRepository)
    }
}