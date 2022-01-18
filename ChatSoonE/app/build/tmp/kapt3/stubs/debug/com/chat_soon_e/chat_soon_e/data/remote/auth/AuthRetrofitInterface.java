package com.chat_soon_e.chat_soon_e.data.remote.auth;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\'J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\'\u00a8\u0006\t"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/data/remote/auth/AuthRetrofitInterface;", "", "autoLogin", "Lretrofit2/Call;", "Lcom/chat_soon_e/chat_soon_e/data/remote/auth/AuthResponse;", "login", "user", "Lcom/chat_soon_e/chat_soon_e/data/entities/User;", "signUp", "app_debug"})
public abstract interface AuthRetrofitInterface {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/users")
    public abstract retrofit2.Call<com.chat_soon_e.chat_soon_e.data.remote.auth.AuthResponse> signUp(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.chat_soon_e.chat_soon_e.data.entities.User user);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/users/login")
    public abstract retrofit2.Call<com.chat_soon_e.chat_soon_e.data.remote.auth.AuthResponse> login(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.chat_soon_e.chat_soon_e.data.entities.User user);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/users/auto-login")
    public abstract retrofit2.Call<com.chat_soon_e.chat_soon_e.data.remote.auth.AuthResponse> autoLogin();
}