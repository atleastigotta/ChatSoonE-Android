package com.chat_soon_e.chat_soon_e.data.local

import androidx.room.*
import com.chat_soon_e.chat_soon_e.data.entities.Chat
import com.chat_soon_e.chat_soon_e.data.entities.OtherUser

@Dao
interface OtherUserDao {
    @Insert
    fun insert(otherUser: OtherUser)

    @Update
    fun update(otherUser: OtherUser)

    @Delete
    fun delete(otherUser: OtherUser)

    //임시
    @Query("SELECT * FROM OtherUserTable WHERE name =:name AND kakao_user_idx =:id")
    fun getOtherUserByNameId(name:String, id:Long):OtherUser
    //임시
    @Query("SELECT OU.other_user_idx FROM OtherUserTable as OU WHERE kakao_user_idx= :id")
    fun getOtherUserIdxList(id:Long):List<Int>
    //임시
    @Query("SELECT * FROM OtherUserTable WHERE other_user_idx= :id")
    fun getOtherUserById(id:Int):OtherUser
}