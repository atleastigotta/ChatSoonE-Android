package com.chat_soon_e.chat_soon_e.data.local

import androidx.room.*
import com.chat_soon_e.chat_soon_e.data.entities.Chat
import com.chat_soon_e.chat_soon_e.data.entities.ChatList

@Dao
interface ChatDao {
    @Insert
    fun insert(chat: Chat)

    @Update
    fun update(chat: Chat)

    @Delete
    fun delete(chat: Chat)

    //상대방 대화 가져오기
    @Query("SELECT * FROM ChatTable WHERE other_user_idx = :idx")
    fun getChatByIdx(idx: Int): List<Chat>

    //채팅방 목록 구현을 위해 사용자의 각 other user idx(상대방)들의 대화 한개씩만 가져옴
    @Query("SELECT * FROM ChatTable WHERE user_idx= :id GROUP BY other_user_idx ORDER BY postTime ASC")
    fun getRecentChat(id:Long):List<Chat>
}