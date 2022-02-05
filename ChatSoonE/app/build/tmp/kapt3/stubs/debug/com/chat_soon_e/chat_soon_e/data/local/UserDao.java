package com.chat_soon_e.chat_soon_e.data.local;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\'J\u0010\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nH\'J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\'\u00a8\u0006\u0010"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/data/local/UserDao;", "", "delete", "", "user", "Lcom/chat_soon_e/chat_soon_e/data/entities/User;", "getUser", "id", "", "getUsers", "", "insert", "update", "updateStatus", "status", "", "app_debug"})
public abstract interface UserDao {
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.data.entities.User user);
    
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.data.entities.User user);
    
    @androidx.room.Query(value = "UPDATE UserTable SET status= :status WHERE idx= :id")
    public abstract void updateStatus(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String status);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.data.entities.User user);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM UserTable WHERE idx= :id")
    public abstract com.chat_soon_e.chat_soon_e.data.entities.User getUser(long id);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM UserTable")
    public abstract java.util.List<com.chat_soon_e.chat_soon_e.data.entities.User> getUsers();
}