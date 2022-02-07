package com.chat_soon_e.chat_soon_e.data.local;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\'\u00a8\u0006\f"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/data/local/ChatListDao;", "", "delete", "", "chatList", "Lcom/chat_soon_e/chat_soon_e/data/entities/ChatList;", "insert", "update", "updateIsNew", "chatIdx", "", "status", "app_debug"})
public abstract interface ChatListDao {
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.data.entities.ChatList chatList);
    
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.data.entities.ChatList chatList);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.data.entities.ChatList chatList);
    
    @androidx.room.Query(value = "UPDATE ChatListTable SET isNew= :status WHERE chatIdx= :chatIdx")
    public abstract void updateIsNew(int chatIdx, int status);
}