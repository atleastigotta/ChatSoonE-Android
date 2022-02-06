package com.chat_soon_e.chat_soon_e.ui

import android.app.Notification
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Icon
import android.os.Build
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.graphics.drawable.toBitmap
import com.chat_soon_e.chat_soon_e.data.entities.Chat
import com.chat_soon_e.chat_soon_e.data.entities.OtherUser
import com.chat_soon_e.chat_soon_e.data.local.AppDatabase
import com.chat_soon_e.chat_soon_e.data.remote.auth.USER_ID
import com.chat_soon_e.chat_soon_e.utils.getID
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

@RequiresApi(Build.VERSION_CODES.M)
class MyNotificationListener: NotificationListenerService() {
    private lateinit var chatDB: AppDatabase
    val TAG = "NotificationListener"
    private lateinit var database: AppDatabase

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
            val name = extras.getString(Notification.EXTRA_TITLE)//발신자
            val text = extras.getCharSequence(Notification.EXTRA_TEXT)//내용
            val subText = extras.getCharSequence(Notification.EXTRA_SUB_TEXT)//그룹톡일 경우
            //postTime, mill->Date 변환
            val millisecond = sbn.postTime
            val date = Date(millisecond)
            //Icon, cache에 png 전환 후 저장
            val largeIcon: Icon? = notification.getLargeIcon()

            //알림 메세지(264개의 메세지 등) 제외 대화 내용 DB 저장
            //음악 메세지(id==2016) 차단
            if(name!=null && sbn.id!=2016){
                database= AppDatabase.getInstance(this)!!
                var otherUser=database.otherUserDao().getOtherUserByNameId(name.toString(), getID())
                //이미 있던 유저인지 확인

                //이미 있던 유저라면 Chat 만 추가
                if(otherUser!=null){
                    database.chatDao().insert(Chat(otherUser.otherUserIdx, subText.toString(),text.toString(), date, -1, "activate" ))
                    Log.d(TAG,database.chatDao().getChatByIdx(otherUser.otherUserIdx).toString())
                }else{//새로운 유저라면 otherUser, Chat 저장, 사진 이름(image): otherUser.name_postTime.millsecond.png
                    var fileName:String=""
                    if(largeIcon!=null){
                        fileName=saveCache(convertIconToBitmap(largeIcon), name+"_"+millisecond.toString())
                    }
                    database.otherUserDao().insert(OtherUser(name.toString(), fileName, "activate", getID()))
                    val other=database.otherUserDao().getOtherUserByNameId(name.toString(), getID())
                    database.chatDao().insert(Chat(other.otherUserIdx, subText.toString(),text.toString(), date, -1, "activate"))
                    Log.d(TAG, "database: "+database.chatDao().getChatByIdx(other.otherUserIdx).toString())
                }
            }
            Log.d(
                TAG, "onNotificationPosted ~ " +
                        " id: " + sbn.id +
                        " name: " + name +
                        " text : " + text
                        + "subtext: "+ subText+
                        "postTime: "+date.toString()
            )
        }

    }
    //Icon을 Bitmap으로 전환
    private fun convertIconToBitmap(icon:Icon): Bitmap {
        val drawable=icon.loadDrawable(this)
        val bitmap=drawable.toBitmap()
        return bitmap
    }
    //Bitmap을 캐시 디렉토리에 저장, 파일 이름 저장
    private fun saveCache(bitmap:Bitmap, name:String):String{
        val storage=cacheDir//cacheDir 경로
        val tempFile= File(storage, name)
        try{
            tempFile.createNewFile()
            val out= FileOutputStream(tempFile)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
            out.close()

        }catch (e: FileNotFoundException){
            Log.e("MyTag","FileNotFoundException : " + e.message);
        }catch (e: IOException) {
            Log.e("MyTag", "IOException : " + e.message)
        }
        return name
    }
}