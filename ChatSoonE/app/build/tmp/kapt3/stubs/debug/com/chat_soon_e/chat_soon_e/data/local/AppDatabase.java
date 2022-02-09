package com.chat_soon_e.chat_soon_e.data.local;

import java.lang.System;

@androidx.room.TypeConverters(value = {com.chat_soon_e.chat_soon_e.data.local.Converter.class})
<<<<<<< HEAD
@androidx.room.Database(entities = {com.chat_soon_e.chat_soon_e.data.entities.Chat.class, com.chat_soon_e.chat_soon_e.data.entities.User.class, com.chat_soon_e.chat_soon_e.data.entities.OtherUser.class, com.chat_soon_e.chat_soon_e.data.entities.Folder.class, com.chat_soon_e.chat_soon_e.data.entities.FolderContent.class, com.chat_soon_e.chat_soon_e.data.entities.ChatList.class, com.chat_soon_e.chat_soon_e.data.entities.Icon.class}, version = 2)
=======
@androidx.room.Database(entities = {com.chat_soon_e.chat_soon_e.data.entities.Chat.class, com.chat_soon_e.chat_soon_e.data.entities.User.class, com.chat_soon_e.chat_soon_e.data.entities.OtherUser.class, com.chat_soon_e.chat_soon_e.data.entities.Folder.class, com.chat_soon_e.chat_soon_e.data.entities.FolderContent.class, com.chat_soon_e.chat_soon_e.data.entities.ChatList.class, com.chat_soon_e.chat_soon_e.data.entities.Icon.class}, version = 3)
>>>>>>> juyeon
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&\u00a8\u0006\u0012"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/data/local/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "chatDao", "Lcom/chat_soon_e/chat_soon_e/data/local/ChatDao;", "chatListDao", "Lcom/chat_soon_e/chat_soon_e/data/local/ChatListDao;", "folderContentDao", "Lcom/chat_soon_e/chat_soon_e/data/local/FolderContentDao;", "folderDao", "Lcom/chat_soon_e/chat_soon_e/data/local/FolderDao;", "iconDao", "Lcom/chat_soon_e/chat_soon_e/data/local/IconDao;", "otherUserDao", "Lcom/chat_soon_e/chat_soon_e/data/local/OtherUserDao;", "userDao", "Lcom/chat_soon_e/chat_soon_e/data/local/UserDao;", "Companion", "app_debug"})
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
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.chat_soon_e.chat_soon_e.data.local.ChatListDao chatListDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.chat_soon_e.chat_soon_e.data.local.FolderDao folderDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.chat_soon_e.chat_soon_e.data.local.FolderContentDao folderContentDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.chat_soon_e.chat_soon_e.data.local.IconDao iconDao();
    
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