package com.chat_soon_e.chat_soon_e.ui

import android.app.Notification
import android.os.Build
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log
import androidx.annotation.RequiresApi
import com.chat_soon_e.chat_soon_e.data.entities.Chat
import com.chat_soon_e.chat_soon_e.data.local.AppDatabase
import java.text.SimpleDateFormat
import java.util.*

@RequiresApi(Build.VERSION_CODES.M)
class MyNotificationListener: NotificationListenerService() {
    private lateinit var chatDB: AppDatabase
    val TAG = "NotificationListener"

    override fun onListenerConnected() {
        super.onListenerConnected()
        Log.d(TAG, "onListenerConnected")
    }

    // 새로운 알림 올 때마다 발생한다.
    override fun onNotificationPosted(sbn: StatusBarNotification) {
        super.onNotificationPosted(sbn)
        val notification: Notification = sbn.notification
        val packageName:String=sbn.packageName

        if(packageName != null && packageName == "com.kakao.talk") {
            // 데이터베이스 연결
            chatDB = AppDatabase.getInstance(this)!!

            val extras = sbn.notification.extras
            val name = extras.getString(Notification.EXTRA_TITLE)
            val text = extras.getCharSequence(Notification.EXTRA_TEXT)
            val subText = extras.getCharSequence(Notification.EXTRA_SUB_TEXT)

            // millisecond로 받아와지는 값을 변환
            val millisecond = sbn.postTime
            val date = Date(millisecond)
            val dateFormat = SimpleDateFormat("yyyy-MM-dd kk:mm:ss E", Locale("ko", "KR"))
            val dateString = dateFormat.format(dateFormat)

            // 사진 저장, value icon (아직 확인 X)
            // val smallIcon: Icon = notification.smallIcon()//이거는 확인 안함, 사진 저장, value icon
            // val largeIcon: Icon = notification.getLargeIcon()

            // 데이터베이스에 받아온 내용 저장
            chatDB.chatDao().insert(Chat(null, name.toString(), text.toString(), dateString))

            Log.d(
                TAG, "onNotificationPosted ~ " +
                        " packageName: " + sbn.packageName + // 앱 이름
                        " id: " + sbn.id + // id
                        " postTime: " + dateString +
                        " name: " + name + // 이름
                        " text : " + text // 내용
                        + "subtext: "+ subText // 그룹 채팅방 일때 그룹명
            )
        }
    }
}