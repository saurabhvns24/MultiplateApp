package com.example.mymultiplateformapplication.di

import app.cash.sqldelight.db.SqlDriver
import com.example.mymultiplateformapp.db.MyMultiPlateformAppDB
import com.example.mymultiplateformapplication.db.DatabaseDriverFactory
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory().createDriver() }

    single<MyMultiPlateformAppDB> { MyMultiPlateformAppDB(get()) }
}