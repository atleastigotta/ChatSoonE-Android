package com.chat_soon_e.chat_soon_e.data.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "UserTable", indices = [Index(value = ["kakaoUserIdx"], unique = true)])    // pk 중복 생성 방지
data class User(
    @PrimaryKey(autoGenerate = false)@SerializedName("kakaoUserIdx")var kakaoUserIdx:Long=0L,
    @SerializedName("nickname") var nickname: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("status") var status: String = "ACTIVE" // activate: 로그인, inactivate: 로그아웃, delete: 탈퇴
)