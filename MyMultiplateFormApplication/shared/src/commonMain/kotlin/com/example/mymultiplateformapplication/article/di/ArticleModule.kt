package com.example.mymultiplateformapplication.article.di

import com.example.mymultiplateformapplication.article.data.ArticleDataSource
import com.example.mymultiplateformapplication.article.data.ArticleRepository
import com.example.mymultiplateformapplication.article.data.ArticleService
import com.example.mymultiplateformapplication.article.application.ArticleUseCase
import com.example.mymultiplateformapplication.article.presentation.ArticleViewModel
import org.koin.dsl.module

val articleModule = module {
    single<ArticleService> {
        ArticleService(get())
    }
    single<ArticleUseCase> {
        ArticleUseCase(get())
    }
    single<ArticleViewModel> {
        ArticleViewModel(get())
    }
    single<ArticleDataSource> {
        ArticleDataSource(get())
    }
    single<ArticleRepository> {
        ArticleRepository(get(), get())
    }
}