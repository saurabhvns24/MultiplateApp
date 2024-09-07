package com.example.listadapter.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.listadapter.model.QuoteList
import com.example.listadapter.api.QuotesServiceAPI
import com.example.listadapter.db.QuoteDatabase

class QuoteRepository(
    private val quotesServiceAPI: QuotesServiceAPI, private val quoteDatabase: QuoteDatabase
) {
    private val quotesLiveData = MutableLiveData<QuoteList>()
    val quotes: LiveData<QuoteList>
        get() = quotesLiveData

    suspend fun getQuote(page: Int) {
        val quote = quotesServiceAPI.getQuote(page)
        if (quote.body() != null) {
            quotesLiveData.postValue(quote.body())
//            quoteDatabase.getQuoteDao().deleteQuote()
            quoteDatabase.getQuoteDao().addQuote(quote.body()!!.results)
        }
    }
}