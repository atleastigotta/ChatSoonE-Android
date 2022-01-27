package com.chat_soon_e.chat_soon_e.data.local;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\'J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\fH\'J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\u0006\u0010\u0007\u001a\u00020\fH\'J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u0011"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/data/local/OtherUserDao;", "", "delete", "", "otherUser", "Lcom/chat_soon_e/chat_soon_e/data/entities/OtherUser;", "getOtherUserById", "id", "", "getOtherUserByNameId", "name", "", "", "getOtherUserIdxList", "", "insert", "update", "app_debug"})
public abstract interface OtherUserDao {
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.data.entities.OtherUser otherUser);
    
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.data.entities.OtherUser otherUser);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.data.entities.OtherUser otherUser);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM OtherUserTable WHERE name =:name AND kakao_user_idx =:id")
    public abstract com.chat_soon_e.chat_soon_e.data.entities.OtherUser getOtherUserByNameId(@org.jetbrains.annotations.NotNull()
    java.lang.String name, long id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT OU.other_user_idx FROM OtherUserTable as OU WHERE kakao_user_idx= :id")
    public abstract java.util.List<java.lang.Integer> getOtherUserIdxList(long id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM OtherUserTable WHERE other_user_idx= :id")
    public abstract com.chat_soon_e.chat_soon_e.data.entities.OtherUser getOtherUserById(int id);
}