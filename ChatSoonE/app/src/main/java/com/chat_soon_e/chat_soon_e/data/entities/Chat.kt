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
    @SerializedName("kakaoUserIdx") val user_idx: Long = 0,//현재 로그인된 유저 idx, 서버없이 데이터를 구현하기 위한 임시 변수
    @SerializedName("otherUserIdx") val other_user_idx: Int = 0,//상대방 유저 idx
    @SerializedName("groupName") val groupName:String?,//그룹명
    @SerializedName("message") val message: String?=null,//내용
    @SerializedName("postTime") val postTime:Date?=null,//보낸시간
    @SerializedName("folderIdx") val folderIdx:Int=0,//폴더 인덱스
//    @SerializedName("createdAt") val createdAt: Date?,
//    @SerializedName("updatedAt") val updatedAt: Date?,
    @SerializedName("status") val status: String,//상태, 기본 activate
    @SerializedName("viewType") var viewType: Int = 0,
    @SerializedName("isChecked") var isChecked: Boolean = false
) {
    @PrimaryKey(autoGenerate = true) @SerializedName("chatIdx") var idx: Int = 0
}

object ChatViewType {
    const val DEFAULT = 0
    const val CHOOSE = 1
}