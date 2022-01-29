package com.chat_soon_e.chat_soon_e.data.local

import androidx.room.*
import com.chat_soon_e.chat_soon_e.data.entities.Folder

@Dao
interface FolderDao {
    @Insert
    fun insert(folder: Folder)

    @Update
    fun update(folder: Folder)

    @Delete
    fun delete(folder: Folder)

    @Query("SELECT * FROM FolderTable")
    fun getFolderList(): List<Folder>

    @Query("SELECT * FROM FolderTable WHERE idx = :idx")
    fun getFolderByIdx(idx: Int): Folder
}