package com.chat_soon_e.chat_soon_e.data.entities

import android.provider.ContactsContract
import java.util.*

//추후 서버와의 통신을 위한 데이터
data class ChatList(
    val chat_name:String?,
    val profileImg:String?,
    val latest_time:Date,
    val latest_message:String?
)
