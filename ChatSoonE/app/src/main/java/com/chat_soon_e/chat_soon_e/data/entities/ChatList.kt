package com.chat_soon_e.chat_soon_e.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

//추후 서버와의 통신을 위한 데이터
@Entity(tableName = "ChatListTable")
data class ChatList(
    var chatIdx:Int,
    var chat_name:String?,
    var profileImg:String?=null,
    var latest_time:Date,
    var latest_message:String?,
    var isGroup:Int,//-1이면 그룹, 0이면 개인
    @ColumnInfo(defaultValue = "0")@Ignore var viewType: Int=0,
    var isNew:Int=0,
    @ColumnInfo(defaultValue = "false") var isChecked: Boolean?=false
){
    @PrimaryKey(autoGenerate = true)var id:Int?=0
    constructor(chatIdx: Int,chat_name:String?, profileImg: String?, latest_time: Date, latest_message: String?, isGroup: Int,isNew:Int, isChecked:Boolean?):this(chatIdx,chat_name, profileImg, latest_time, latest_message, isGroup,0, isNew,false)
}

object ChatListViewType {
    const val DEFAULT = 0
    const val CHOOSE = 1
}