package com.chat_soon_e.chat_soon_e.data.remote.user

import com.chat_soon_e.chat_soon_e.data.entities.User
import com.chat_soon_e.chat_soon_e.ui.SignUpView


//레트로핏(API) 사용하는 함수들 따로 모아서 모듈화
object UserService {
    private lateinit var singUpView:SignUpView

    //setter
    fun setSignUpView(signUpView: SignUpView){
        this.singUpView=signUpView
    }
}