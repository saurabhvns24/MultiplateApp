package com.example.databinding

import android.util.Patterns
class User(email: String?, password: String?, textview: String?) {
    private var mEmail: String? = null
    private var mPassword: String? = null
    private var mTextview: String? = null


    init {
        mEmail = email;
        mPassword = password;
        mTextview = textview;

    }

    fun User(email: String, password: String, textview: String, newtext: String?) {
        mEmail = email
        mPassword = password
        mTextview = textview

    }

    fun getEmail(): String? {
        return if (mEmail == null) {
            ""
        } else mEmail
    }

    fun getPassword(): String {
        return mPassword ?: ""
    }

    fun getTextview(): String {
        return mTextview ?: "Thara"

    }

    fun setTextview(): String {
        return mTextview ?: "Thara"
    }

    fun isEmailValid(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()
    }
    fun isPasswordLengthGreaterThan5(): Boolean {
        return getPassword().length > 5
    }
    fun isVarifyTextLenthLesserThan4(): Boolean {
        return getTextview().length<4
    }

}
