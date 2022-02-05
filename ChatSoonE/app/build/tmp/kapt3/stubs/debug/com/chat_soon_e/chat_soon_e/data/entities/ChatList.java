package com.chat_soon_e.chat_soon_e.data.entities;

import java.lang.System;

@androidx.room.Entity(tableName = "ChatListTable")
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b/\b\u0087\b\u0018\u00002\u00020\u0001BG\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\rBU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\u000fJ\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u00100\u001a\u00020\bH\u00c6\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u00102\u001a\u00020\u0003H\u00c6\u0003J\t\u00103\u001a\u00020\u0003H\u00c6\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001eJf\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00c6\u0001\u00a2\u0006\u0002\u00106J\u0013\u00107\u001a\u00020\f2\b\u00108\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00109\u001a\u00020\u0003H\u00d6\u0001J\t\u0010:\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u000b\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0015\"\u0004\b*\u0010\u0017R\u001e\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0011\"\u0004\b,\u0010\u0013\u00a8\u0006;"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/data/entities/ChatList;", "", "chatIdx", "", "chat_name", "", "profileImg", "latest_time", "Ljava/util/Date;", "latest_message", "isNew", "isChecked", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;ILjava/lang/Boolean;)V", "viewType", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;IILjava/lang/Boolean;)V", "getChatIdx", "()I", "setChatIdx", "(I)V", "getChat_name", "()Ljava/lang/String;", "setChat_name", "(Ljava/lang/String;)V", "id", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "()Ljava/lang/Boolean;", "setChecked", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setNew", "getLatest_message", "setLatest_message", "getLatest_time", "()Ljava/util/Date;", "setLatest_time", "(Ljava/util/Date;)V", "getProfileImg", "setProfileImg", "getViewType", "setViewType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;IILjava/lang/Boolean;)Lcom/chat_soon_e/chat_soon_e/data/entities/ChatList;", "equals", "other", "hashCode", "toString", "app_debug"})
public final class ChatList {
    private int chatIdx;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String chat_name;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String profileImg;
    @org.jetbrains.annotations.NotNull()
    private java.util.Date latest_time;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String latest_message;
    @androidx.room.Ignore()
    @androidx.room.ColumnInfo(defaultValue = "0")
    private int viewType;
    private int isNew;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(defaultValue = "false")
    private java.lang.Boolean isChecked;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.PrimaryKey(autoGenerate = true)
    private java.lang.Integer id = 0;
    
    @org.jetbrains.annotations.NotNull()
    public final com.chat_soon_e.chat_soon_e.data.entities.ChatList copy(int chatIdx, @org.jetbrains.annotations.Nullable()
    java.lang.String chat_name, @org.jetbrains.annotations.Nullable()
    java.lang.String profileImg, @org.jetbrains.annotations.NotNull()
    java.util.Date latest_time, @org.jetbrains.annotations.Nullable()
    java.lang.String latest_message, int viewType, int isNew, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isChecked) {
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
    
    public ChatList(int chatIdx, @org.jetbrains.annotations.Nullable()
    java.lang.String chat_name, @org.jetbrains.annotations.Nullable()
    java.lang.String profileImg, @org.jetbrains.annotations.NotNull()
    java.util.Date latest_time, @org.jetbrains.annotations.Nullable()
    java.lang.String latest_message, int viewType, int isNew, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isChecked) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getChatIdx() {
        return 0;
    }
    
    public final void setChatIdx(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getChat_name() {
        return null;
    }
    
    public final void setChat_name(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getProfileImg() {
        return null;
    }
    
    public final void setProfileImg(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date getLatest_time() {
        return null;
    }
    
    public final void setLatest_time(@org.jetbrains.annotations.NotNull()
    java.util.Date p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLatest_message() {
        return null;
    }
    
    public final void setLatest_message(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final int component6() {
        return 0;
    }
    
    public final int getViewType() {
        return 0;
    }
    
    public final void setViewType(int p0) {
    }
    
    public final int component7() {
        return 0;
    }
    
    public final int isNew() {
        return 0;
    }
    
    public final void setNew(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isChecked() {
        return null;
    }
    
    public final void setChecked(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    public ChatList(int chatIdx, @org.jetbrains.annotations.Nullable()
    java.lang.String chat_name, @org.jetbrains.annotations.Nullable()
    java.lang.String profileImg, @org.jetbrains.annotations.NotNull()
    java.util.Date latest_time, @org.jetbrains.annotations.Nullable()
    java.lang.String latest_message, int isNew, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isChecked) {
        super();
    }
}