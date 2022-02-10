package com.chat_soon_e.re_chat.utils

import com.chat_soon_e.re_chat.ApplicationClass.Companion.USER_INFO
import com.chat_soon_e.re_chat.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.chat_soon_e.re_chat.ApplicationClass.Companion.mSharedPreferences

fun saveJwt(jwtToken: String) {
    val editor = mSharedPreferences.edit()
    editor.putString(X_ACCESS_TOKEN, jwtToken)

    editor.apply()
}

fun getJwt(): String? = mSharedPreferences.getString(X_ACCESS_TOKEN, null)

fun saveID(user_id:Long){
    val editor= mSharedPreferences.edit()
    editor.putLong(USER_INFO, user_id)
    editor.apply()
}
fun getID():Long= mSharedPreferences.getLong(USER_INFO, -1)