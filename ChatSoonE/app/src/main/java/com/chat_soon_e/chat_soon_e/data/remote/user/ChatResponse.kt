package com.chat_soon_e.chat_soon_e.data.remote.user

import com.google.gson.JsonArray
import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.ArrayList

//자바의 데이터 클래스 멤버변수 이름은 camelCase 사용

//유저 추가하기
data class UserResponse(
    @SerializedName("isSuccess")var isSuccess: Boolean,
    @SerializedName("code") var code:Int,
    @SerializedName("code") var message: String
    )
