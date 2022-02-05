package com.chat_soon_e.chat_soon_e.data.entities;

import java.lang.System;

@androidx.room.Entity(tableName = "OtherUserTable")
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0007H\u00c6\u0003J3\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020\u0014H\u00d6\u0001J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\n\"\u0004\b\u001a\u0010\f\u00a8\u0006%"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/data/entities/OtherUser;", "", "nickname", "", "image", "status", "kakaoUserIdx", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getImage", "()Ljava/lang/String;", "setImage", "(Ljava/lang/String;)V", "getKakaoUserIdx", "()J", "setKakaoUserIdx", "(J)V", "getNickname", "setNickname", "otherUserIdx", "", "getOtherUserIdx", "()I", "setOtherUserIdx", "(I)V", "getStatus", "setStatus", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class OtherUser {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "nickname")
    private java.lang.String nickname;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "profileImgUrl")
    private java.lang.String image;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "status")
    private java.lang.String status;
    @com.google.gson.annotations.SerializedName(value = "kakaoUserIdx")
    private long kakaoUserIdx;
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int otherUserIdx = 0;
    
    @org.jetbrains.annotations.NotNull()
    public final com.chat_soon_e.chat_soon_e.data.entities.OtherUser copy(@org.jetbrains.annotations.NotNull()
    java.lang.String nickname, @org.jetbrains.annotations.Nullable()
    java.lang.String image, @org.jetbrains.annotations.NotNull()
    java.lang.String status, long kakaoUserIdx) {
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
    
    public OtherUser(@org.jetbrains.annotations.NotNull()
    java.lang.String nickname, @org.jetbrains.annotations.Nullable()
    java.lang.String image, @org.jetbrains.annotations.NotNull()
    java.lang.String status, long kakaoUserIdx) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNickname() {
        return null;
    }
    
    public final void setNickname(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getImage() {
        return null;
    }
    
    public final void setImage(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatus() {
        return null;
    }
    
    public final void setStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final long component4() {
        return 0L;
    }
    
    public final long getKakaoUserIdx() {
        return 0L;
    }
    
    public final void setKakaoUserIdx(long p0) {
    }
    
    public final int getOtherUserIdx() {
        return 0;
    }
    
    public final void setOtherUserIdx(int p0) {
    }
}