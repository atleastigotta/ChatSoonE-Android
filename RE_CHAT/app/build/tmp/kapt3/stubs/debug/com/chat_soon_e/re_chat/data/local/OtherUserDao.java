package com.chat_soon_e.re_chat.data.local;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\b\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u000bH\'J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\'J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\u0006\u0010\b\u001a\u00020\tH\'J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u0012"}, d2 = {"Lcom/chat_soon_e/re_chat/data/local/OtherUserDao;", "", "delete", "", "otherUser", "Lcom/chat_soon_e/re_chat/data/entities/OtherUser;", "getAllOtherUser", "", "id", "", "getOtherUserById", "", "getOtherUserByNameId", "name", "", "getOtherUserIdxList", "insert", "update", "app_debug"})
public abstract interface OtherUserDao {
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.re_chat.data.entities.OtherUser otherUser);
    
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.re_chat.data.entities.OtherUser otherUser);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.re_chat.data.entities.OtherUser otherUser);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM OtherUserTable WHERE nickname =:name AND kakaoUserIdx =:id")
    public abstract com.chat_soon_e.re_chat.data.entities.OtherUser getOtherUserByNameId(@org.jetbrains.annotations.NotNull()
    java.lang.String name, long id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT OU.otherUserIdx FROM OtherUserTable as OU WHERE kakaoUserIdx= :id")
    public abstract java.util.List<java.lang.Integer> getOtherUserIdxList(long id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM OtherUserTable WHERE otherUserIdx= :id")
    public abstract com.chat_soon_e.re_chat.data.entities.OtherUser getOtherUserById(int id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM OtherUserTable WHERE kakaoUserIdx= :id")
    public abstract java.util.List<com.chat_soon_e.re_chat.data.entities.OtherUser> getAllOtherUser(long id);
}