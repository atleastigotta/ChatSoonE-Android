package com.chat_soon_e.chat_soon_e.ui

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat
import com.chat_soon_e.chat_soon_e.data.remote.auth.AuthService
import com.chat_soon_e.chat_soon_e.databinding.ActivitySplashBinding
import com.chat_soon_e.chat_soon_e.utils.permissionGrantred

// BaseActivity를 상속받기 때문에 BaseActivity 안에서 onCreate() 실행되면서 자동적으로 뷰 바인딩을 해준다.
// 따라서 SplashActivity에서는 그 코드를 쓸 필요가 없다.
// <> Generic: 아직 정의되지 않은 타입을 정의할 때 사용하는데, 여기서는 이 안에 어떤 뷰 바인딩을 할 것인지를 넣어준다.
class SplashActivity: BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate),
    SplashView {
    // BaseActivity onCreate()에서 바인딩 끝나고 자동적으로 호출이 되게끔 해준다.
    private fun autoLogin() {
        AuthService.autoLogin(this)
    }

    override fun onAutoLoginLoading() {

    }

    override fun onAutoLoginSuccess() {
        startActivityWithClear(MainActivity::class.java)
    }

    override fun onAutoLoginFailure(code: Int, message: String) {
        startActivityWithClear(LoginActivity::class.java)
    }

    override fun initAfterBinding() {

        Handler(Looper.getMainLooper()).postDelayed({
            // autoLogin()
            //최초 실행 때만 권한 얻기 페이지를 뜨게 함, spf을 사용해서 최초 진입인지 아닌지 확인
            val spf=this.getSharedPreferences("firstRun",AppCompatActivity.MODE_PRIVATE)
            Log.d("splashactivityspf", spf.getInt("check", 0).toString())
            if((spf==null) || (spf?.getInt("check", 0)!=1))
                    startNextActivity(PermissionActivity::class.java)
        }, 1000)

        //로그인이 되었다면 로그인은 안뜨게
        //로그인 확인도 spf를 통해 검증
        //
        //데이터 다운이 완료되면 시작하기 버튼 활성화
    }
}