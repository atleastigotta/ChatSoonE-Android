package com.chat_soon_e.chat_soon_e.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "OtherUserTable")
data class OtherUser(
    @SerializedName("nickname") val name: String?,
    @SerializedName("profileImgUrl") val image: String?,
    @SerializedName("status") val status: String,
    @SerializedName("kakaoUserIdx") val kakao_user_idx:Long=0L
){
    @PrimaryKey(autoGenerate = true)var other_user_idx:Int=0
}
