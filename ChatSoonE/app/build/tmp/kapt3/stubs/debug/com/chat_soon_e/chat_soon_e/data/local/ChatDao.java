package com.chat_soon_e.chat_soon_e.data.local;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\b\u001a\u00020\tH\'J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\f\u001a\u00020\rH\'J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u0010"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/data/local/ChatDao;", "", "delete", "", "chat", "Lcom/chat_soon_e/chat_soon_e/data/entities/Chat;", "getChatByIdx", "", "idx", "", "getChatList", "getRecentChat", "id", "", "insert", "update", "app_debug"})
public abstract interface ChatDao {
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.data.entities.Chat chat);
    
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.data.entities.Chat chat);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.data.entities.Chat chat);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM ChatTable WHERE other_user_idx = :idx")
    public abstract java.util.List<com.chat_soon_e.chat_soon_e.data.entities.Chat> getChatByIdx(int idx);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM ChatTable WHERE user_idx= :id GROUP BY other_user_idx ORDER BY postTime ASC")
    public abstract java.util.List<com.chat_soon_e.chat_soon_e.data.entities.Chat> getRecentChat(long id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM ChatTable")
    public abstract java.util.List<com.chat_soon_e.chat_soon_e.data.entities.Chat> getChatList();
}