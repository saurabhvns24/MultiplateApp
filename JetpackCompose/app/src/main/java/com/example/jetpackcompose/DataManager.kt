package com.example.jetpackcompose

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.jetpackcompose.model.Quote
import com.google.gson.Gson

object DataManager {
    var currentPage = mutableStateOf(Pages.LISTING)
    var data = emptyArray<Quote>()
    var isDataLoaded = mutableStateOf(value = false)
    var currentQuote: Quote? = null
    fun loadAssetFromFile(context: Context) {
        val inputStream = context.assets.open("quote.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
        isDataLoaded.value = true
    }

    fun switchPages(quote: Quote?) {
        if (currentPage.value == Pages.LISTING) {
            currentQuote = quote
            currentPage.value = Pages.DETAIL
        } else {
            currentPage.value = Pages.LISTING
        }
    }
}