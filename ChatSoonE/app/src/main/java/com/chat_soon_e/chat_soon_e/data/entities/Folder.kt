package com.chat_soon_e.chat_soon_e.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.chat_soon_e.chat_soon_e.R
import com.google.gson.annotations.SerializedName

// folderImg, createdAt, updatedAt 부분 수정해야 합니다.
@Entity(tableName = "FolderTable")
data class Folder(
    @PrimaryKey(autoGenerate = false) @SerializedName("folderIdx") var idx: Int = 0,
    @SerializedName("kakaoUserIdx") var kakaoUserIdx: Int = 0,
    @SerializedName("parentFolderIdx") var parentFolderIdx: Int?,
    @SerializedName("folderName") var folderName: String,
    @SerializedName("folderImg") var folderImg: Int = R.drawable.ic_baseline_folder_24,
    @SerializedName("status") var status: String
)