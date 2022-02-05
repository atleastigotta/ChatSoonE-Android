package com.chat_soon_e.chat_soon_e.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "FolderTable")
data class Folder(
    @SerializedName("folderName") var folderName: String,
    @SerializedName("kakaoUserIdx")var kakaoUserIdx:Long=0L,
    @SerializedName("parentFolderIdx")var parentFolderIdx:Int?=null,
    @SerializedName("folderImg")var folderImg:String?=null,
    //status: ACTIVE, HIDDEN, DELETED
    @SerializedName("status")var status:String="ACTIVE",
    ){
    @PrimaryKey(autoGenerate = true)@SerializedName("folderIdx") var folderIdx: Int = 0
}