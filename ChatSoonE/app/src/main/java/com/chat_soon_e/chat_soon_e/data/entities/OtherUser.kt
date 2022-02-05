package com.chat_soon_e.chat_soon_e.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "OtherUserTable")
data class OtherUser(
    @SerializedName("nickname") var nickname: String,
    @SerializedName("profileImgUrl") var image: String?=null,
    //status: ACTIVE, INACTIVE, BLOCKED
    @SerializedName("status") var status: String="ACTIVE",
    @SerializedName("kakaoUserIdx") var kakaoUserIdx:Long=0L
){
    @PrimaryKey(autoGenerate = true) var otherUserIdx:Int=0
}
