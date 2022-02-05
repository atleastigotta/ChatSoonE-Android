package com.chat_soon_e.chat_soon_e.data.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.text.DateFormat
import java.text.SimpleDateFormat

@Entity(tableName = "UserTable", indices = [Index(value = ["idx"], unique = true)])//pk 중복 생성 방지
data class User(
    @PrimaryKey(autoGenerate = false)@SerializedName("kakaoUserIdx")var idx:Long=0L,
    @SerializedName("nickname") val nickname: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("status") val status: String,//activate: 로그인, inactivate: 로그아웃, delete:탈퇴
//    @SerializedName("createdAt") val createdAt: String,
//    @SerializedName("updatedAt") val updatedAt: String
)