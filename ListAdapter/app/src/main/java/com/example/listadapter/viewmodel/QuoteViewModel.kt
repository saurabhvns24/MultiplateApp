package com.example.listadapter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listadapter.model.QuoteList
import com.example.listadapter.repository.QuoteRepository
import kotlinx.coroutines.launch

class QuoteViewModel(private val repository: QuoteRepository) : ViewModel() {
    init {
        viewModelScope.launch {
            repository.getQuote(1)
        }
    }

    val quotes: LiveData<QuoteList>
        get() = repository.quotes
}