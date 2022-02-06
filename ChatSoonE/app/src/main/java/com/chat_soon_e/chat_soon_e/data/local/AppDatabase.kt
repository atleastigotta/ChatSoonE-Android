package com.chat_soon_e.chat_soon_e.data.local

import android.content.Context
import androidx.room.*
import com.chat_soon_e.chat_soon_e.ApplicationClass.Companion.APP_DATABASE
import com.chat_soon_e.chat_soon_e.data.entities.*

// 따로 불러와서 작업하는 것들은 만들어두지 않았기 때문에
// RoomDB를 사용해야 된다고 할 때는 추가적으로 설정해줘야 한다.
@Database(entities = [Chat::class, User::class, OtherUser::class,Folder::class,FolderContent::class, ChatList::class,Icon::class, TestChat::class], version = 2)
@TypeConverters(Converter::class)//Data<->Long 변환을 위함, RoomDB Date 지원X
abstract class AppDatabase: RoomDatabase() {
    abstract fun chatDao(): ChatDao
    abstract fun userDao():UserDao
    abstract fun otherUserDao():OtherUserDao
    abstract fun chatListDao():ChatListDao
    abstract fun folderDao(): FolderDao
    abstract fun folderContentDao():FolderContentDao
    abstract fun iconDao(): IconDao
    abstract fun testChatDao(): TestChatDao

    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                synchronized(AppDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        APP_DATABASE
                    ).allowMainThreadQueries().
                    fallbackToDestructiveMigration().build()
                }
            }

            return instance
        }
    }
}