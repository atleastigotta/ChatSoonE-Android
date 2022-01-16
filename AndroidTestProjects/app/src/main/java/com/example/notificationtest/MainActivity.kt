package com.example.notificationtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationManagerCompat
import android.content.Intent
import com.example.notificationtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (!permissionGrantred()) {//권한 허용이 안되었다면
            val intent = Intent(//권한 허용하는 action을 시작함
                "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"
            )
            startActivity(intent)
        }
    }
    private fun permissionGrantred(): Boolean {//권한 체크
        return NotificationManagerCompat.getEnabledListenerPackages(this).any {
                enabledPackageName ->
            enabledPackageName == packageName
        }
    }
}