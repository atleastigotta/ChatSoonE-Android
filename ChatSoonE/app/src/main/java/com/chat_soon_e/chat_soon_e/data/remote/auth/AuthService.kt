package com.chat_soon_e.chat_soon_e.data.remote.auth

import android.util.Log
import com.chat_soon_e.chat_soon_e.ApplicationClass.Companion.TAG
import com.chat_soon_e.chat_soon_e.ApplicationClass.Companion.retrofit
import com.chat_soon_e.chat_soon_e.data.entities.User
import com.chat_soon_e.chat_soon_e.ui.LoginView
import com.chat_soon_e.chat_soon_e.ui.SignUpView
import com.chat_soon_e.chat_soon_e.ui.SplashView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// object로 선언된 클래스는 불러올 때 한 번 객체화가 되면 쭉 객체화를 유지하는 Singleton 패턴이라고 보면 된다.
object AuthService {
    fun signUp(signUpView: SignUpView, user: User) {    // 이 안에 view interface를 가진 것을 인자로 넘겨주면 된다.
        val authService = retrofit.create(AuthRetrofitInterface::class.java)

        signUpView.onSignUpLoading()

        authService.signUp(user).enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {

                val resp = response.body()!!

                when(resp.code){
                    1000 -> signUpView.onSignUpSuccess()
                    else -> signUpView.onSignUpFailure(resp.code, resp.message)
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                Log.d("$TAG/API-ERROR", t.message.toString())

                signUpView.onSignUpFailure(400, "네트워크 오류가 발생했습니다.")
            }
        })
    }

    fun login(loginView: LoginView, user: User) {   // 이 안에 view interface를 가진 것을 인자로 넘겨주면 된다.
        val authService = retrofit.create(AuthRetrofitInterface::class.java)

        loginView.onLoginLoading()

        authService.login(user).enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                val resp = response.body()!!

                when(resp.code){
                    1000 -> loginView.onLoginSuccess(resp.result!!)
                    else -> loginView.onLoginFailure(resp.code, resp.message)
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                Log.d("$TAG/API-ERROR", t.message.toString())

                loginView.onLoginFailure(400, "네트워크 오류가 발생했습니다.")
            }
        })
    }

    fun autoLogin(splashView: SplashView) { // 이 안에 view interface를 가진 것을 인자로 넘겨주면 된다.
        val authService = retrofit.create(AuthRetrofitInterface::class.java)

        splashView.onAutoLoginLoading()

        authService.autoLogin().enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                val resp = response.body()!!

                when(resp.code){
                    1000 -> splashView.onAutoLoginSuccess()
                    else -> splashView.onAutoLoginFailure(resp.code, resp.message)
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                Log.d("$TAG/API-ERROR", t.message.toString())

                splashView.onAutoLoginFailure(400, "네트워크 오류가 발생했습니다.")
            }
        })
    }
}