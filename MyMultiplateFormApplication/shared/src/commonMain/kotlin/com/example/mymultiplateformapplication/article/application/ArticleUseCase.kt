package com.example.mymultiplateformapplication.article.application

import com.example.mymultiplateformapplication.article.data.ArticleRaw
import com.example.mymultiplateformapplication.article.data.ArticleRepository
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs

class ArticleUseCase(private val articleRepository: ArticleRepository) {
    suspend fun getArticles(reload:Boolean): List<Article> {
        val articleRaw = articleRepository.getArticles(forceFetch = reload)
        return mapArticle(articleRaw)
    }

    private fun mapArticle(articleRaw: List<ArticleRaw>): List<Article> = articleRaw.map {
        Article(
            title = it.title,
            description = it.description ?: "Click to find out more",
            date = getDaysAgoText(date = it.date),
            imageUrl = it.imageUrl ?: ""
        )
    }

    private fun getDaysAgoText(date: String): String {
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val days = today.daysUntil(
            Instant.parse(date).toLocalDateTime(TimeZone.currentSystemDefault()).date
        )
        val result = when {
            abs(days) > 1 -> "${abs(days)} days ago"
            abs(days) == 1 -> "yesterday"
            else -> "today"
        }
        return result
    }
}