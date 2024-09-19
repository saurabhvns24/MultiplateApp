package com.example.mymultiplateformapplication.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.mymultiplateformapp.db.MyMultiPlateformAppDB

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver =
        AndroidSqliteDriver(
            schema = MyMultiPlateformAppDB.Schema,
            context = context,
            name = "MyMultiPlateformApp.DB.db"
        )

}