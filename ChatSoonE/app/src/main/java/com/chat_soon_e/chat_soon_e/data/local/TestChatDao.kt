package com.chat_soon_e.chat_soon_e.data.local

import androidx.room.*
import com.chat_soon_e.chat_soon_e.data.entities.Chat
import com.chat_soon_e.chat_soon_e.data.entities.TestChat

@Dao
interface TestChatDao {
    @Insert
    fun insert(testChat: TestChat)

    @Update
    fun update(testChat: TestChat)

    @Delete
    fun delete(testChat: TestChat)

    @Query("SELECT * FROM TestChatTable")
    fun getChatList(): List<TestChat>
}