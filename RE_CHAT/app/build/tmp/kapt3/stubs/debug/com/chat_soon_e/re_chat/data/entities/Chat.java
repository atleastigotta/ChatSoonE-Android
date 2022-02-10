package com.chat_soon_e.re_chat.data.entities;

import java.lang.System;

@androidx.room.Entity(tableName = "ChatTable")
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b0\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u000fJ\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\t\u00102\u001a\u00020\u0003H\u00c6\u0003J\t\u00103\u001a\u00020\u0005H\u00c6\u0003J\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\rH\u00c6\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001eJp\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u00108J\u0013\u00109\u001a\u00020\r2\b\u0010:\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010;\u001a\u00020\u0003H\u00d6\u0001J\t\u0010<\u001a\u00020\u0005H\u00d6\u0001R\u001e\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u000e\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0018\"\u0004\b+\u0010\u001aR\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0012\"\u0004\b-\u0010\u0014\u00a8\u0006="}, d2 = {"Lcom/chat_soon_e/re_chat/data/entities/Chat;", "", "otherUserIdx", "", "groupName", "", "message", "postTime", "Ljava/util/Date;", "folderIdx", "status", "viewType", "isChecked", "", "isNew", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/Date;ILjava/lang/String;IZLjava/lang/Integer;)V", "chatIdx", "getChatIdx", "()I", "setChatIdx", "(I)V", "getFolderIdx", "setFolderIdx", "getGroupName", "()Ljava/lang/String;", "setGroupName", "(Ljava/lang/String;)V", "()Z", "setChecked", "(Z)V", "()Ljava/lang/Integer;", "setNew", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMessage", "setMessage", "getOtherUserIdx", "setOtherUserIdx", "getPostTime", "()Ljava/util/Date;", "setPostTime", "(Ljava/util/Date;)V", "getStatus", "setStatus", "getViewType", "setViewType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/Date;ILjava/lang/String;IZLjava/lang/Integer;)Lcom/chat_soon_e/re_chat/data/entities/Chat;", "equals", "other", "hashCode", "toString", "app_debug"})
public final class Chat {
    @com.google.gson.annotations.SerializedName(value = "otherUserIdx")
    private int otherUserIdx;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "groupName")
    private java.lang.String groupName;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "message")
    private java.lang.String message;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "postTime")
    private java.util.Date postTime;
    @com.google.gson.annotations.SerializedName(value = "folderIdx")
    private int folderIdx;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "status")
    private java.lang.String status;
    @com.google.gson.annotations.SerializedName(value = "viewType")
    private int viewType;
    @com.google.gson.annotations.SerializedName(value = "isChecked")
    private boolean isChecked;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer isNew;
    @androidx.room.PrimaryKey(autoGenerate = true)
    @com.google.gson.annotations.SerializedName(value = "chatIdx")
    private int chatIdx = 0;
    
    @org.jetbrains.annotations.NotNull()
    public final com.chat_soon_e.re_chat.data.entities.Chat copy(int otherUserIdx, @org.jetbrains.annotations.Nullable()
    java.lang.String groupName, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.util.Date postTime, int folderIdx, @org.jetbrains.annotations.NotNull()
    java.lang.String status, int viewType, boolean isChecked, @org.jetbrains.annotations.Nullable()
    java.lang.Integer isNew) {
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
    
    public Chat(int otherUserIdx, @org.jetbrains.annotations.Nullable()
    java.lang.String groupName, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.util.Date postTime, int folderIdx, @org.jetbrains.annotations.NotNull()
    java.lang.String status, int viewType, boolean isChecked, @org.jetbrains.annotations.Nullable()
    java.lang.Integer isNew) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getOtherUserIdx() {
        return 0;
    }
    
    public final void setOtherUserIdx(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getGroupName() {
        return null;
    }
    
    public final void setGroupName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMessage() {
        return null;
    }
    
    public final void setMessage(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date getPostTime() {
        return null;
    }
    
    public final void setPostTime(@org.jetbrains.annotations.Nullable()
    java.util.Date p0) {
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int getFolderIdx() {
        return 0;
    }
    
    public final void setFolderIdx(int p0) {
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
    
    public final int component7() {
        return 0;
    }
    
    public final int getViewType() {
        return 0;
    }
    
    public final void setViewType(int p0) {
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final boolean isChecked() {
        return false;
    }
    
    public final void setChecked(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer isNew() {
        return null;
    }
    
    public final void setNew(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    public final int getChatIdx() {
        return 0;
    }
    
    public final void setChatIdx(int p0) {
    }
}