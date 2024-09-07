package com.example.listadapter.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.listadapter.model.Result

@Dao
interface QuoteDAO {
    @Insert
    suspend fun addQuote(quotes: List<Result>)

    @Query("SELECT * FROM quote")
    suspend fun getQuote(): List<Result>

//    @Delete
//    suspend fun deleteQuote()

}