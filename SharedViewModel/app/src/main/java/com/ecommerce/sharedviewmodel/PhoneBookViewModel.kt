package com.resocoder.mvvmbasicstut.ui.quotes

import androidx.lifecycle.ViewModel
import com.ecommerce.sharedviewmodel.PhoneModel
import com.resocoder.mvvmbasicstut.data.PhoneBookRepository


class PhoneBookViewModel(private val phoneBookRepository: PhoneBookRepository) : ViewModel() {

    fun getQuotes() = phoneBookRepository.getQuotes()

    fun addQuote(quote: PhoneModel) = phoneBookRepository.addQuote(quote)

    fun update(position: Int, quote: PhoneModel) = phoneBookRepository.update(position, quote)

    fun updateFlagWithPosition(position: Int, updateFlag: Boolean) =
        phoneBookRepository.updateFlagWithPosition(position, updateFlag)

    fun getFlag() = phoneBookRepository.getFlag()

    fun getPosition() = phoneBookRepository.getPosition()

}