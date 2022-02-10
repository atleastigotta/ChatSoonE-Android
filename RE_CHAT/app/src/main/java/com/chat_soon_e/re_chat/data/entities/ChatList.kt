package com.chat_soon_e.re_chat.data.entities

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

// 추후 서버와의 통신을 위한 데이터, 챗 쿼리를 통해 불러온 데이터 형식!, Chat 은 그냥 삽입만!
@Entity(tableName = "ChatListTable")
data class ChatList(
    var chatIdx:Int,
    var nickName:String?,
    var groupName:String,
    var profileImg:String?,
    var postTime:Date,
    var message:String?,
    var isNew:Int=0,
):Serializable{
    @PrimaryKey(autoGenerate = true)var id:Int?=0;
    @Ignore var viewType: Int=0;
    @Ignore var isChecked: Boolean=false;
}
object ChatListViewType {
    const val DEFAULT = 0
    const val CHOOSE = 1
}