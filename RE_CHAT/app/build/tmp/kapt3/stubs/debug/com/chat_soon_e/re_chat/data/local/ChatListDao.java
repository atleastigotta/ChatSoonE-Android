package com.chat_soon_e.re_chat.data.local;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\'\u00a8\u0006\u000e"}, d2 = {"Lcom/chat_soon_e/re_chat/data/local/ChatListDao;", "", "delete", "", "chatList", "Lcom/chat_soon_e/re_chat/data/entities/ChatList;", "getChatList", "", "insert", "update", "updateIsNew", "chatIdx", "", "status", "app_debug"})
public abstract interface ChatListDao {
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.re_chat.data.entities.ChatList chatList);
    
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.re_chat.data.entities.ChatList chatList);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.re_chat.data.entities.ChatList chatList);
    
    @androidx.room.Query(value = "UPDATE ChatListTable SET isNew= :status WHERE chatIdx= :chatIdx")
    public abstract void updateIsNew(int chatIdx, int status);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM ChatListTable")
    public abstract java.util.List<com.chat_soon_e.re_chat.data.entities.ChatList> getChatList();
}