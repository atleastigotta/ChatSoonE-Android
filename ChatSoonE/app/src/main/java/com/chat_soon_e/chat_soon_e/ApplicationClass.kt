package com.chat_soon_e.chat_soon_e

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.chat_soon_e.chat_soon_e.config.XAccessTokenInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

// 앱에서 공통적으로 쓰이는 부분들을 정의해놓은 클래스
// AndroidManifest.xml에서 가장 먼저 실행되도록 해놓았다.
// 따라서 다른 파일에서도 이 안에 정의된 상수, 변수, 메소드 등을 전체적으로 가져와서 활용할 수 있다.
class ApplicationClass : Application() {
    companion object{
        const val X_ACCESS_TOKEN: String = "X-ACCESS-TOKEN"         // JWT Token Key

        // TEMPLATE: Project명
        // Log, SharedPreference
        const val TAG: String = "TEMPLATE-APP"

        // DB: 데이터베이스명
        const val APP_DATABASE = "$TAG-DB"

        const val DEV_URL: String = "http://13.125.121.202/";       // 테스트 서버 주소
        const val PROD_URL: String = "https://api.template.com/"    // 실서버 주소
        const val BASE_URL: String = DEV_URL                        // apk 추출할 때 알맞게 바꾸면[넣어주면] 된다.

        // 전체적으로 쓰일 수 있도록
        lateinit var mSharedPreferences: SharedPreferences
        lateinit var retrofit: Retrofit
    }

    override fun onCreate() {
        super.onCreate()

        // client definition
        // Http 통신할 때 클라이언트 옵션 설정해주는 부분
        val client: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(30000, TimeUnit.MILLISECONDS)  // Timeout 3초 설정
            .connectTimeout(30000, TimeUnit.MILLISECONDS)
            .addNetworkInterceptor(XAccessTokenInterceptor()) // JWT 자동 헤더 전송
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        mSharedPreferences = applicationContext.getSharedPreferences(TAG, Context.MODE_PRIVATE)
    }
}