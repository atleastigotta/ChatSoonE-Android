package com.chat_soon_e.re_chat.data.remote.user

import retrofit2.Call
import retrofit2.http.*

interface UserRetrofitInterface {

    //유저 추가하기
    @POST("/app/users/user")
    fun addUser(@Body kakaoUserIdx:Long):Call<UserResponse>

}