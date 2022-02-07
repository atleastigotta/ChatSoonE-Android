package com.chat_soon_e.chat_soon_e.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

// 서버 통신 X
@Entity(tableName="IconTable")
data class Icon(
    @SerializedName("iconImage") val iconImage: Int
) {
    @PrimaryKey(autoGenerate = true) var idx: Int = 0
}