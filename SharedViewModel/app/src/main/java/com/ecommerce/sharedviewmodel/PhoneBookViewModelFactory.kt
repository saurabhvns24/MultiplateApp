package com.resocoder.mvvmbasicstut.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.resocoder.mvvmbasicstut.data.PhoneBookRepository


class PhoneBookViewModelFactory(private val quoteRepository: PhoneBookRepository)
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PhoneBookViewModel(quoteRepository) as T
    }
}