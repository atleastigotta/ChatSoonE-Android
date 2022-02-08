package com.chat_soon_e.chat_soon_e.data.local;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\'J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\'J \u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\'J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\'\u00a8\u0006\u0014"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/data/local/FolderContentDao;", "", "deleteChat", "", "folderIdx", "", "chatIdx", "getAllfolder", "", "Lcom/chat_soon_e/chat_soon_e/data/entities/FolderContent;", "insert", "folderContent", "insertChat", "insertOrgChat", "userIdx", "", "groupName", "", "insertOtOChat", "otherUserIdx", "app_debug"})
public abstract interface FolderContentDao {
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.data.entities.FolderContent folderContent);
    
    @androidx.room.Query(value = "INSERT INTO FolderContentTable (folderIdx, chatIdx, status) VALUES (:folderIdx, :chatIdx,\'ACTIVE\')")
    public abstract void insertChat(int folderIdx, int chatIdx);
    
    @androidx.room.Query(value = "INSERT INTO FolderContentTable (folderIdx, chatIdx, status) VALUES(:folderIdx, (SELECT chatIdx FROM ChatTable WHERE otherUserIdx =:otherUserIdx AND groupName IS \'null\'),\'ACTIVE\')")
    public abstract void insertOtOChat(int folderIdx, int otherUserIdx);
    
    @androidx.room.Query(value = "INSERT INTO FolderContentTable (folderIdx, chatIdx) VALUES(:folderIdx,(SELECT chatIdx FROM ChatTable AS C INNER JOIN OtherUserTable AS OU ON C.otherUserIdx =OU.otherUserIdx WHERE OU.kakaoUserIdx= :userIdx AND C.groupName = :groupName))")
    public abstract void insertOrgChat(int folderIdx, long userIdx, @org.jetbrains.annotations.NotNull()
    java.lang.String groupName);
    
    @androidx.room.Query(value = "DELETE FROM FolderContentTable WHERE folderIdx= :folderIdx AND chatIdx= :chatIdx")
    public abstract void deleteChat(int folderIdx, int chatIdx);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM foldercontenttable")
    public abstract java.util.List<com.chat_soon_e.chat_soon_e.data.entities.FolderContent> getAllfolder();
}