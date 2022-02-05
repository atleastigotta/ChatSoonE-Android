package com.chat_soon_e.chat_soon_e.utils

import com.chat_soon_e.chat_soon_e.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.chat_soon_e.chat_soon_e.ApplicationClass.Companion.mSharedPreferences

fun saveJwt(jwtToken: String) {
    val editor = mSharedPreferences.edit()
    editor.putString(X_ACCESS_TOKEN, jwtToken)

    editor.apply()
}

fun getJwt(): String? = mSharedPreferences.getString(X_ACCESS_TOKEN, null)
