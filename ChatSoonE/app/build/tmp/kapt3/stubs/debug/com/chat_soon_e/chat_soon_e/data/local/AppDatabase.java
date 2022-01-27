package com.chat_soon_e.chat_soon_e.data.local;

import java.lang.System;

@androidx.room.TypeConverters(value = {com.chat_soon_e.chat_soon_e.data.local.Converter.class})
@androidx.room.Database(entities = {com.chat_soon_e.chat_soon_e.data.entities.Chat.class, com.chat_soon_e.chat_soon_e.data.entities.User.class, com.chat_soon_e.chat_soon_e.data.entities.OtherUser.class}, version = 2)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/data/local/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "chatDao", "Lcom/chat_soon_e/chat_soon_e/data/local/ChatDao;", "otherUserDao", "Lcom/chat_soon_e/chat_soon_e/data/local/OtherUserDao;", "userDao", "Lcom/chat_soon_e/chat_soon_e/data/local/UserDao;", "Companion", "app_debug"})
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final com.chat_soon_e.chat_soon_e.data.local.AppDatabase.Companion Companion = null;
    private static com.chat_soon_e.chat_soon_e.data.local.AppDatabase instance;
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.chat_soon_e.chat_soon_e.data.local.ChatDao chatDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.chat_soon_e.chat_soon_e.data.local.UserDao userDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.chat_soon_e.chat_soon_e.data.local.OtherUserDao otherUserDao();
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/data/local/AppDatabase$Companion;", "", "()V", "instance", "Lcom/chat_soon_e/chat_soon_e/data/local/AppDatabase;", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        @kotlin.jvm.Synchronized()
        public final synchronized com.chat_soon_e.chat_soon_e.data.local.AppDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}