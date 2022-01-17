package com.chat_soon_e.chat_soon_e.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "ChatTable")
data class Chat(
    @SerializedName("profile") val profile: String? = null,
    @SerializedName("name") val name: String,
    @SerializedName("content") val content: String,
    @SerializedName("dateTime") val dateTime: String
) {
    @PrimaryKey(autoGenerate = true) var idx: Int = 0
}