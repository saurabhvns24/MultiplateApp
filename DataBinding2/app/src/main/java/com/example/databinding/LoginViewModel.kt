package com.example.databinding

import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.textfield.TextInputLayout

class LoginViewModel : ViewModel() {
    var oneWayDataBindingText: MutableLiveData<User>? = null
    var userMutableLiveData: MutableLiveData<User>? = null
    var errorPassword = MutableLiveData<String>()
    var errorEmail = MutableLiveData<String>()
    var counter = MutableLiveData<String>()

    // var errorTextview = MutableLiveData<String>()
    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    var textview = MutableLiveData("Thara")
    var busy: MutableLiveData<Int>? = null

    @JvmName("getBusy1")
    fun getBusy(): MutableLiveData<Int>? {
        if (busy == null) {
            busy = MutableLiveData()
            busy!!.value = 2
        }
        return busy
    }

    fun getUser(): MutableLiveData<User>? {
        if (userMutableLiveData == null) {
            userMutableLiveData = MutableLiveData()
        }
        return userMutableLiveData
    }

    class ConfirmHandler {
        fun verifyText(inputLayout: TextInputLayout) {
            inputLayout.error =
                if (TextUtils.isEmpty(inputLayout.editText!!.text)) "EMPTY TEXT" else ""
        }
    }

    /* fun onDisplayValueClick() {
    getBusy()?.getValue()
    val user = User(email.value, password.value, textview.value)
    if (!user.isTextviewLenthLesserThan4())
        errorTextview.getValue()
    else {
        errorTextview.getValue()
    }
}*/
    fun onLoginClicked() {
        getBusy()?.setValue(0)
        val user = User(email.value, password.value, textview.value)
        if (!user.isEmailValid()) {
            errorEmail.setValue("Enter a valid email address")
        } else if (!user.isPasswordLengthGreaterThan5()) {
            errorPassword.setValue("Password Length should be greater than 5")
        } else {
            userMutableLiveData!!.setValue(user)
            busy!!.setValue(8)
        }
    }
}