package com.chat_soon_e.re_chat.ui.View

interface addChatView {
    fun onAddChatSuccess()
    fun onAddChatFailure(code: Int, message: String)
}