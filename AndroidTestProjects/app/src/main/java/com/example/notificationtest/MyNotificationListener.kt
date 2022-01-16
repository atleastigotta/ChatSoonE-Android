package com.example.notificationtest

import android.app.Notification
import android.graphics.drawable.Icon
import android.os.Build
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log
import android.os.Bundle

import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.M)
class MyNotificationListener:NotificationListenerService() {
    val TAG="NotificationListener"
    override fun onListenerConnected() {
        super.onListenerConnected()
        Log.d(TAG, "onListenerConnected")
    }
    override fun onNotificationPosted(sbn: StatusBarNotification) {//새로운 알림 올때마다 발생
        super.onNotificationPosted(sbn)
        val notification: Notification = sbn.notification
        val packageName:String=sbn.packageName
        if(packageName!=null&&packageName == "com.kakao.talk"){
            val extras = sbn.notification.extras
            val title = extras.getString(Notification.EXTRA_TITLE)
            val text = extras.getCharSequence(Notification.EXTRA_TEXT)
            val subText = extras.getCharSequence(Notification.EXTRA_SUB_TEXT)
//            val smallIcon: Icon = notification.smallIcon()//이거는 확인 안함, 사진 저장, value icon
//            val largeIcon: Icon = notification.getLargeIcon()
            Log.d(
                TAG, "onNotificationPosted ~ " +
                        " packageName: " + sbn.packageName +//앱 이름
                        " id: " + sbn.id +//id
                        " postTime: " + sbn.postTime +//time, currentMill
                        " title: " + title+//이름
                        " text : " + text//내용
                        +"subtext: "+ subText//그룹 채팅방 일때 그룹명
            )
        }

    }

}