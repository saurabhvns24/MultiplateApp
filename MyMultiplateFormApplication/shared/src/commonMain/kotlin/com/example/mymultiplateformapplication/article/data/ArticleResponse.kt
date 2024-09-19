package com.example.mymultiplateformapplication.article.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleResponse(
    @SerialName("status")
    val status: String,
    @SerialName("totalResults")
    val result: Int,
    @SerialName("articles")
    val articles: List<ArticleRaw>
)