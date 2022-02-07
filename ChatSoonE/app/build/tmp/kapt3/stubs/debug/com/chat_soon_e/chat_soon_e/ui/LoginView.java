package com.chat_soon_e.chat_soon_e.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/LoginView;", "", "onLoginFailure", "", "code", "", "message", "", "onLoginLoading", "onLoginSuccess", "auth", "Lcom/chat_soon_e/chat_soon_e/data/remote/auth/Auth;", "app_debug"})
public abstract interface LoginView {
    
    public abstract void onLoginLoading();
    
    public abstract void onLoginSuccess(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.data.remote.auth.Auth auth);
    
    public abstract void onLoginFailure(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String message);
}