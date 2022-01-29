package com.chat_soon_e.chat_soon_e.data.local

import androidx.room.*
import com.chat_soon_e.chat_soon_e.data.entities.User

@Dao
interface UserDao {

    @Insert
    fun insert(user: User)

    @Update
    fun update(user:User)

    @Delete
    fun delete(user:User)

    @Query("SELECT * FROM UserTable WHERE id= :id")
    fun getUser(id: Int):User
}