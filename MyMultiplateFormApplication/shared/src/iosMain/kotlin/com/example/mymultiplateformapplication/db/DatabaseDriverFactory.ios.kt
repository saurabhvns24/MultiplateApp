@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package com.example.mymultiplateformapplication.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.example.mymultiplateformapp.db.MyMultiPlateformAppDB

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver =
        NativeSqliteDriver(
            schema = MyMultiPlateformAppDB.Schema,
            name = "MyMultiPlateformApp.DB.db"
        )

}