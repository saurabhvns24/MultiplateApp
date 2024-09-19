package com.example.mymultiplateformapplication.article.presentation

import com.example.mymultiplateformapplication.BaseViewModel
import com.example.mymultiplateformapplication.article.application.ArticleUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticleViewModel(private val useCase: ArticleUseCase) : BaseViewModel() {

    private val _articleState: MutableStateFlow<ArticleState> =
        MutableStateFlow(ArticleState(loading = true))

    val articleState: StateFlow<ArticleState> get() = _articleState


    init {
        getArticle()
    }

    fun getArticle(reload: Boolean = false) {
        scope.launch {
            _articleState.emit(
                ArticleState(
                    loading = true,
                    articles = _articleState.value.articles
                )
            )
            val fetchArticles = useCase.getArticles(reload = reload)
            _articleState.emit(ArticleState(articles = fetchArticles))
        }
    }

}