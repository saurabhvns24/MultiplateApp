package com.example.mymultiplateformapplication.article.data

import com.example.mymultiplateformapp.db.MyMultiPlateformAppDB

class ArticleDataSource(private val dataBase: MyMultiPlateformAppDB) {
    fun getAllArticles(): List<ArticleRaw> =
        dataBase.myMultiPlateformAppDBQueries.selectAllArticle(::mapToArticleRaw).executeAsList()

    fun insertArticle(articles: List<ArticleRaw>) {
        dataBase.myMultiPlateformAppDBQueries.transaction {
            articles.forEach { articleRaw ->
                insertArticle(articleRaw)
            }
        }
    }

    fun deleteArticle() = dataBase.myMultiPlateformAppDBQueries.removeAllArticle()

    private fun insertArticle(articles: ArticleRaw) {
        dataBase.myMultiPlateformAppDBQueries.insertArticle(
            title = articles.title,
            desc = articles.description,
            date = articles.date,
            imageUrl = articles.imageUrl
        )
    }

    private fun mapToArticleRaw(
        title: String,
        desc: String?,
        date: String,
        imageUrl: String?
    ): ArticleRaw = ArticleRaw(title = title, description = desc, date = date, imageUrl = imageUrl)
}