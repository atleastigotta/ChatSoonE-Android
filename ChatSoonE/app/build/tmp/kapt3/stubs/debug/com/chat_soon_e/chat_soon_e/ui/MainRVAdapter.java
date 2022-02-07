package com.chat_soon_e.chat_soon_e.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003789B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0 H\u0007J\b\u0010!\u001a\u00020\u001eH\u0007J\b\u0010\"\u001a\u00020\u001eH\u0007J\b\u0010#\u001a\u00020\u0016H\u0016J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u0016H\u0016J\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00160\tj\b\u0012\u0004\u0012\u00020\u0016`\'J\u0010\u0010(\u001a\u00020)2\u0006\u0010%\u001a\u00020\u0016H\u0002J\u0018\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u0016H\u0017J\u0018\u0010,\u001a\u00020\u00022\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0016H\u0016J\b\u00100\u001a\u00020\u001eH\u0007J\u000e\u00101\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u0016J\u0010\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u0016H\u0007J\u001a\u00104\u001a\u00020\u001e2\b\u00105\u001a\u0004\u0018\u0001062\u0006\u0010%\u001a\u00020\u0016H\u0002R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006:"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/MainRVAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "mItemClickListener", "Lcom/chat_soon_e/chat_soon_e/ui/MainRVAdapter$MyItemClickListener;", "(Landroid/content/Context;Lcom/chat_soon_e/chat_soon_e/ui/MainRVAdapter$MyItemClickListener;)V", "chatList", "Ljava/util/ArrayList;", "Lcom/chat_soon_e/chat_soon_e/data/entities/ChatList;", "getChatList", "()Ljava/util/ArrayList;", "setChatList", "(Ljava/util/ArrayList;)V", "database", "Lcom/chat_soon_e/chat_soon_e/data/local/AppDatabase;", "getDatabase", "()Lcom/chat_soon_e/chat_soon_e/data/local/AppDatabase;", "setDatabase", "(Lcom/chat_soon_e/chat_soon_e/data/local/AppDatabase;)V", "selectedIndex", "", "selectedItemList", "Landroid/util/SparseBooleanArray;", "getSelectedItemList", "()Landroid/util/SparseBooleanArray;", "setSelectedItemList", "(Landroid/util/SparseBooleanArray;)V", "addItem", "", "chats", "", "blockSelectedItemList", "clearSelectedItemList", "getItemCount", "getItemViewType", "position", "getSelectedItem", "Lkotlin/collections/ArrayList;", "isItemSelected", "", "onBindViewHolder", "holder", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "removeSelectedItemList", "setChecked", "setViewType", "currentMode", "toggleItemSelected", "view", "Landroid/view/View;", "ChooseViewHolder", "DefaultViewHolder", "MyItemClickListener", "app_debug"})
public final class MainRVAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private final android.content.Context context = null;
    private final com.chat_soon_e.chat_soon_e.ui.MainRVAdapter.MyItemClickListener mItemClickListener = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.chat_soon_e.chat_soon_e.data.entities.ChatList> chatList;
    private int selectedIndex = -1;
    @org.jetbrains.annotations.NotNull()
    private android.util.SparseBooleanArray selectedItemList;
    @org.jetbrains.annotations.NotNull()
    private com.chat_soon_e.chat_soon_e.data.local.AppDatabase database;
    
    public MainRVAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.ui.MainRVAdapter.MyItemClickListener mItemClickListener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.chat_soon_e.chat_soon_e.data.entities.ChatList> getChatList() {
        return null;
    }
    
    public final void setChatList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.chat_soon_e.chat_soon_e.data.entities.ChatList> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.util.SparseBooleanArray getSelectedItemList() {
        return null;
    }
    
    public final void setSelectedItemList(@org.jetbrains.annotations.NotNull()
    android.util.SparseBooleanArray p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.chat_soon_e.chat_soon_e.data.local.AppDatabase getDatabase() {
        return null;
    }
    
    public final void setDatabase(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.data.local.AppDatabase p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup viewGroup, int viewType) {
        return null;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    public final void removeSelectedItemList() {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void blockSelectedItemList() {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void clearSelectedItemList() {
    }
    
    private final void toggleItemSelected(android.view.View view, int position) {
    }
    
    public final void setChecked(int position) {
    }
    
    private final boolean isItemSelected(int position) {
        return false;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void setViewType(int currentMode) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void addItem(@org.jetbrains.annotations.NotNull()
    java.util.List<com.chat_soon_e.chat_soon_e.data.entities.ChatList> chats) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.Integer> getSelectedItem() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/MainRVAdapter$MyItemClickListener;", "", "onChooseChatClick", "", "view", "Landroid/view/View;", "position", "", "onDefaultChatClick", "chat", "Lcom/chat_soon_e/chat_soon_e/data/entities/ChatList;", "app_debug"})
    public static abstract interface MyItemClickListener {
        
        public abstract void onDefaultChatClick(@org.jetbrains.annotations.NotNull()
        android.view.View view, int position, @org.jetbrains.annotations.NotNull()
        com.chat_soon_e.chat_soon_e.data.entities.ChatList chat);
        
        public abstract void onChooseChatClick(@org.jetbrains.annotations.NotNull()
        android.view.View view, int position);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/MainRVAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/chat_soon_e/chat_soon_e/databinding/ItemChatListDefaultBinding;", "(Lcom/chat_soon_e/chat_soon_e/ui/MainRVAdapter;Lcom/chat_soon_e/chat_soon_e/databinding/ItemChatListDefaultBinding;)V", "bind", "", "chat", "Lcom/chat_soon_e/chat_soon_e/data/entities/ChatList;", "app_debug"})
    public final class DefaultViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.chat_soon_e.chat_soon_e.databinding.ItemChatListDefaultBinding binding = null;
        
        public DefaultViewHolder(@org.jetbrains.annotations.NotNull()
        com.chat_soon_e.chat_soon_e.databinding.ItemChatListDefaultBinding binding) {
            super(null);
        }
        
        @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.chat_soon_e.chat_soon_e.data.entities.ChatList chat) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/MainRVAdapter$ChooseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/chat_soon_e/chat_soon_e/databinding/ItemChatListChooseBinding;", "mItemClickListener", "Lcom/chat_soon_e/chat_soon_e/ui/MainRVAdapter$MyItemClickListener;", "(Lcom/chat_soon_e/chat_soon_e/ui/MainRVAdapter;Lcom/chat_soon_e/chat_soon_e/databinding/ItemChatListChooseBinding;Lcom/chat_soon_e/chat_soon_e/ui/MainRVAdapter$MyItemClickListener;)V", "bind", "", "chat", "Lcom/chat_soon_e/chat_soon_e/data/entities/ChatList;", "app_debug"})
    public final class ChooseViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.chat_soon_e.chat_soon_e.databinding.ItemChatListChooseBinding binding = null;
        private final com.chat_soon_e.chat_soon_e.ui.MainRVAdapter.MyItemClickListener mItemClickListener = null;
        
        public ChooseViewHolder(@org.jetbrains.annotations.NotNull()
        com.chat_soon_e.chat_soon_e.databinding.ItemChatListChooseBinding binding, @org.jetbrains.annotations.NotNull()
        com.chat_soon_e.chat_soon_e.ui.MainRVAdapter.MyItemClickListener mItemClickListener) {
            super(null);
        }
        
        @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.chat_soon_e.chat_soon_e.data.entities.ChatList chat) {
        }
    }
}