package com.chat_soon_e.chat_soon_e.ui;

import java.lang.System;

@android.annotation.SuppressLint(value = {"CustomSplashScreen"})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\rH\u0002J\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u000f\u001a\u00020\rH\u0002J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\u0012\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\b\u0010\u001c\u001a\u00020\rH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/SplashActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/chat_soon_e/chat_soon_e/ui/SplashView;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "binding", "Lcom/chat_soon_e/chat_soon_e/databinding/ActivitySplashBinding;", "getConnectivityStatus", "", "login", "", "loginPermission", "logout", "onAutoLoginFailure", "code", "", "message", "onAutoLoginLoading", "onAutoLoginSuccess", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "saveUserInfo", "state", "withdraw", "app_debug"})
public final class SplashActivity extends androidx.appcompat.app.AppCompatActivity implements com.chat_soon_e.chat_soon_e.ui.SplashView {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "splashtest";
    private com.chat_soon_e.chat_soon_e.databinding.ActivitySplashBinding binding;
    
    public SplashActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTAG() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void loginPermission() {
    }
    
    private final void login() {
    }
    
    private final void logout() {
    }
    
    private final void withdraw() {
    }
    
    private final void saveUserInfo(java.lang.String state) {
    }
    
    public final boolean getConnectivityStatus() {
        return false;
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    public void onAutoLoginLoading() {
    }
    
    @java.lang.Override()
    public void onAutoLoginSuccess() {
    }
    
    @java.lang.Override()
    public void onAutoLoginFailure(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
}