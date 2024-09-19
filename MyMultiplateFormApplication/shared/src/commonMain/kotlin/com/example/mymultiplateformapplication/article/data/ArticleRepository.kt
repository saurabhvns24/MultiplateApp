package com.example.mymultiplateformapplication.article.data

class ArticleRepository(
    private val dataSource: ArticleDataSource,
    private val articleService: ArticleService
) {
    suspend fun getArticles(forceFetch: Boolean): List<ArticleRaw> {
        if (forceFetch) {
            dataSource.deleteArticle()
            return fetchArticleOnline()
        }
        val articlesDb = dataSource.getAllArticles()
        if (articlesDb.isEmpty()) {
            return fetchArticleOnline()
        }
        return articlesDb
    }

    private suspend fun fetchArticleOnline(): List<ArticleRaw> {
        val fetchArticles = articleService.fetchArticle()
        dataSource.insertArticle(articles = fetchArticles)
        return fetchArticles
    }
}