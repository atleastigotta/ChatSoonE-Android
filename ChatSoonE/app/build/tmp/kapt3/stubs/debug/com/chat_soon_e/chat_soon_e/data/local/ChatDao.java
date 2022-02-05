package com.chat_soon_e.chat_soon_e.data.local;

import java.lang.System;

@androidx.room.Dao()
<<<<<<< HEAD
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\'J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u000b\u001a\u00020\bH\'J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\'J\u001c\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\n0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\'J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\bH\'\u00a8\u0006\u0016"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/data/local/ChatDao;", "", "delete", "", "chat", "Lcom/chat_soon_e/chat_soon_e/data/entities/Chat;", "getChatByChatIdx", "chatIdx", "", "getChatByIdx", "", "idx", "getChatList", "getRecentChat", "Landroidx/lifecycle/LiveData;", "Lcom/chat_soon_e/chat_soon_e/data/entities/ChatList;", "id", "", "insert", "update", "updateIsNew", "status", "app_debug"})
=======
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\b\u001a\u00020\tH\'J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\f\u001a\u00020\rH\'J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u0010"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/data/local/ChatDao;", "", "delete", "", "chat", "Lcom/chat_soon_e/chat_soon_e/data/entities/Chat;", "getChatByIdx", "", "idx", "", "getChatList", "getRecentChat", "id", "", "insert", "update", "app_debug"})
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
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
    @androidx.room.Query(value = "SELECT * FROM ChatTable WHERE chatIdx = :chatIdx")
    public abstract com.chat_soon_e.chat_soon_e.data.entities.Chat getChatByChatIdx(int chatIdx);
    
    @androidx.room.Query(value = "UPDATE ChatTable SET isNew= :status WHERE chatIdx= :chatIdx")
    public abstract void updateIsNew(int chatIdx, int status);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM ChatTable WHERE otherUserIdx = :idx")
    public abstract java.util.List<com.chat_soon_e.chat_soon_e.data.entities.Chat> getChatByIdx(int idx);
    
    @org.jetbrains.annotations.NotNull()
<<<<<<< HEAD
    @androidx.room.Query(value = "SELECT CL.chatName AS chat_name, CL.profileImg AS profileImg, CL.latestTime AS latest_time, CM.message AS latest_message, CL.isNew AS isNew, CL.chatIdx\nFROM\n(SELECT (CASE WHEN C.groupName == \"null\" THEN OU.nickname ELSE C.groupName END) AS chatName,\n(CASE WHEN C.groupName == \"null\" THEN OU.image ELSE NULL END) AS profileImg, C.isNew AS isNew,C.chatIdx AS chatIdx, MAX(C.postTime) as latestTime\nFROM ChatTable as C INNER JOIN OtherUserTable as OU on C.otherUserIdx = OU.otherUserIdx\nWHERE OU.kakaoUserIdx = :id AND C.status != \'DELETED\'\nGROUP BY chatName, profileImg) AS CL\nINNER JOIN\n(SELECT DISTINCT (CASE WHEN C.groupName == \"null\" THEN OU.nickname ELSE C.groupName END) AS chatName, C.message, C.postTime, C.isNew, C.chatIdx\nFROM ChatTable C INNER JOIN OtherUserTable OU on C.otherUserIdx = OU.otherUserIdx\nWHERE OU.kakaoUserIdx = :id AND C.status != \'DELETED\') CM\nON CL.chatName = CM.chatName AND CL.latestTime = CM.postTime AND CL.isNew=CM.isNew AND CL.chatIdx = CM.chatIdx \nORDER BY latest_time DESC")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.chat_soon_e.chat_soon_e.data.entities.ChatList>> getRecentChat(long id);
=======
    @androidx.room.Query(value = "SELECT * FROM ChatTable WHERE user_idx= :id GROUP BY other_user_idx ORDER BY postTime ASC")
    public abstract java.util.List<com.chat_soon_e.chat_soon_e.data.entities.Chat> getRecentChat(long id);
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM ChatTable")
    public abstract java.util.List<com.chat_soon_e.chat_soon_e.data.entities.Chat> getChatList();
}