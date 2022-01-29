package com.chat_soon_e.chat_soon_e.ui;

import java.lang.System;

<<<<<<< HEAD
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\"#$B%\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000bH\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0007J\u000e\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000bJ\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000bH\u0007J\u001a\u0010\u001f\u001a\u00020\u000f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/MainRVAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "chatList", "Ljava/util/ArrayList;", "Lcom/chat_soon_e/chat_soon_e/data/entities/Chat;", "Lkotlin/collections/ArrayList;", "mItemClickListener", "Lcom/chat_soon_e/chat_soon_e/ui/MainRVAdapter$MyItemClickListener;", "(Ljava/util/ArrayList;Lcom/chat_soon_e/chat_soon_e/ui/MainRVAdapter$MyItemClickListener;)V", "selectedIndex", "", "selectedItemList", "Landroid/util/SparseBooleanArray;", "clearSelectedItemList", "", "getItemCount", "getItemViewType", "position", "isItemSelected", "", "onBindViewHolder", "holder", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "removeSelectedItemList", "setChecked", "setViewType", "currentMode", "toggleItemSelected", "view", "Landroid/view/View;", "ChooseViewHolder", "DefaultViewHolder", "MyItemClickListener", "app_debug"})
public final class MainRVAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private java.util.ArrayList<com.chat_soon_e.chat_soon_e.data.entities.Chat> chatList;
    private final com.chat_soon_e.chat_soon_e.ui.MainRVAdapter.MyItemClickListener mItemClickListener = null;
=======
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002/0B-\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0007J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001bJ\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u000fH\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0013H\u0002J\u001c\u0010!\u001a\u00020\u00172\n\u0010\"\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\u001c\u0010#\u001a\u00060\u0002R\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000fH\u0017J\u000e\u0010\'\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u000fJ\u0006\u0010(\u001a\u00020\u000fJ\u000e\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\rJ\u0018\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020-2\u0006\u0010\u001d\u001a\u00020\u000fH\u0002J\u0010\u0010.\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u000fH\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/MainRVAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/chat_soon_e/chat_soon_e/ui/MainRVAdapter$ViewHolder;", "chatList", "Ljava/util/ArrayList;", "Lcom/chat_soon_e/chat_soon_e/data/entities/Chat;", "Lkotlin/collections/ArrayList;", "isSelectionMode", "", "context", "Landroid/content/Context;", "(Ljava/util/ArrayList;ZLandroid/content/Context;)V", "mItemClickListener", "Lcom/chat_soon_e/chat_soon_e/ui/MainRVAdapter$MyItemClickListener;", "selectedIndex", "", "selectedItemList", "Landroid/util/SparseBooleanArray;", "DateToString", "", "date", "Ljava/util/Date;", "clear", "", "clearSelectedItemList", "getItemCount", "getSelectedItemList", "", "isItemSelected", "position", "loadBitmap", "Landroid/graphics/Bitmap;", "name", "onBindViewHolder", "holder", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "removeItem", "selectedItemCount", "setMyItemClickListener", "itemClickListener", "toggleIcon", "binding", "Lcom/chat_soon_e/chat_soon_e/databinding/ItemChatListBinding;", "toggleItemSelected", "MyItemClickListener", "ViewHolder", "app_debug"})
public final class MainRVAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.chat_soon_e.chat_soon_e.ui.MainRVAdapter.ViewHolder> {
    private final java.util.ArrayList<com.chat_soon_e.chat_soon_e.data.entities.Chat> chatList = null;
    private final boolean isSelectionMode = false;
    private final android.content.Context context = null;
>>>>>>> upstream/juyeon
    private int selectedIndex = -1;
    private android.util.SparseBooleanArray selectedItemList;
    
    public MainRVAdapter(@org.jetbrains.annotations.NotNull()
<<<<<<< HEAD
    java.util.ArrayList<com.chat_soon_e.chat_soon_e.data.entities.Chat> chatList, @org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.ui.MainRVAdapter.MyItemClickListener mItemClickListener) {
=======
    java.util.ArrayList<com.chat_soon_e.chat_soon_e.data.entities.Chat> chatList, boolean isSelectionMode, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
>>>>>>> upstream/juyeon
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup viewGroup, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void removeSelectedItemList() {
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
    
<<<<<<< HEAD
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void setViewType(int currentMode) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/MainRVAdapter$MyItemClickListener;", "", "onChooseChatClick", "", "view", "Landroid/view/View;", "position", "", "onDefaultChatClick", "app_debug"})
=======
    private final java.lang.String DateToString(java.util.Date date) {
        return null;
    }
    
    private final android.graphics.Bitmap loadBitmap(java.lang.String name) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/MainRVAdapter$MyItemClickListener;", "", "onChatClick", "", "view", "Landroid/view/View;", "position", "", "onChatClickForFolder", "onChatLongClick", "app_debug"})
>>>>>>> upstream/juyeon
    public static abstract interface MyItemClickListener {
        
        public abstract void onDefaultChatClick(@org.jetbrains.annotations.NotNull()
        android.view.View view, int position);
        
        public abstract void onChooseChatClick(@org.jetbrains.annotations.NotNull()
        android.view.View view, int position);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/MainRVAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/chat_soon_e/chat_soon_e/databinding/ItemChatListDefaultBinding;", "(Lcom/chat_soon_e/chat_soon_e/ui/MainRVAdapter;Lcom/chat_soon_e/chat_soon_e/databinding/ItemChatListDefaultBinding;)V", "bind", "", "chat", "Lcom/chat_soon_e/chat_soon_e/data/entities/Chat;", "app_debug"})
    public final class DefaultViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.chat_soon_e.chat_soon_e.databinding.ItemChatListDefaultBinding binding = null;
        
        public DefaultViewHolder(@org.jetbrains.annotations.NotNull()
        com.chat_soon_e.chat_soon_e.databinding.ItemChatListDefaultBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.chat_soon_e.chat_soon_e.data.entities.Chat chat) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/MainRVAdapter$ChooseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/chat_soon_e/chat_soon_e/databinding/ItemChatListChooseBinding;", "mItemClickListener", "Lcom/chat_soon_e/chat_soon_e/ui/MainRVAdapter$MyItemClickListener;", "(Lcom/chat_soon_e/chat_soon_e/ui/MainRVAdapter;Lcom/chat_soon_e/chat_soon_e/databinding/ItemChatListChooseBinding;Lcom/chat_soon_e/chat_soon_e/ui/MainRVAdapter$MyItemClickListener;)V", "bind", "", "chat", "Lcom/chat_soon_e/chat_soon_e/data/entities/Chat;", "app_debug"})
    public final class ChooseViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.chat_soon_e.chat_soon_e.databinding.ItemChatListChooseBinding binding = null;
        private final com.chat_soon_e.chat_soon_e.ui.MainRVAdapter.MyItemClickListener mItemClickListener = null;
        
        public ChooseViewHolder(@org.jetbrains.annotations.NotNull()
        com.chat_soon_e.chat_soon_e.databinding.ItemChatListChooseBinding binding, @org.jetbrains.annotations.NotNull()
        com.chat_soon_e.chat_soon_e.ui.MainRVAdapter.MyItemClickListener mItemClickListener) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.chat_soon_e.chat_soon_e.data.entities.Chat chat) {
        }
    }
}