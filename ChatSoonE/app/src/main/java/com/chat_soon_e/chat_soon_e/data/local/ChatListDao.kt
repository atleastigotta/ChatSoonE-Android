package com.chat_soon_e.chat_soon_e.data.local

import androidx.room.*
import com.chat_soon_e.chat_soon_e.data.entities.ChatList
import com.chat_soon_e.chat_soon_e.data.entities.User

@Dao
interface ChatListDao {
    @Insert
    fun insert(chatList:ChatList)

    @Update
    fun update(chatList : ChatList)

    @Delete
    fun delete(chatList: ChatList)

    //chatList insertTable을 써야 가능한 함수!
    //해당 chatIdx isNew 바꾸기
    @Query("UPDATE ChatListTable SET isNew= :status WHERE chatIdx= :chatIdx")
    fun updateIsNew(chatIdx:Int, status:Int)


}