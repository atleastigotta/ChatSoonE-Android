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

    //폴더 이름 바꾸기
    @Query("UPDATE FolderTable SET folderName = :folderName WHERE folderIdx =:folderIdx")
    fun updateFolderName(folderIdx:Int, folderName:String)

    //폴더 아이콘 바꾸기
    @Query("UPDATE FolderTable SET folderImg = :image WHERE folderIdx =:folderIdx")
    fun updateFolderImg(folderIdx:Int, image:String)

    //폴더 숨기기
    @Query("UPDATE FolderTable SET status =\"HIDDEN\" WHERE folderIdx =:folderIdx")
    fun updateFolderHidden(folderIdx: Int)

    //폴더 숨김 해제
    @Query("UPDATE FolderTable SET status =\"ACTIVE\" WHERE folderIdx= :folderIdx")
    fun updateFolderActive(folderIdx: Int)

    //폴더안의 모든 채팅 내용 삭제(폴더 삭제시 먼저 실행)
    @Query("DELETE FROM FOlderTable WHERE folderIdx = :folderIdx")
    fun delete(folderIdx:Int)

    //모든 폴더목록 조회
    @Query("SELECT * FROM FolderTable WHERE kakaoUserIdx = :userIdx AND status != \"HIDDEN\"")
    fun getFolderList(userIdx:Long): List<Folder>

    //해당 폴더목록 조회
    @Query("SELECT * FROM FolderTable WHERE folderIdx = :folderIdx AND kakaoUserIdx = :userIdx AND status != \"HIDDEN\"")
    fun getFolderByIdx(userIdx:Long, folderIdx:Int): Folder

    //숨긴 폴더 목록 조회
    @Query("SELECT * FROM FolderTable WHERE kakaoUserIdx = :kakaoUserIdx AND status = \"HIDDEN\"")
    fun getHiddenFolder(kakaoUserIdx:Long): List<Folder>
}