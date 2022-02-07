package com.chat_soon_e.chat_soon_e.data.remote.chat

import android.util.Log
import com.chat_soon_e.chat_soon_e.ApplicationClass.Companion.retrofit
import com.chat_soon_e.chat_soon_e.ui.SignUpView
import com.chat_soon_e.chat_soon_e.ui.View.addChatView

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//레트로핏 사용하는 함수들 따로 모아서!(api사용하는 것을) 모듈화
class ChatService {

    fun addChat(addChatView: addChatView, userIdx:Long, chat:Chat){
        val chatService= retrofit.create(ChatRetrofitInterface::class.java)
        //loading
        chatService.addChat(userIdx, chat).enqueue(object :Callback<AddChatResponse>{
            override fun onResponse(
                call: Call<AddChatResponse>,
                response: Response<AddChatResponse>
            ) {
                val resp=response.body()!!
                when(resp.code){
                    1000 -> addChatView.onAddChatSuccess()
                    else -> addChatView.onAddChatFailure(resp.code, resp.message)
                }
            }
            override fun onFailure(call: Call<AddChatResponse>, t: Throwable) {
                Log.d("ERRORs", t.message.toString())
                addChatView.onAddChatFailure(400, "네트워크 오류")
            }
        })
    }

}