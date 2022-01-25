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
import com.chat_soon_e.chat_soon_e.data.local.AppDatabase
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
            val millisecond = sbn.postTime//알림 시각, millisecond, 로 받아와지는 값을 변환
            val date = Date(millisecond)
//            val dateFormat = SimpleDateFormat("yyyy-MM-dd kk:mm:ss E", Locale("ko", "KR"))
//            val simpleDate=dateFormat.format(date)
            val largeIcon: Icon? = notification.getLargeIcon()//프사

            // 데이터베이스에 받아온 내용 저장
            //chatDB.chatDao().insert(Chat(null, name.toString(), text.toString(), "f"))
            //그룹 메세지
            //개인 메세지
            //알림 갯수 메세지: name==null, subtext==221개의 안읽은 메세지, largeIcon==null
            if(name!=null){//알림 메세지 제외 저장
                chatDB.chatDao().insert(Chat(10, subText.toString(), name, name+".png", date, date, text.toString(), -1, null, null, "activate"))
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
        //Icon을 Bitmap으로 전환
        fun convertIconToBitmap(icon:Icon): Bitmap {
            val drawable=icon.loadDrawable(this)
            val bitmap=drawable.toBitmap()
            return bitmap
        }
        //Bitmap을 캐시 디렉토리에 저장
        fun saveCache(bitmap:Bitmap, name:String){
            val storage=cacheDir//cacheDir 경로
            var fileName=name//파일 이름
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
        }
        //Bitmap을 캐시 디렉토리로부터 로드
        fun loadBitmap(name: String):Bitmap{
            val file=File(cacheDir.toString())
            val files=file.listFiles()
            var list:String=""
            for (tempFile in files) {
                Log.d("MyTag", tempFile.name)
                //name이 들어가 있는 파일 찾기
                if (tempFile.name.contains(name)) {
                    list=tempFile.name
                }
            }
            val path=cacheDir.toString()+"/"+list
            val bitmap= BitmapFactory.decodeFile(path)
            return bitmap
        }
    }
}