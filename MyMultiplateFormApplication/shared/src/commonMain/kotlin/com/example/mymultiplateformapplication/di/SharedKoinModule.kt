package com.example.mymultiplateformapplication.di

import com.example.mymultiplateformapplication.article.di.articleModule

val sharedKoinModule = listOf(
    articleModule,
    networkModule
)