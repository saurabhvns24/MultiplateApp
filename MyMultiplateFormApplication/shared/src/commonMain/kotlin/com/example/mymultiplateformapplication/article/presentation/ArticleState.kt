package com.example.mymultiplateformapplication.article.presentation

import com.example.mymultiplateformapplication.article.application.Article

data class ArticleState(
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null,
)



