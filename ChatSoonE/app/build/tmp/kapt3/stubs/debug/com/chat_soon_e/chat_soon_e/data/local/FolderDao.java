package com.chat_soon_e.chat_soon_e.data.local;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\b\u001a\u00020\tH\'J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\r\u001a\u00020\tH\'J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0007H\'J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0007H\'J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\'J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0015H\'\u00a8\u0006\u0018"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/data/local/FolderDao;", "", "delete", "", "folderIdx", "", "getFolderByIdx", "Lcom/chat_soon_e/chat_soon_e/data/entities/Folder;", "userIdx", "", "getFolderList", "", "getHiddenFolder", "kakaoUserIdx", "insert", "folder", "update", "updateFolderActive", "updateFolderHidden", "updateFolderImg", "image", "", "updateFolderName", "folderName", "app_debug"})
public abstract interface FolderDao {
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.data.entities.Folder folder);
    
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.data.entities.Folder folder);
    
    @androidx.room.Query(value = "UPDATE FolderTable SET folderName = :folderName WHERE folderIdx =:folderIdx")
    public abstract void updateFolderName(int folderIdx, @org.jetbrains.annotations.NotNull()
    java.lang.String folderName);
    
    @androidx.room.Query(value = "UPDATE FolderTable SET folderImg = :image WHERE folderIdx =:folderIdx")
    public abstract void updateFolderImg(int folderIdx, @org.jetbrains.annotations.NotNull()
    java.lang.String image);
    
    @androidx.room.Query(value = "UPDATE FolderTable SET status =\"HIDDEN\" WHERE folderIdx =:folderIdx")
    public abstract void updateFolderHidden(int folderIdx);
    
    @androidx.room.Query(value = "UPDATE FolderTable SET status =\"ACTIVE\" WHERE folderIdx= :folderIdx")
    public abstract void updateFolderActive(int folderIdx);
    
    @androidx.room.Query(value = "DELETE FROM FOlderTable WHERE folderIdx = :folderIdx")
    public abstract void delete(int folderIdx);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM FolderTable WHERE kakaoUserIdx = :userIdx AND status != \"HIDDEN\"")
    public abstract java.util.List<com.chat_soon_e.chat_soon_e.data.entities.Folder> getFolderList(long userIdx);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM FolderTable WHERE folderIdx = :folderIdx AND kakaoUserIdx = :userIdx AND status != \"HIDDEN\"")
    public abstract com.chat_soon_e.chat_soon_e.data.entities.Folder getFolderByIdx(long userIdx, int folderIdx);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM FolderTable WHERE kakaoUserIdx = :kakaoUserIdx AND status = \"HIDDEN\"")
    public abstract java.util.List<com.chat_soon_e.chat_soon_e.data.entities.Folder> getHiddenFolder(long kakaoUserIdx);
}