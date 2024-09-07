package com.ecommerce.sharedviewmodel

import androidx.fragment.app.Fragment

interface Communicator {
    fun switchBetweenFragment(fragment: Fragment)
}