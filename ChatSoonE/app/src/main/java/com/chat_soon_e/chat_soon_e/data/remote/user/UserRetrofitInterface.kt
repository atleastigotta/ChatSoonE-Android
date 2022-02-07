package com.chat_soon_e.chat_soon_e.data.remote.user

import com.chat_soon_e.chat_soon_e.data.entities.Chat
import retrofit2.Call
import retrofit2.http.*

interface UserRetrofitInterface {

    //유저 추가하기
    @POST("/app/users/user")
    fun addUser(@Body kakaoUserIdx:Long):Call<UserResponse>

}