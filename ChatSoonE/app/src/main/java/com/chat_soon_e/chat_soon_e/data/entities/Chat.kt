package com.chat_soon_e.chat_soon_e.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat

@Entity(tableName = "ChatTable")
data class Chat(
    @SerializedName("kakaoUserIdx") val user_idx: Int = 0,
    @SerializedName("groupName") val groupName:String?,
    @SerializedName("name") val name: String?,
    @SerializedName("image_name") val image_name: String? = null,
    @SerializedName("messagewithTime") val content: LinkedHashMap<SimpleDateFormat,String>,
    @SerializedName("latestMessageWithTime") val latestTime:SimpleDateFormat,
    @SerializedName("folderIdx") val folderIdx:Int=0,
    @SerializedName("createdAt") val createdAt: SimpleDateFormat,
    @SerializedName("updatedAt") val updatedAt: SimpleDateFormat,
    @SerializedName("status") val status: String,
    ) {
    @PrimaryKey(autoGenerate = true) var idx: Int = 0
}