package com.chat_soon_e.re_chat.data.remote.user

import com.chat_soon_e.re_chat.ui.SignUpView


//레트로핏(API) 사용하는 함수들 따로 모아서 모듈화
object UserService {
    private lateinit var singUpView:SignUpView

    //setter
    fun setSignUpView(signUpView: SignUpView){
        this.singUpView=signUpView
    }
}