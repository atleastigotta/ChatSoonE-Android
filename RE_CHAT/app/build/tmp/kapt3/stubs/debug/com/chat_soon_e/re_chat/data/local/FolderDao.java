package com.chat_soon_e.re_chat.data.local;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\'J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\'J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\u000e\u001a\u00020\u000bH\'J$\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\r0\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\u000e\u001a\u00020\u000bH\'J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\rH\'J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\u0017\u001a\u00020\u0013H\'J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0007H\'J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0007H\'J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\'J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0005H\'\u00a8\u0006\u001e"}, d2 = {"Lcom/chat_soon_e/re_chat/data/local/FolderDao;", "", "delete", "", "folderIdx", "", "getFolderByIdx", "Lcom/chat_soon_e/re_chat/data/entities/Folder;", "idx", "getFolderByName", "folderName", "", "getFolderByStatus", "", "status", "getFolderChats", "Landroidx/lifecycle/LiveData;", "Lcom/chat_soon_e/re_chat/data/entities/Chat;", "user_id", "", "getFolderExceptDeletedFolder", "getFolderList", "getHiddenFolder", "kakaoUserIdx", "insert", "folder", "update", "updateFolderImgByIdx", "folderImg", "updateStatusByIdx", "app_debug"})
public abstract interface FolderDao {
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.re_chat.data.entities.Folder folder);
    
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.re_chat.data.entities.Folder folder);
    
    @androidx.room.Query(value = "DELETE FROM FolderTable WHERE idx = :folderIdx")
    public abstract void delete(int folderIdx);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM FolderTable ")
    public abstract java.util.List<com.chat_soon_e.re_chat.data.entities.Folder> getFolderList();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM FolderTable WHERE kakaoUserIdx = :kakaoUserIdx AND status = \"HIDDEN\"")
    public abstract java.util.List<com.chat_soon_e.re_chat.data.entities.Folder> getHiddenFolder(long kakaoUserIdx);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM FolderTable WHERE idx = :idx")
    public abstract com.chat_soon_e.re_chat.data.entities.Folder getFolderByIdx(int idx);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM FolderTable WHERE folderName = :folderName")
    public abstract com.chat_soon_e.re_chat.data.entities.Folder getFolderByName(@org.jetbrains.annotations.NotNull()
    java.lang.String folderName);
    
    @androidx.room.Query(value = "UPDATE FolderTable SET status = :status WHERE idx = :idx")
    public abstract void updateStatusByIdx(@org.jetbrains.annotations.NotNull()
    java.lang.String status, int idx);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM FolderTable WHERE status = :status")
    public abstract java.util.List<com.chat_soon_e.re_chat.data.entities.Folder> getFolderByStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String status);
    
    @androidx.room.Query(value = "UPDATE FolderTable SET folderImg = :folderImg WHERE idx = :idx")
    public abstract void updateFolderImgByIdx(int folderImg, int idx);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT C.postTime, C.folderIdx, C.chatIdx, C.otherUserIdx, C.isChecked, C.message, C.groupName, C.status, C.isNew, C.viewType FROM ChatTable C INNER JOIN OtherUserTable OU ON C.otherUserIdx=OU.otherUserIdx INNER JOIN FolderContentTable FC ON C.chatIdx=FC.chatIdx INNER JOIN FolderTable F ON FC.folderIdx=F.idx WHERE OU.kakaoUserIdx= :user_id AND FC.folderIdx=:folderIdx ORDER BY C.postTime DESC")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.chat_soon_e.re_chat.data.entities.Chat>> getFolderChats(long user_id, int folderIdx);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM FolderTable WHERE status != :status")
    public abstract java.util.List<com.chat_soon_e.re_chat.data.entities.Folder> getFolderExceptDeletedFolder(@org.jetbrains.annotations.NotNull()
    java.lang.String status);
}