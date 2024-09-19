package com.example.mymultiplateformapplication.android.di

import app.cash.sqldelight.db.SqlDriver
import com.example.mymultiplateformapp.db.MyMultiPlateformAppDB
import com.example.mymultiplateformapplication.db.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }
    single<MyMultiPlateformAppDB> {
        MyMultiPlateformAppDB(get())
    }
}