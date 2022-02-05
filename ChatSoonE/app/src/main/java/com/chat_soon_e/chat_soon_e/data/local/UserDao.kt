package com.chat_soon_e.chat_soon_e.data.local

import androidx.room.*
import com.chat_soon_e.chat_soon_e.data.entities.User

@Dao
interface UserDao {
    @Insert
    fun insert(user: User)

    @Update
    fun update(user:User)

    //유저의 상태 업데이트
    @Query("UPDATE UserTable SET status= :status WHERE idx= :id")
    fun updateStatus(id:Long, status:String)

    @Delete
    fun delete(user:User)

    @Query("SELECT * FROM UserTable WHERE idx= :id")
    fun getUser(id:Long):User?

    @Query("SELECT * FROM UserTable")
    fun getUsers():List<User>?
}