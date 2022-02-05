package com.chat_soon_e.chat_soon_e.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003\u001e\u001f B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0003J\b\u0010\u0016\u001a\u00020\u0013H\u0003J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0017J\b\u0010\u001c\u001a\u00020\u0013H\u0015J\b\u0010\u001d\u001a\u00020\u0011H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/MainActivity;", "Lcom/chat_soon_e/chat_soon_e/ui/BaseActivity;", "Lcom/chat_soon_e/chat_soon_e/databinding/ActivityMainBinding;", "Lcom/google/android/material/navigation/NavigationView$OnNavigationItemSelectedListener;", "()V", "chatList", "Ljava/util/ArrayList;", "Lcom/chat_soon_e/chat_soon_e/data/entities/Chat;", "chatViewModel", "Lcom/chat_soon_e/chat_soon_e/ui/ChatViewModel;", "getChatViewModel", "()Lcom/chat_soon_e/chat_soon_e/ui/ChatViewModel;", "chatViewModel$delegate", "Lkotlin/Lazy;", "mainRVAdapter", "Lcom/chat_soon_e/chat_soon_e/ui/MainRVAdapter;", "permission", "", "initAfterBinding", "", "initChatList", "initClickListener", "initDrawerLayout", "initRecyclerView", "onBackPressed", "onNavigationItemSelected", "item", "Landroid/view/MenuItem;", "onStart", "permissionGrantred", "PopupFolderMenuListener", "PopupMenuListener", "VerticalSpaceItemDecoration", "app_debug"})
public final class MainActivity extends com.chat_soon_e.chat_soon_e.ui.BaseActivity<com.chat_soon_e.chat_soon_e.databinding.ActivityMainBinding> implements com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener {
    private com.chat_soon_e.chat_soon_e.ui.MainRVAdapter mainRVAdapter;
    private java.util.ArrayList<com.chat_soon_e.chat_soon_e.data.entities.Chat> chatList;
    private boolean permission = true;
    private final kotlin.Lazy chatViewModel$delegate = null;
    
    public MainActivity() {
        super(null);
    }
    
    private final com.chat_soon_e.chat_soon_e.ui.ChatViewModel getChatViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void initAfterBinding() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @java.lang.Override()
    protected void onStart() {
    }
    
    private final boolean permissionGrantred() {
        return false;
    }
    
    private final void initChatList() {
    }
    
    private final void initRecyclerView() {
    }
    
    @android.annotation.SuppressLint(value = {"UseSwitchCompatOrMaterialCode"})
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
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/MainActivity$PopupMenuListener;", "Landroid/widget/PopupMenu$OnMenuItemClickListener;", "(Lcom/chat_soon_e/chat_soon_e/ui/MainActivity;)V", "onMenuItemClick", "", "item", "Landroid/view/MenuItem;", "app_debug"})
    public final class PopupMenuListener implements android.widget.PopupMenu.OnMenuItemClickListener {
        
        public PopupMenuListener() {
            super();
        }
        
        @java.lang.Override()
        public boolean onMenuItemClick(@org.jetbrains.annotations.Nullable()
        android.view.MenuItem item) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/MainActivity$PopupFolderMenuListener;", "Landroid/widget/PopupMenu$OnMenuItemClickListener;", "(Lcom/chat_soon_e/chat_soon_e/ui/MainActivity;)V", "onMenuItemClick", "", "item", "Landroid/view/MenuItem;", "app_debug"})
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
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/MainActivity$VerticalSpaceItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "verticalSpaceHeight", "", "(Lcom/chat_soon_e/chat_soon_e/ui/MainActivity;I)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "app_debug"})
    public final class VerticalSpaceItemDecoration extends androidx.recyclerview.widget.RecyclerView.ItemDecoration {
        private final int verticalSpaceHeight = 0;
        
        public VerticalSpaceItemDecoration(int verticalSpaceHeight) {
            super();
        }
        
        @java.lang.Override()
        public void getItemOffsets(@org.jetbrains.annotations.NotNull()
        android.graphics.Rect outRect, @org.jetbrains.annotations.NotNull()
        android.view.View view, @org.jetbrains.annotations.NotNull()
        androidx.recyclerview.widget.RecyclerView parent, @org.jetbrains.annotations.NotNull()
        androidx.recyclerview.widget.RecyclerView.State state) {
        }
    }
}