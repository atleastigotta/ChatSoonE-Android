package com.chat_soon_e.re_chat.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001-B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0003J\b\u0010\u001d\u001a\u00020\u001cH\u0003J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u001cH\u0016J\u0012\u0010\"\u001a\u00020\u001c2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\'H\u0017J\b\u0010(\u001a\u00020\u001cH\u0015J\b\u0010)\u001a\u00020\u001cH\u0003J\f\u0010*\u001a\u00020+*\u00020,H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/chat_soon_e/re_chat/ui/MainActivity;", "Lcom/google/android/material/navigation/NavigationView$OnNavigationItemSelectedListener;", "Lcom/skydoves/transformationlayout/TransformationAppCompatActivity;", "()V", "appDB", "Lcom/chat_soon_e/re_chat/data/local/AppDatabase;", "binding", "Lcom/chat_soon_e/re_chat/databinding/ActivityMainBinding;", "chatList", "Ljava/util/ArrayList;", "Lcom/chat_soon_e/re_chat/data/entities/ChatList;", "chatViewModel", "Lcom/chat_soon_e/re_chat/ui/ChatViewModel;", "getChatViewModel", "()Lcom/chat_soon_e/re_chat/ui/ChatViewModel;", "chatViewModel$delegate", "Lkotlin/Lazy;", "folderList", "Lcom/chat_soon_e/re_chat/data/entities/Folder;", "iconList", "Lcom/chat_soon_e/re_chat/data/entities/Icon;", "mPopupWindow", "Landroid/widget/PopupWindow;", "mainRVAdapter", "Lcom/chat_soon_e/re_chat/ui/MainRVAdapter;", "permission", "", "initClickListener", "", "initDrawerLayout", "initFolder", "initIcon", "initRecyclerView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNavigationItemSelected", "item", "Landroid/view/MenuItem;", "onStart", "popupWindowToFolderMenu", "currentWindowMetricsPointCompat", "Landroid/graphics/Point;", "Landroid/view/WindowManager;", "PopupWindowDismissListener", "app_debug"})
public final class MainActivity extends com.skydoves.transformationlayout.TransformationAppCompatActivity implements com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener {
    private com.chat_soon_e.re_chat.databinding.ActivityMainBinding binding;
    private com.chat_soon_e.re_chat.data.local.AppDatabase appDB;
    private java.util.ArrayList<com.chat_soon_e.re_chat.data.entities.Icon> iconList;
    private java.util.ArrayList<com.chat_soon_e.re_chat.data.entities.Folder> folderList;
    private java.util.ArrayList<com.chat_soon_e.re_chat.data.entities.ChatList> chatList;
    private com.chat_soon_e.re_chat.ui.MainRVAdapter mainRVAdapter;
    private boolean permission = true;
    private final kotlin.Lazy chatViewModel$delegate = null;
    private android.widget.PopupWindow mPopupWindow;
    
    public MainActivity() {
        super();
    }
    
    private final com.chat_soon_e.re_chat.ui.ChatViewModel getChatViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @java.lang.Override()
    protected void onStart() {
    }
    
    private final void initIcon() {
    }
    
    private final void initFolder() {
    }
    
    private final void initRecyclerView() {
    }
    
    @android.annotation.SuppressLint(value = {"UseSwitchCompatOrMaterialCode"})
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    private final void initDrawerLayout() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @java.lang.Override()
    public boolean onNavigationItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    private final void initClickListener() {
    }
    
    @android.annotation.SuppressLint(value = {"InflateParams"})
    private final void popupWindowToFolderMenu() {
    }
    
    private final android.graphics.Point currentWindowMetricsPointCompat(android.view.WindowManager $this$currentWindowMetricsPointCompat) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/chat_soon_e/re_chat/ui/MainActivity$PopupWindowDismissListener;", "Landroid/widget/PopupWindow$OnDismissListener;", "(Lcom/chat_soon_e/re_chat/ui/MainActivity;)V", "onDismiss", "", "app_debug"})
    public final class PopupWindowDismissListener implements android.widget.PopupWindow.OnDismissListener {
        
        public PopupWindowDismissListener() {
            super();
        }
        
        @java.lang.Override()
        public void onDismiss() {
        }
    }
}