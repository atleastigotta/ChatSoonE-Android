package com.chat_soon_e.chat_soon_e.data.local

import androidx.room.*
import com.chat_soon_e.chat_soon_e.data.entities.User

@Dao
interface UserDao {

    @Insert
    fun insert(user: User)

    @Update
    fun update(user:User)

    @Query("UPDATE UserTable SET status= :status WHERE idx= :id")
    fun updateStatus(id:Int, status:String)


    @Delete
    fun delete(user:User)

    @Query("SELECT * FROM UserTable WHERE idx= :id")
    fun getUser(id:Int):User?

    @Query("SELECT * FROM UserTable")
    fun getUsers():List<User>?
}