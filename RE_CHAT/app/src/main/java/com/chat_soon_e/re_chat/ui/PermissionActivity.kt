package com.chat_soon_e.re_chat.ui

import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import com.chat_soon_e.re_chat.databinding.ActivityPermissionBinding
import com.chat_soon_e.re_chat.utils.permissionGrantred

class PermissionActivity:BaseActivity<ActivityPermissionBinding>(ActivityPermissionBinding::inflate) {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun initAfterBinding() {

        //페이지 사용 여부 체크
//        val spf=this.getSharedPreferences("firstRun", AppCompatActivity.MODE_PRIVATE)
//        val editor=spf.edit()
//        editor.putInt("check", 1)//이 페이지 사용했다는 정보 남기기, 아니면 체크박스로 더이상 보지 않기 하기?
//        editor.apply()

        //권한 얻기 버튼
        binding.notificationPermissionBtn.setOnClickListener {
            startActivity(Intent( "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"))
            //권한을 얻었다면 서비스 시작
            if(permissionGrantred(this))

                startForegroundService(Intent(this, MyNotificationListener::class.java))
            finish()
        //startActivityWithClear(SplashActivity::class.java)
        }
    }
}