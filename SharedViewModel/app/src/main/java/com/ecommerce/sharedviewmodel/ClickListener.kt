package com.ecommerce.sharedviewmodel

interface ClickListener {
    companion object

    fun onClickItem(position: Int, updateFlag: Boolean)
}