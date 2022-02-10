package com.chat_soon_e.re_chat.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.chat_soon_e.re_chat.data.entities.Chat
import com.chat_soon_e.re_chat.data.entities.Folder

@Dao
interface FolderDao {

    //폴더 추가
    @Insert
    fun insert(folder: Folder)

    @Update
    fun update(folder: Folder)

    //폴더안의 모든 채팅 내용 삭제(폴더 삭제시 먼저 실행)
    @Query("DELETE FROM FolderTable WHERE idx = :folderIdx")
    fun delete(folderIdx:Int)

    //모든 폴더목록 조회
    @Query("SELECT * FROM FolderTable ")
    fun getFolderList(): List<Folder>

    //숨긴 폴더 목록 조회
    @Query("SELECT * FROM FolderTable WHERE kakaoUserIdx = :kakaoUserIdx AND status = \"HIDDEN\"")
    fun getHiddenFolder(kakaoUserIdx:Long): List<Folder>

    @Query("SELECT * FROM FolderTable WHERE idx = :idx")
    fun getFolderByIdx(idx: Int): Folder

    @Query("SELECT * FROM FolderTable WHERE folderName = :folderName")
    fun getFolderByName(folderName: String): Folder

    @Query("UPDATE FolderTable SET status = :status WHERE idx = :idx")
    fun updateStatusByIdx(status: String, idx: Int)

    @Query("SELECT * FROM FolderTable WHERE status = :status")
    fun getFolderByStatus(status: String): List<Folder>

    @Query("UPDATE FolderTable SET folderImg = :folderImg WHERE idx = :idx")
    fun updateFolderImgByIdx(folderImg: Int, idx: Int)

    //해당 폴더의 챗들 가져오기
    @Query("SELECT C.postTime, C.folderIdx, C.chatIdx, C.otherUserIdx, C.isChecked, C.message, C.groupName, C.status, C.isNew, C.viewType FROM ChatTable C INNER JOIN OtherUserTable OU ON C.otherUserIdx=OU.otherUserIdx INNER JOIN FolderContentTable FC ON C.chatIdx=FC.chatIdx INNER JOIN FolderTable F ON FC.folderIdx=F.idx WHERE OU.kakaoUserIdx= :user_id AND FC.folderIdx=:folderIdx ORDER BY C.postTime DESC")
    fun getFolderChats(user_id:Long, folderIdx:Int): LiveData<List<Chat>>

    // 삭제된 폴더를 제외한 모든 폴더 목록 조회
    @Query("SELECT * FROM FolderTable WHERE status != :status")
    fun getFolderExceptDeletedFolder(status: String): List<Folder>
}