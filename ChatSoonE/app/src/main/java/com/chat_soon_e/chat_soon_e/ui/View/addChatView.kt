package com.chat_soon_e.chat_soon_e.ui.View

interface addChatView {
    fun onAddChatSuccess()
    fun onAddChatFailure(code: Int, message: String)
}