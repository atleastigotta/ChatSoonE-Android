package com.chat_soon_e.chat_soon_e.data.local

import androidx.room.*
import com.chat_soon_e.chat_soon_e.data.entities.Folder
import com.chat_soon_e.chat_soon_e.data.entities.Icon

@Dao
interface IconDao {
    @Insert
    fun insert(icon: Icon)

    @Update
    fun update(icon: Icon)

    @Delete
    fun delete(icon: Icon)

    @Query("SELECT * FROM IconTable")
    fun getIconList(): List<Icon>
}