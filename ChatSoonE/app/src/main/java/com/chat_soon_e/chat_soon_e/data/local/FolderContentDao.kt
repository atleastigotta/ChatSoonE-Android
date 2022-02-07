package com.chat_soon_e.chat_soon_e.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.chat_soon_e.chat_soon_e.data.entities.FolderContent

@Dao
interface FolderContentDao {
    @Insert
    fun insert(folderContent:FolderContent)

    //채팅 한개를 폴더에 추가
    @Query("INSERT INTO FolderContentTable (folderIdx, chatIdx) VALUES (:folderIdx, :chatIdx)")
    fun insertChat(folderIdx:Int, chatIdx:Int)

    //갠톡 채팅들 폴더에 추가, chat에는 kakaoUserIdx 없음!
    @Query("INSERT INTO FolderContentTable (folderIdx, chatIdx) SELECT :folderIdx, chatIdx FROM ChatTable WHERE otherUserIdx =:otherUserIdx AND groupName IS NULL")//안되면 "null"문자열 넣기
    fun insertOtOChat(folderIdx:Int,otherUserIdx:Int)

    //단톡 채팅들 폴더에 추가
    @Query("INSERT INTO FolderContentTable (folderIdx, chatIdx) SELECT :folderIdx, chatIdx FROM ChatTable AS C INNER JOIN OtherUserTable AS OU ON C.otherUserIdx =OU.otherUserIdx WHERE OU.kakaoUserIdx= :userIdx AND C.groupName = :groupName")
    fun insertOrgChat(folderIdx:Int, userIdx:Long, groupName:String)

    //채팅을 폴더에서 제거
    @Query("DELETE FROM FolderContentTable WHERE folderIdx= :folderIdx AND chatIdx= :chatIdx")
    fun deleteChat(folderIdx:Int, chatIdx:Int)

    @Query("SELECT * FROM foldercontenttable")
    fun getAllfolder():List<FolderContent>
}