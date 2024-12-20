package com.example.jetpackcompose.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.jetpackcompose.model.Quote

@Composable
fun QuoteList(quotes: Array<Quote>, onClick: (quote: Quote) -> Unit) {
    LazyColumn(content = {
        items(quotes) { it ->
            QuoteListItem(quote = it) {
                onClick(it)
            }
        }
    })
}