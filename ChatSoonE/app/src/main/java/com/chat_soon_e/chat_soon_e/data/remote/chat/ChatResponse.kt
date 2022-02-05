package com.chat_soon_e.chat_soon_e.data.remote.chat

import com.google.gson.JsonArray
import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.ArrayList

//자바의 데이터 클래스 멤버변수 이름은 camelCase 사용

//채팅 추가하기
data class AddChatResponse(@SerializedName("isSuccess")val isSuccess: Boolean, @SerializedName("code") val code:Int, val message: String)

//전체 채팅 목록 가져오기(메인화면)
data class ChatListResponse(@SerializedName("isSuccess")val isSuccess: Boolean, @SerializedName("code") val code:Int, val message: String, val result:JsonArray?)
data class ChatList(
    @SerializedName("chat_name")val chatName:String,
    @SerializedName("profile_image")val profileImage:String,
    @SerializedName("latest_time")val latestTime:Date,
    @SerializedName("latest_message")val latestMessage:String,
)
//갠톡 or 단톡 채팅 가져오기
data class ChatResponse(@SerializedName("isSuccess")val isSuccess: Boolean, @SerializedName("code") val code:Int, val message: String, val result:JsonArray?)
data class Chat(
    val nickname:String,
    val profileImgUrl:String,
    val message: String,
    @SerializedName("chat_date")val chatDate:Date,
    @SerializedName("post_time")val postTime:Date,
)
//폴더 안의 채팅 가져오기
data class FolderChatResponse(@SerializedName("isSuccess")val isSuccess: Boolean, @SerializedName("code") val code:Int, val message: String, val result:JsonArray?)
data class FolderChat(
    val folderName:String,
    val nickname:String,
    val profileImgUrl: String,
    val message:String,
    @SerializedName("chat_date")val chatDate:Date,
    @SerializedName("post_time")val postTime:Date,
)
