package com.chat_soon_e.chat_soon_e.ui;

import java.lang.System;

@androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/MyNotificationListener;", "Landroid/service/notification/NotificationListenerService;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "chatDB", "Lcom/chat_soon_e/chat_soon_e/data/local/AppDatabase;", "database", "convertIconToBitmap", "Landroid/graphics/Bitmap;", "icon", "Landroid/graphics/drawable/Icon;", "onListenerConnected", "", "onNotificationPosted", "sbn", "Landroid/service/notification/StatusBarNotification;", "saveCache", "bitmap", "name", "app_debug"})
public final class MyNotificationListener extends android.service.notification.NotificationListenerService {
    private com.chat_soon_e.chat_soon_e.data.local.AppDatabase chatDB;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "NotificationListener";
    private com.chat_soon_e.chat_soon_e.data.local.AppDatabase database;
    
    public MyNotificationListener() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTAG() {
        return null;
    }
    
    @java.lang.Override()
    public void onListenerConnected() {
    }
    
    @java.lang.Override()
    public void onNotificationPosted(@org.jetbrains.annotations.NotNull()
    android.service.notification.StatusBarNotification sbn) {
    }
    
    private final android.graphics.Bitmap convertIconToBitmap(android.graphics.drawable.Icon icon) {
        return null;
    }
    
    private final java.lang.String saveCache(android.graphics.Bitmap bitmap, java.lang.String name) {
        return null;
    }
}