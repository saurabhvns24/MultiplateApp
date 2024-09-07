package com.example.listadapter

import android.app.Application
import com.example.listadapter.api.QuotesServiceAPI
import com.example.listadapter.api.RetrofitHelper
import com.example.listadapter.db.QuoteDatabase
import com.example.listadapter.repository.QuoteRepository

class QuoteApplication : Application() {
    lateinit var repository: QuoteRepository
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quotesServiceAPI = RetrofitHelper.getInstance().create(QuotesServiceAPI::class.java)
        val quoteDatabase = QuoteDatabase.getDatabase(applicationContext)
        repository = QuoteRepository(quotesServiceAPI, quoteDatabase)
    }
}