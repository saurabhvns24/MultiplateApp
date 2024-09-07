package com.example.listadapter.api

import com.example.listadapter.model.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesServiceAPI {
    @GET("/quotes")
    suspend fun getQuote(@Query("page") page: Int): Response<QuoteList>
}