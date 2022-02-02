package com.chat_soon_e.chat_soon_e.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "FolderTable")
data class Folder(
    @PrimaryKey(autoGenerate = false) var idx: Int = 0,
    @SerializedName("folderName") var name: String
)