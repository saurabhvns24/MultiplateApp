package com.example.mymultiplateformapplication.article.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticleService(private val httpClient: HttpClient) {
    private val country = "us"
    private val category = "Business"
    private val apiKey = "3af60d14f471400aad6289a2f14e7e7d"

    suspend fun fetchArticle(): List<ArticleRaw> {
        val response: ArticleResponse =
            httpClient.get("https://newsapi.org/v2/top-headlines?country=${country}&category=${category}&apiKey=${apiKey}")
                .body()
        return response.articles
    }
}