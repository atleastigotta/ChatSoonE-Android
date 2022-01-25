package com.chat_soon_e.chat_soon_e.data.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.text.DateFormat
import java.text.SimpleDateFormat

@Entity(tableName = "UserTable", indices = [Index(value = ["idx"], unique = true)])
data class User(
    @PrimaryKey(autoGenerate = false)@SerializedName("kakaoUserIdx")var idx:Int=0,
    //@SerializedName("id") val id: Int,//spf
    @SerializedName("nickname") val nickname: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("status") val status: String,
){

}
