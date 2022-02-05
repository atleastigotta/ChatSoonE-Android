package com.chat_soon_e.chat_soon_e.data.entities;

import java.lang.System;

@androidx.room.Entity(tableName = "FolderTable")
<<<<<<< HEAD
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\nJ\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0005H\u00c6\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001bJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003JD\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010\'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010+\u001a\u00020\u0007H\u00d6\u0001J\t\u0010,\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013\u00a8\u0006-"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/data/entities/Folder;", "", "folderName", "", "kakaoUserIdx", "", "parentFolderIdx", "", "folderImg", "status", "(Ljava/lang/String;JLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "folderIdx", "getFolderIdx", "()I", "setFolderIdx", "(I)V", "getFolderImg", "()Ljava/lang/String;", "setFolderImg", "(Ljava/lang/String;)V", "getFolderName", "setFolderName", "getKakaoUserIdx", "()J", "setKakaoUserIdx", "(J)V", "getParentFolderIdx", "()Ljava/lang/Integer;", "setParentFolderIdx", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getStatus", "setStatus", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;JLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/chat_soon_e/chat_soon_e/data/entities/Folder;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class Folder {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "folderName")
    private java.lang.String folderName;
    @com.google.gson.annotations.SerializedName(value = "kakaoUserIdx")
    private long kakaoUserIdx;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "parentFolderIdx")
    private java.lang.Integer parentFolderIdx;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "folderImg")
    private java.lang.String folderImg;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "status")
    private java.lang.String status;
    @androidx.room.PrimaryKey(autoGenerate = true)
    @com.google.gson.annotations.SerializedName(value = "folderIdx")
    private int folderIdx = 0;
    
    @org.jetbrains.annotations.NotNull()
    public final com.chat_soon_e.chat_soon_e.data.entities.Folder copy(@org.jetbrains.annotations.NotNull()
    java.lang.String folderName, long kakaoUserIdx, @org.jetbrains.annotations.Nullable()
    java.lang.Integer parentFolderIdx, @org.jetbrains.annotations.Nullable()
    java.lang.String folderImg, @org.jetbrains.annotations.NotNull()
    java.lang.String status) {
=======
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\'\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\fJ\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\t\u0010\'\u001a\u00020\u0007H\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003Jd\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001\u00a2\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00101\u001a\u00020\u0003H\u00d6\u0001J\t\u00102\u001a\u00020\u0007H\u00d6\u0001R \u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000e\"\u0004\b!\u0010\u0010R \u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010\u0010\u00a8\u00063"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/data/entities/Folder;", "", "idx", "", "kakaoUserIdx", "parentFolderIdx", "folderName", "", "folderImg", "status", "createdAt", "updatedAt", "(IILjava/lang/Integer;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCreatedAt", "()Ljava/lang/String;", "setCreatedAt", "(Ljava/lang/String;)V", "getFolderImg", "()I", "setFolderImg", "(I)V", "getFolderName", "setFolderName", "getIdx", "setIdx", "getKakaoUserIdx", "setKakaoUserIdx", "getParentFolderIdx", "()Ljava/lang/Integer;", "setParentFolderIdx", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getStatus", "setStatus", "getUpdatedAt", "setUpdatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(IILjava/lang/Integer;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/chat_soon_e/chat_soon_e/data/entities/Folder;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class Folder {
    @androidx.room.PrimaryKey(autoGenerate = false)
    @com.google.gson.annotations.SerializedName(value = "folderIdx")
    private int idx;
    @com.google.gson.annotations.SerializedName(value = "kakaoUserIdx")
    private int kakaoUserIdx;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "parentFolderIdx")
    private java.lang.Integer parentFolderIdx;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "folderName")
    private java.lang.String folderName;
    @com.google.gson.annotations.SerializedName(value = "folderImg")
    private int folderImg;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "status")
    private java.lang.String status;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "createdAt")
    private java.lang.String createdAt;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "updatedAt")
    private java.lang.String updatedAt;
    
    @org.jetbrains.annotations.NotNull()
    public final com.chat_soon_e.chat_soon_e.data.entities.Folder copy(int idx, int kakaoUserIdx, @org.jetbrains.annotations.Nullable()
    java.lang.Integer parentFolderIdx, @org.jetbrains.annotations.NotNull()
    java.lang.String folderName, int folderImg, @org.jetbrains.annotations.NotNull()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String updatedAt) {
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
<<<<<<< HEAD
    public Folder(@org.jetbrains.annotations.NotNull()
    java.lang.String folderName, long kakaoUserIdx, @org.jetbrains.annotations.Nullable()
    java.lang.Integer parentFolderIdx, @org.jetbrains.annotations.Nullable()
    java.lang.String folderImg, @org.jetbrains.annotations.NotNull()
    java.lang.String status) {
=======
    public Folder(int idx, int kakaoUserIdx, @org.jetbrains.annotations.Nullable()
    java.lang.Integer parentFolderIdx, @org.jetbrains.annotations.NotNull()
    java.lang.String folderName, int folderImg, @org.jetbrains.annotations.NotNull()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String updatedAt) {
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFolderName() {
        return null;
    }
    
    public final void setFolderName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final long component2() {
        return 0L;
    }
    
    public final long getKakaoUserIdx() {
        return 0L;
    }
    
    public final void setKakaoUserIdx(long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getParentFolderIdx() {
        return null;
    }
    
    public final void setParentFolderIdx(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFolderImg() {
        return null;
    }
    
    public final void setFolderImg(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getKakaoUserIdx() {
        return 0;
    }
    
    public final void setKakaoUserIdx(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getParentFolderIdx() {
        return null;
    }
    
    public final void setParentFolderIdx(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
<<<<<<< HEAD
    public final java.lang.String component5() {
=======
    public final java.lang.String component4() {
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
<<<<<<< HEAD
    public final java.lang.String getStatus() {
        return null;
    }
    
    public final void setStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getFolderIdx() {
        return 0;
    }
    
    public final void setFolderIdx(int p0) {
=======
    public final java.lang.String getFolderName() {
        return null;
    }
    
    public final void setFolderName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int getFolderImg() {
        return 0;
    }
    
    public final void setFolderImg(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatus() {
        return null;
    }
    
    public final void setStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCreatedAt() {
        return null;
    }
    
    public final void setCreatedAt(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUpdatedAt() {
        return null;
    }
    
    public final void setUpdatedAt(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
    }
}