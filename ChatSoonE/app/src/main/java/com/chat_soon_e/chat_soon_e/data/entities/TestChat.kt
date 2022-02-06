package com.chat_soon_e.chat_soon_e.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "TestChatTable")
data class TestChat (
    @SerializedName("name") var name: String,
    @SerializedName("message") var message: String,
    @SerializedName("dateTime") var dateTime: String? = null,
    @SerializedName("viewType") var viewType: Int = 0,
    @SerializedName("isChecked") var isChecked: Boolean = false
) {
    @PrimaryKey(autoGenerate = true) var idx: Int = 0
}

object TestChatViewType {
    const val DEFAULT = 0
    const val CHOOSE = 1
}