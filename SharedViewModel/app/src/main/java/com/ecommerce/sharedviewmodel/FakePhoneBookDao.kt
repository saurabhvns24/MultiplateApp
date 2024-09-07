package com.resocoder.mvvmbasicstut.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ecommerce.sharedviewmodel.PhoneModel


class FakePhoneBookDao {
    private val quoteList = mutableListOf<PhoneModel>()
    private val quotes = MutableLiveData<List<PhoneModel>>()
    private val mutablePosition = MutableLiveData<Int>()
    private val mutableUpdateFlag = MutableLiveData<Boolean>()

    init {
        quotes.value = quoteList
    }

    fun addQuote(quote: PhoneModel) {
        quoteList.add(quote)
        quotes.value = quoteList
    }

    fun getQuotes() = quotes as LiveData<MutableList<PhoneModel>>

    fun update(position: Int, quote: PhoneModel) {
        quoteList.removeAt(position)
        quoteList.add(position, quote)
        quotes.value = quoteList
    }

    fun updateFlagWithPosition(position: Int, updateFlag: Boolean) {
        mutablePosition.value = position
        mutableUpdateFlag.value = updateFlag
    }

    fun getPosition() = mutablePosition

    fun getFlag() = mutableUpdateFlag
}