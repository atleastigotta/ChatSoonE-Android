package com.chat_soon_e.chat_soon_e.data.local

import androidx.room.*
import com.chat_soon_e.chat_soon_e.data.entities.Folder

@Dao
interface FolderDao {

    //폴더 추가
    @Insert
    fun insert(folder: Folder)

    @Update
    fun update(folder: Folder)

    //폴더안의 모든 채팅 내용 삭제(폴더 삭제시 먼저 실행)
    @Query("DELETE FROM FOlderTable WHERE idx = :folderIdx")
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



}