package com.chat_soon_e.chat_soon_e.data.local;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H\'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\'J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\'J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0007H\'J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005H\'J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\'J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\'J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\'\u00a8\u0006\u0017"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/data/local/OtherUserDao;", "", "checkOneBlock", "", "userIdx", "", "otherUserIdx", "", "checkOrgBlock", "groupName", "delete", "", "otherUser", "Lcom/chat_soon_e/chat_soon_e/data/entities/OtherUser;", "getAllOtherUser", "", "id", "getOtherUserById", "getOtherUserByNameId", "name", "getOtherUserIdxList", "insert", "update", "app_debug"})
public abstract interface OtherUserDao {
    
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.data.entities.OtherUser otherUser);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.data.entities.OtherUser otherUser);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT OU.otherUserIdx FROM OtherUserTable as OU WHERE kakaoUserIdx= :id")
    public abstract java.util.List<java.lang.Integer> getOtherUserIdxList(long id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM OtherUserTable WHERE otherUserIdx= :id")
    public abstract com.chat_soon_e.chat_soon_e.data.entities.OtherUser getOtherUserById(int id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM OtherUserTable WHERE kakaoUserIdx= :id")
    public abstract java.util.List<com.chat_soon_e.chat_soon_e.data.entities.OtherUser> getAllOtherUser(long id);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT OU.nickname FROM ChatTable C INNER JOIN OtherUserTable OU on C.otherUserIdx = OU.otherUserIdx WHERE OU.kakaoUserIdx =:userIdx AND C.otherUserIdx =:otherUserIdx AND C.groupName == \'null\' AND OU.status==\"BLOCKED\"")
    public abstract java.lang.String checkOneBlock(long userIdx, int otherUserIdx);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT OU.nickname FROM ChatTable C INNER JOIN OtherUserTable OU ON C.otherUserIdx=OU.otherUserIdx WHERE OU.kakaoUserIdx =:userIdx AND C.groupName =:groupName AND C.status = \"BLOCKED\"")
    public abstract java.lang.String checkOrgBlock(long userIdx, @org.jetbrains.annotations.NotNull()
    java.lang.String groupName);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM OtherUserTable WHERE nickname =:name AND kakaoUserIdx =:id")
    public abstract com.chat_soon_e.chat_soon_e.data.entities.OtherUser getOtherUserByNameId(@org.jetbrains.annotations.NotNull()
    java.lang.String name, long id);
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.data.entities.OtherUser otherUser);
}