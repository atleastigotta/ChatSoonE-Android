package com.chat_soon_e.chat_soon_e.data.remote.chat

import com.chat_soon_e.chat_soon_e.data.entities.Chat
import retrofit2.Call
import retrofit2.http.*

interface ChatRetrofitInterface {

    //채팅 추가하기
    @POST("/app/chatlist/{kakaoUserIdx}")
    fun addChat(@Path("kakaoUserIdx")kakaoUserIdx:Int, @Body chat:Chat):Call<AddChatResponse>

    //모든 채팅 리스트 가져오기
    @GET("/app/chatlist/{kakaoUserIdx}")
    fun getChatList(@Path("kakaoUserIdx")kakaoUserIdx:Int):Call<ChatListResponse>

    //갠톡 or 단톡 채팅 가져오기
    @GET("/app/chat/{kakaoUserIdx}")
    fun getChat(@Path("kakaoUserIdx")kakaoUserIdx: Int, @Query("otherUserIdx")otherUserIdx:Int?=null, @Query("groupName")groupName:String?=null):Call<ChatResponse>

    //폴더 안의 채팅 리스트 가져오기
    @GET("/app/chat-folder/{kakaoUserIdx}")
    fun getFolderChat(@Path("kakaoUserIdx")kakaoUserIdx:Int, @Query("folderIdx")folderIdx:Int):Call<FolderChatResponse>


}