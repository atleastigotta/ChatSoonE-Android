package com.chat_soon_e.re_chat.config

import com.chat_soon_e.re_chat.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.chat_soon_e.re_chat.utils.getJwt
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class XAccessTokenInterceptor: Interceptor {
    // API 요청할 때마다 자동적으로 sharedPreference에 있는 jwt token을 가져와서 Header에 넣어주는 작업
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder: Request.Builder = chain.request().newBuilder()

        val jwtToken: String? = getJwt()

        // sharedPreference에 token이 없다면 .let { } 실행 X
        // sharedPreference에 token이 있을 때만 실행 -> X_ACCESS_TOKEN 키 값으로 jwt token을 Header에 넣는다.
        // 최종적으로 ApplicationClass.kt에서 retrofit Header에 jwt token이 알아서 담겨서 요청하게끔
        // 따라서 annotation으로 일일이 넣어줄 필요없이 Header 있는지 없는지 내부에서 검사한 후 넣어주므로 Header를 넣어주는 작업을 따로 할 필요는 없다.
        jwtToken?.let{
            builder.addHeader(X_ACCESS_TOKEN, jwtToken)
        }

        return chain.proceed(builder.build())
    }
}