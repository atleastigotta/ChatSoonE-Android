package com.chat_soon_e.chat_soon_e.ui

import android.util.Log
import com.chat_soon_e.chat_soon_e.databinding.ActivityChatBinding

class ChatActivity: BaseActivity<ActivityChatBinding>(ActivityChatBinding::inflate) {
    override fun initAfterBinding() {
        Log.d("CHAT/LIFE-CYCLE", "onCreate() 이후")
    }
}