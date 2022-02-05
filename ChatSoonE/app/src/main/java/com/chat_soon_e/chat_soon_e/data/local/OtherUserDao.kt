package com.chat_soon_e.chat_soon_e.data.local

import androidx.room.*
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
    @Query("SELECT * FROM OtherUserTable WHERE nickname =:name AND kakaoUserIdx =:id")
    fun getOtherUserByNameId(name:String, id:Long): OtherUser

    //임시
    @Query("SELECT OU.otherUserIdx FROM OtherUserTable as OU WHERE kakaoUserIdx= :id")
    fun getOtherUserIdxList(id:Long): List<Int>

    //임시
    @Query("SELECT * FROM OtherUserTable WHERE otherUserIdx= :id")
    fun getOtherUserById(id:Int): OtherUser

    //해당 유저의 모든 other 목록 불러오기
    @Query("SELECT * FROM OtherUserTable WHERE kakaoUserIdx= :id")
    fun getAllOtherUser(id:Long):List<OtherUser>
}