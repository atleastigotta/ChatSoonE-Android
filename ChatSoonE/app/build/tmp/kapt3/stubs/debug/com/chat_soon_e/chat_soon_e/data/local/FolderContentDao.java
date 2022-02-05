package com.chat_soon_e.chat_soon_e.data.local;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\'J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\'J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\'J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\'\u00a8\u0006\u0012"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/data/local/FolderContentDao;", "", "deleteChat", "", "folderIdx", "", "chatIdx", "getAllfolder", "", "Lcom/chat_soon_e/chat_soon_e/data/entities/FolderContent;", "insertChat", "insertOrgChat", "userIdx", "", "groupName", "", "insertOtOChat", "otherUserIdx", "app_debug"})
public abstract interface FolderContentDao {
    
    @androidx.room.Query(value = "INSERT INTO FolderContentTable (folderIdx, chatIdx) VALUES (:folderIdx, :chatIdx)")
    public abstract void insertChat(int folderIdx, int chatIdx);
    
    @androidx.room.Query(value = "INSERT INTO FolderContentTable (folderIdx, chatIdx) SELECT :folderIdx, chatIdx FROM ChatTable WHERE otherUserIdx =:otherUserIdx AND groupName IS NULL")
    public abstract void insertOtOChat(int folderIdx, int otherUserIdx);
    
    @androidx.room.Query(value = "INSERT INTO FolderContentTable (folderIdx, chatIdx) SELECT :folderIdx, chatIdx FROM ChatTable AS C INNER JOIN OtherUserTable AS OU ON C.otherUserIdx =OU.otherUserIdx WHERE OU.kakaoUserIdx= :userIdx AND C.groupName = :groupName")
    public abstract void insertOrgChat(int folderIdx, long userIdx, @org.jetbrains.annotations.NotNull()
    java.lang.String groupName);
    
    @androidx.room.Query(value = "DELETE FROM FolderContentTable WHERE folderIdx= :folderIdx AND chatIdx= :chatIdx")
    public abstract void deleteChat(int folderIdx, int chatIdx);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM foldercontenttable")
    public abstract java.util.List<com.chat_soon_e.chat_soon_e.data.entities.FolderContent> getAllfolder();
}