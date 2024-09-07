package com.resocoder.mvvmbasicstut.data

import com.ecommerce.sharedviewmodel.PhoneModel


class PhoneBookRepository private constructor(private val dao: FakePhoneBookDao) {

    fun addQuote(quote: PhoneModel) {
        dao.addQuote(quote)
    }

    fun getQuotes() = dao.getQuotes()

    fun update(position: Int, quote: PhoneModel) = dao.update(position, quote)

    fun updateFlagWithPosition(position: Int, updateFlag: Boolean) = dao.updateFlagWithPosition(position, updateFlag)

    fun getPosition() = dao.getPosition()

    fun getFlag() = dao.getFlag()

    companion object {
        @Volatile
        private var instance: PhoneBookRepository? = null

        fun getInstance(quoteDao: FakePhoneBookDao) =
            instance ?: synchronized(this) {
                instance ?: PhoneBookRepository(quoteDao).also { instance = it }
            }
    }
}