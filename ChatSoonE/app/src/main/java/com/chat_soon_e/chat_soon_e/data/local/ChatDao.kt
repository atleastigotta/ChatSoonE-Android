package com.chat_soon_e.chat_soon_e.data.local

import androidx.lifecycle.LiveData
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

    //해당 chatIdx 대화 가져오기
    @Query("SELECT * FROM ChatTable WHERE chatIdx = :chatIdx")
    fun getChatByChatIdx(chatIdx:Int):Chat

    //해당 chatIdx isNew 바꾸기
    @Query("UPDATE ChatTable SET isNew= :status WHERE chatIdx= :chatIdx")
    fun updateIsNew(chatIdx:Int, status:Int)

    // 상대방 대화 가져오기
    @Query("SELECT * FROM ChatTable WHERE otherUserIdx = :idx")
    fun getChatByIdx(idx: Int): List<Chat>

    //chatId도 가져와야함,
    @Query("SELECT CL.chatName AS chat_name, CL.profileImg AS profileImg, CL.latestTime AS latest_time, CM.message AS latest_message, CL.isNew AS isNew, CL.chatIdx\n" +
            "FROM\n" +
            "(SELECT (CASE WHEN C.groupName == \"null\" THEN OU.nickname ELSE C.groupName END) AS chatName,\n" +
            "(CASE WHEN C.groupName == \"null\" THEN OU.image ELSE NULL END) AS profileImg, C.isNew AS isNew,C.chatIdx AS chatIdx, " +
            "MAX(C.postTime) as latestTime\n" +
            "FROM ChatTable as C INNER JOIN OtherUserTable as OU on C.otherUserIdx = OU.otherUserIdx\n" +
            "WHERE OU.kakaoUserIdx = :id AND C.status != 'DELETED'\n" +
            "GROUP BY chatName, profileImg) AS CL\n" +
            "INNER JOIN\n" +
            "(SELECT DISTINCT (CASE WHEN C.groupName == \"null\" THEN OU.nickname ELSE C.groupName END) AS chatName, C.message, C.postTime, C.isNew, C.chatIdx\n" +
            "FROM ChatTable C INNER JOIN OtherUserTable OU on C.otherUserIdx = OU.otherUserIdx\n" +
            "WHERE OU.kakaoUserIdx = :id AND C.status != 'DELETED') CM\n" +
            "ON CL.chatName = CM.chatName AND CL.latestTime = CM.postTime AND CL.isNew=CM.isNew AND CL.chatIdx = CM.chatIdx \n" +
            "ORDER BY latest_time DESC")
    fun getRecentChat(id:Long):LiveData<List<ChatList>>

    @Query("SELECT * FROM ChatTable")
    fun getChatList(): List<Chat>

}