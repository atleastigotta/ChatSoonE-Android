package com.chat_soon_e.chat_soon_e.ui;

import java.lang.System;

@androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/MyNotificationListener;", "Landroid/service/notification/NotificationListenerService;", "Lcom/chat_soon_e/chat_soon_e/ui/View/addChatView;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "chatDB", "Lcom/chat_soon_e/chat_soon_e/data/local/AppDatabase;", "database", "convertIconToBitmap", "Landroid/graphics/Bitmap;", "icon", "Landroid/graphics/drawable/Icon;", "onAddChatFailure", "", "code", "", "message", "onAddChatSuccess", "onListenerConnected", "onNotificationPosted", "sbn", "Landroid/service/notification/StatusBarNotification;", "saveCache", "bitmap", "name", "app_debug"})
public final class MyNotificationListener extends android.service.notification.NotificationListenerService implements com.chat_soon_e.chat_soon_e.ui.View.addChatView {
    private com.chat_soon_e.chat_soon_e.data.local.AppDatabase chatDB;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "NotifiLog";
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
    
    @java.lang.Override()
    public void onAddChatSuccess() {
    }
    
    @java.lang.Override()
    public void onAddChatFailure(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
}