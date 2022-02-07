package com.chat_soon_e.chat_soon_e.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001f\u001a\u00020 H\u0014J\b\u0010!\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020 H\u0002J\b\u0010#\u001a\u00020 H\u0002J\b\u0010$\u001a\u00020 H\u0002J\b\u0010%\u001a\u00020 H\u0002J\b\u0010&\u001a\u00020 H\u0016J\b\u0010\'\u001a\u00020 H\u0003J\f\u0010(\u001a\u00020)*\u00020*H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/ChatActivity;", "Lcom/chat_soon_e/chat_soon_e/ui/BaseActivity;", "Lcom/chat_soon_e/chat_soon_e/databinding/ActivityChatBinding;", "()V", "chatList", "Ljava/util/ArrayList;", "Lcom/chat_soon_e/chat_soon_e/data/entities/Chat;", "chatListData", "Lcom/chat_soon_e/chat_soon_e/data/entities/ChatList;", "chatRVAdapter", "Lcom/chat_soon_e/chat_soon_e/ui/ChatRVAdapter;", "chatViewModel", "Lcom/chat_soon_e/chat_soon_e/ui/ChatViewModel;", "getChatViewModel", "()Lcom/chat_soon_e/chat_soon_e/ui/ChatViewModel;", "chatViewModel$delegate", "Lkotlin/Lazy;", "database", "Lcom/chat_soon_e/chat_soon_e/data/local/AppDatabase;", "fabClose", "Landroid/view/animation/Animation;", "fabOpen", "folderList", "Lcom/chat_soon_e/chat_soon_e/data/entities/Folder;", "isAll", "", "isFabOpen", "", "isGroup", "mPopupWindow", "Landroid/widget/PopupWindow;", "initAfterBinding", "", "initClickListener", "initData", "initFab", "initRecyclerView", "initTestChat", "onBackPressed", "popupWindowToFolderMenu", "currentWindowMetricsPointCompat", "Landroid/graphics/Point;", "Landroid/view/WindowManager;", "app_debug"})
public final class ChatActivity extends com.chat_soon_e.chat_soon_e.ui.BaseActivity<com.chat_soon_e.chat_soon_e.databinding.ActivityChatBinding> {
    private boolean isFabOpen = false;
    private android.view.animation.Animation fabOpen;
    private android.view.animation.Animation fabClose;
    private com.chat_soon_e.chat_soon_e.data.local.AppDatabase database;
    private java.util.ArrayList<com.chat_soon_e.chat_soon_e.data.entities.Folder> folderList;
    private com.chat_soon_e.chat_soon_e.ui.ChatRVAdapter chatRVAdapter;
    private final kotlin.Lazy chatViewModel$delegate = null;
    private android.widget.PopupWindow mPopupWindow;
    private java.util.ArrayList<com.chat_soon_e.chat_soon_e.data.entities.Chat> chatList;
    private com.chat_soon_e.chat_soon_e.data.entities.ChatList chatListData;
    private boolean isGroup = false;
    private int isAll = 0;
    
    public ChatActivity() {
        super(null);
    }
    
    private final com.chat_soon_e.chat_soon_e.ui.ChatViewModel getChatViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void initAfterBinding() {
    }
    
    private final void initTestChat() {
    }
    
    private final void initFab() {
    }
    
    private final void initRecyclerView() {
    }
    
    private final void initClickListener() {
    }
    
    private final void initData() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @android.annotation.SuppressLint(value = {"InflateParams"})
    private final void popupWindowToFolderMenu() {
    }
    
    private final android.graphics.Point currentWindowMetricsPointCompat(android.view.WindowManager $this$currentWindowMetricsPointCompat) {
        return null;
    }
}