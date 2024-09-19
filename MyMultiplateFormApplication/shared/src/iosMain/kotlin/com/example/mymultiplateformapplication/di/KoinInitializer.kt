package com.example.mymultiplateformapplication.di

import com.example.mymultiplateformapplication.article.presentation.ArticleViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin() {
    val module = sharedKoinModule + databaseModule
    startKoin { modules(module) }
}

class ArticleInjector : KoinComponent {
    val articleViewModel: ArticleViewModel by inject()
}