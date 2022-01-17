package com.chat_soon_e.chat_soon_e.ui

import com.chat_soon_e.chat_soon_e.data.remote.auth.Auth

interface LoginView {
    fun onLoginLoading()
    fun onLoginSuccess(auth: Auth)
    fun onLoginFailure(code: Int, message: String)
}