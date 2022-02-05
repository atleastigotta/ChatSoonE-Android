package com.chat_soon_e.chat_soon_e.data.entities;

import java.lang.System;

@androidx.room.Entity(tableName = "ChatTable")
<<<<<<< HEAD
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b0\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u000fJ\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\t\u00102\u001a\u00020\u0003H\u00c6\u0003J\t\u00103\u001a\u00020\u0005H\u00c6\u0003J\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\rH\u00c6\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001eJp\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u00108J\u0013\u00109\u001a\u00020\r2\b\u0010:\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010;\u001a\u00020\u0003H\u00d6\u0001J\t\u0010<\u001a\u00020\u0005H\u00d6\u0001R\u001e\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u000e\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0018\"\u0004\b+\u0010\u001aR\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0012\"\u0004\b-\u0010\u0014\u00a8\u0006="}, d2 = {"Lcom/chat_soon_e/chat_soon_e/data/entities/Chat;", "", "otherUserIdx", "", "groupName", "", "message", "postTime", "Ljava/util/Date;", "folderIdx", "status", "viewType", "isChecked", "", "isNew", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/Date;ILjava/lang/String;IZLjava/lang/Integer;)V", "chatIdx", "getChatIdx", "()I", "setChatIdx", "(I)V", "getFolderIdx", "setFolderIdx", "getGroupName", "()Ljava/lang/String;", "setGroupName", "(Ljava/lang/String;)V", "()Z", "setChecked", "(Z)V", "()Ljava/lang/Integer;", "setNew", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMessage", "setMessage", "getOtherUserIdx", "setOtherUserIdx", "getPostTime", "()Ljava/util/Date;", "setPostTime", "(Ljava/util/Date;)V", "getStatus", "setStatus", "getViewType", "setViewType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/Date;ILjava/lang/String;IZLjava/lang/Integer;)Lcom/chat_soon_e/chat_soon_e/data/entities/Chat;", "equals", "other", "hashCode", "toString", "app_debug"})
=======
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b$\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\'\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\t\u0010*\u001a\u00020\u0005H\u00c6\u0003J\t\u0010+\u001a\u00020\u0007H\u00c6\u0003J\t\u0010,\u001a\u00020\u0005H\u00c6\u0003J\t\u0010-\u001a\u00020\u000fH\u00c6\u0003Ji\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u00c6\u0001J\u0013\u0010/\u001a\u00020\u000f2\b\u00100\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00101\u001a\u00020\u0005H\u00d6\u0001J\t\u00102\u001a\u00020\u0007H\u00d6\u0001R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0018\u00a8\u00063"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/data/entities/Chat;", "", "user_idx", "", "other_user_idx", "", "groupName", "", "message", "postTime", "Ljava/util/Date;", "folderIdx", "status", "viewType", "isChecked", "", "(JILjava/lang/String;Ljava/lang/String;Ljava/util/Date;ILjava/lang/String;IZ)V", "getFolderIdx", "()I", "getGroupName", "()Ljava/lang/String;", "idx", "getIdx", "setIdx", "(I)V", "()Z", "setChecked", "(Z)V", "getMessage", "getOther_user_idx", "getPostTime", "()Ljava/util/Date;", "getStatus", "getUser_idx", "()J", "getViewType", "setViewType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
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
<<<<<<< HEAD
    private java.lang.String status;
=======
    private final java.lang.String status = null;
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
    @com.google.gson.annotations.SerializedName(value = "viewType")
    private int viewType;
    @com.google.gson.annotations.SerializedName(value = "isChecked")
    private boolean isChecked;
<<<<<<< HEAD
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer isNew;
=======
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
    @androidx.room.PrimaryKey(autoGenerate = true)
    @com.google.gson.annotations.SerializedName(value = "chatIdx")
    private int chatIdx = 0;
    
    @org.jetbrains.annotations.NotNull()
<<<<<<< HEAD
    public final com.chat_soon_e.chat_soon_e.data.entities.Chat copy(int otherUserIdx, @org.jetbrains.annotations.Nullable()
    java.lang.String groupName, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.util.Date postTime, int folderIdx, @org.jetbrains.annotations.NotNull()
    java.lang.String status, int viewType, boolean isChecked, @org.jetbrains.annotations.Nullable()
    java.lang.Integer isNew) {
=======
    public final com.chat_soon_e.chat_soon_e.data.entities.Chat copy(long user_idx, int other_user_idx, @org.jetbrains.annotations.Nullable()
    java.lang.String groupName, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.util.Date postTime, int folderIdx, @org.jetbrains.annotations.NotNull()
    java.lang.String status, int viewType, boolean isChecked) {
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
    public Chat(int otherUserIdx, @org.jetbrains.annotations.Nullable()
    java.lang.String groupName, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.util.Date postTime, int folderIdx, @org.jetbrains.annotations.NotNull()
    java.lang.String status, int viewType, boolean isChecked, @org.jetbrains.annotations.Nullable()
    java.lang.Integer isNew) {
=======
    public Chat(long user_idx, int other_user_idx, @org.jetbrains.annotations.Nullable()
    java.lang.String groupName, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.util.Date postTime, int folderIdx, @org.jetbrains.annotations.NotNull()
    java.lang.String status, int viewType, boolean isChecked) {
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
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
<<<<<<< HEAD
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
=======
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
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
<<<<<<< HEAD
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
=======
    public final java.lang.String getMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date component5() {
        return null;
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer isNew() {
        return null;
    }
    
<<<<<<< HEAD
    public final void setNew(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
=======
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatus() {
        return null;
    }
    
    public final int component8() {
        return 0;
    }
    
    public final int getViewType() {
        return 0;
    }
    
    public final void setViewType(int p0) {
    }
    
    public final boolean component9() {
        return false;
    }
    
    public final boolean isChecked() {
        return false;
    }
    
    public final void setChecked(boolean p0) {
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
    }
    
    public final int getChatIdx() {
        return 0;
    }
    
    public final void setChatIdx(int p0) {
    }
}