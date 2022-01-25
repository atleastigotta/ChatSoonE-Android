package com.chat_soon_e.chat_soon_e.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.chat_soon_e.chat_soon_e.data.local.Converter
import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap

@Entity(tableName = "ChatTable")
data class Chat(
    @SerializedName("kakaoUserIdx") val user_idx: Int = 0,//현재 로그인된 유저 idx
    @SerializedName("groupName") val groupName:String?,//그룹명
    @SerializedName("name") val name: String?,//발신자
    @SerializedName("image_name") val image_name: String? = null,//이미지 이름
    @SerializedName("latestMessageWithTime") val latestTime:Date?=null,//최근 보낸 시간
    @SerializedName("postTime") val postTime:Date?=null,//보낸시간
    @SerializedName("message") val message: String?=null,//내용
    @SerializedName("folderIdx") val folderIdx:Int=0,//폴더 인덱스
    @SerializedName("createdAt") val createdAt: Date?,
    @SerializedName("updatedAt") val updatedAt: Date?,
    @SerializedName("status") val status: String,//상태, activate
    ) {
    @PrimaryKey(autoGenerate = true)@SerializedName("chatIdx") var idx: Int = 0
}