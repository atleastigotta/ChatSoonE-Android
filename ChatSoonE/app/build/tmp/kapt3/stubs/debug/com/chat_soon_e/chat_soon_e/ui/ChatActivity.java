package com.chat_soon_e.chat_soon_e.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\'B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u001f\u001a\u00020 H\u0014J\b\u0010!\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020 H\u0002J\b\u0010#\u001a\u00020 H\u0002J\b\u0010$\u001a\u00020 H\u0002J\b\u0010%\u001a\u00020 H\u0002J\b\u0010&\u001a\u00020 H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0005R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006("}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/ChatActivity;", "Lcom/chat_soon_e/chat_soon_e/ui/BaseActivity;", "Lcom/chat_soon_e/chat_soon_e/databinding/ActivityChatBinding;", "chat", "Lcom/chat_soon_e/chat_soon_e/data/entities/ChatList;", "(Lcom/chat_soon_e/chat_soon_e/data/entities/ChatList;)V", "appDB", "Lcom/chat_soon_e/chat_soon_e/data/local/AppDatabase;", "getChat", "()Lcom/chat_soon_e/chat_soon_e/data/entities/ChatList;", "setChat", "chatList", "Ljava/util/ArrayList;", "Lcom/chat_soon_e/chat_soon_e/data/entities/Chat;", "chatListData", "chatRVAdapter", "Lcom/chat_soon_e/chat_soon_e/ui/ChatRVAdapter;", "fabClose", "Landroid/view/animation/Animation;", "fabOpen", "isAll", "", "isFabOpen", "", "isGroup", "testChatViewModel", "Lcom/chat_soon_e/chat_soon_e/ui/TestChatViewModel;", "getTestChatViewModel", "()Lcom/chat_soon_e/chat_soon_e/ui/TestChatViewModel;", "testChatViewModel$delegate", "Lkotlin/Lazy;", "initAfterBinding", "", "initClickListener", "initData", "initFab", "initRecyclerView", "initTestChat", "onBackPressed", "PopupFolderMenuListener", "app_debug"})
public final class ChatActivity extends com.chat_soon_e.chat_soon_e.ui.BaseActivity<com.chat_soon_e.chat_soon_e.databinding.ActivityChatBinding> {
    @org.jetbrains.annotations.Nullable()
    private com.chat_soon_e.chat_soon_e.data.entities.ChatList chat;
    private boolean isFabOpen = false;
    private android.view.animation.Animation fabOpen;
    private android.view.animation.Animation fabClose;
    private com.chat_soon_e.chat_soon_e.data.local.AppDatabase appDB;
    private java.util.ArrayList<com.chat_soon_e.chat_soon_e.data.entities.Chat> chatList;
    private com.chat_soon_e.chat_soon_e.ui.ChatRVAdapter chatRVAdapter;
    private final kotlin.Lazy testChatViewModel$delegate = null;
    private com.chat_soon_e.chat_soon_e.data.entities.ChatList chatListData;
    private boolean isGroup = false;
    private int isAll = 0;
    
    public ChatActivity(@org.jetbrains.annotations.Nullable()
    com.chat_soon_e.chat_soon_e.data.entities.ChatList chat) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.chat_soon_e.chat_soon_e.data.entities.ChatList getChat() {
        return null;
    }
    
    public final void setChat(@org.jetbrains.annotations.Nullable()
    com.chat_soon_e.chat_soon_e.data.entities.ChatList p0) {
    }
    
    private final com.chat_soon_e.chat_soon_e.ui.TestChatViewModel getTestChatViewModel() {
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
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/ChatActivity$PopupFolderMenuListener;", "Landroid/widget/PopupMenu$OnMenuItemClickListener;", "(Lcom/chat_soon_e/chat_soon_e/ui/ChatActivity;)V", "onMenuItemClick", "", "item", "Landroid/view/MenuItem;", "app_debug"})
    public final class PopupFolderMenuListener implements android.widget.PopupMenu.OnMenuItemClickListener {
        
        public PopupFolderMenuListener() {
            super();
        }
        
        @java.lang.Override()
        public boolean onMenuItemClick(@org.jetbrains.annotations.Nullable()
        android.view.MenuItem item) {
            return false;
        }
    }
}