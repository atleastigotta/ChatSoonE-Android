package com.chat_soon_e.re_chat.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.chat_soon_e.re_chat.data.entities.FolderContent

@Dao
interface FolderContentDao {
    @Insert
    fun insert(folderContent:FolderContent)

    //채팅 한개를 폴더에 추가
    @Query("INSERT INTO FolderContentTable (folderIdx, chatIdx, status) VALUES (:folderIdx, :chatIdx,'ACTIVE')")
    fun insertChat(folderIdx:Int, chatIdx:Int)

    //채팅방 해당 폴더에 추가
    //@Query("INSERT INTO FolderContentTable (folderIdx, chatIdx) VALUES (:")")

    //갠톡 채팅들 폴더에 추가, 폴더 Content에 chatidx를 추가하는 방식이어야 함
    @Query("INSERT INTO FolderContentTable (folderIdx, chatIdx, status) VALUES(:folderIdx, (SELECT chatIdx FROM ChatTable WHERE otherUserIdx =:otherUserIdx AND groupName IS 'null'),'ACTIVE')")//안되면 "null"문자열 넣기
    fun insertOtOChat(folderIdx:Int,otherUserIdx:Int)

    //단톡 채팅들 폴더에 추가
    @Query("INSERT INTO FolderContentTable (folderIdx, chatIdx) VALUES(:folderIdx,(SELECT chatIdx FROM ChatTable AS C INNER JOIN OtherUserTable AS OU ON C.otherUserIdx =OU.otherUserIdx WHERE OU.kakaoUserIdx= :userIdx AND C.groupName = :groupName))")
    fun insertOrgChat(folderIdx:Int, userIdx:Long, groupName:String)

    //채팅을 폴더에서 제거
    @Query("DELETE FROM FolderContentTable WHERE folderIdx= :folderIdx AND chatIdx= :chatIdx")
    fun deleteChat(folderIdx:Int, chatIdx:Int)

    @Query("SELECT * FROM foldercontenttable")
    fun getAllfolder():List<FolderContent>
}