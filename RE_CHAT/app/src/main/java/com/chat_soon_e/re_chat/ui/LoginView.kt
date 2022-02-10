package com.chat_soon_e.re_chat.ui

import com.chat_soon_e.re_chat.data.remote.auth.Auth

interface LoginView {
    fun onLoginLoading()
    fun onLoginSuccess(auth: Auth)
    fun onLoginFailure(code: Int, message: String)
}