package com.chat_soon_e.chat_soon_e.data.local

import androidx.room.*
import com.chat_soon_e.chat_soon_e.data.entities.Chat

@Dao
interface ChatDao {
    @Insert
    fun insert(chat: Chat)

    @Update
    fun update(chat: Chat)

    @Delete
    fun delete(chat: Chat)

    @Query("SELECT * FROM ChatTable")
    fun getChatList(): List<Chat>

//    @Query("SELECT * FROM ChatTable WHERE idx = :idx")
//    fun getChatByIdx(idx: Int): Chat
}