package com.chat_soon_e.chat_soon_e.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

//폴더 별 채팅들 데이터
@Entity(tableName = "FolderContentTable")
data class FolderContent(
    var folderIdx: Int,
    var chatIdx: Int,
    var status: String? = "ACTIVE"   // ACTIVE, DELETED
){
    @PrimaryKey(autoGenerate = true) var folderContentIdx: Int = 0
}