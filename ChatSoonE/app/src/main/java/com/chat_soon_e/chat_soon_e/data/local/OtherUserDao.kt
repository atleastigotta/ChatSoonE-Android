package com.chat_soon_e.chat_soon_e.data.local

import androidx.room.*
import com.chat_soon_e.chat_soon_e.data.entities.OtherUser

@Dao
interface OtherUserDao {


    @Update
    fun update(otherUser: OtherUser)

    @Delete
    fun delete(otherUser: OtherUser)

    //임시
    @Query("SELECT OU.otherUserIdx FROM OtherUserTable as OU WHERE kakaoUserIdx= :id")
    fun getOtherUserIdxList(id:Long): List<Int>

    //임시
    @Query("SELECT * FROM OtherUserTable WHERE otherUserIdx= :id")
    fun getOtherUserById(id:Int): OtherUser

    //해당 유저의 모든 other 목록 불러오기
    @Query("SELECT * FROM OtherUserTable WHERE kakaoUserIdx= :id")
    fun getAllOtherUser(id:Long):List<OtherUser>

    //TEST

    //차단된 상대인가?
    //속도 느림, null(문자형X)반환
    @Query("SELECT OU.nickname FROM ChatTable C INNER JOIN OtherUserTable OU on C.otherUserIdx = OU.otherUserIdx WHERE OU.kakaoUserIdx =:userIdx AND C.otherUserIdx =:otherUserIdx AND C.groupName == 'null' AND OU.status==\"BLOCKED\"")
    fun checkOneBlock(userIdx:Long, otherUserIdx:Int):String?
    //속도 느림, null(문자형X)반환
    @Query("SELECT OU.nickname FROM ChatTable C INNER JOIN OtherUserTable OU ON C.otherUserIdx=OU.otherUserIdx WHERE OU.kakaoUserIdx =:userIdx AND C.groupName =:groupName AND C.status = \"BLOCKED\"")
    fun checkOrgBlock(userIdx:Long, groupName:String):String?
    //임시(주연), 검증된
    @Query("SELECT * FROM OtherUserTable WHERE nickname =:name AND kakaoUserIdx =:id")
    fun getOtherUserByNameId(name:String, id:Long): OtherUser?
    @Insert//검증된
    fun insert(otherUser: OtherUser)
}