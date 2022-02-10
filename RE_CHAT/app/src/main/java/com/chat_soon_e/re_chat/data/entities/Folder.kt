package com.chat_soon_e.re_chat.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.chat_soon_e.re_chat.R
import com.google.gson.annotations.SerializedName
import java.io.Serializable

// folderImg: Int -> String (using Bitmap) 변환 필요
// 폴더 정보를 담은 데이터
@Entity(tableName = "FolderTable")
data class Folder(
    @PrimaryKey(autoGenerate = false) @SerializedName("folderIdx") var idx: Int = 0,
    @SerializedName("kakaoUserIdx") var kakaoUserIdx: Long = 0,
    @SerializedName("parentFolderIdx") var parentFolderIdx: Int?,
    @SerializedName("folderName") var folderName: String,
    @SerializedName("folderImg") var folderImg: Int = R.drawable.ic_baseline_folder_24,
    @SerializedName("status") var status: String
):Serializable