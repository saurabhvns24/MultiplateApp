package com.example.mymultiplateformapplication.android.di

import com.example.mymultiplateformapplication.article.presentation.ArticleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ArticleViewModel(get()) }
}