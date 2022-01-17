package com.chat_soon_e.chat_soon_e.ui

interface SplashView {
    fun onAutoLoginLoading()
    fun onAutoLoginSuccess()
    fun onAutoLoginFailure(code: Int, message: String)
}