package com.chat_soon_e.chat_soon_e.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001f B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0014H\u0007J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u001c\u0010\u0017\u001a\u00020\u00122\n\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0016H\u0017J\u001c\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0016H\u0016J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0016H\u0002R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/FolderContentRVAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/chat_soon_e/chat_soon_e/ui/FolderContentRVAdapter$ViewHolder;", "mContext", "Lcom/chat_soon_e/chat_soon_e/ui/FolderContentActivity;", "mItemClickListener", "Lcom/chat_soon_e/chat_soon_e/ui/FolderContentRVAdapter$MyClickListener;", "(Lcom/chat_soon_e/chat_soon_e/ui/FolderContentActivity;Lcom/chat_soon_e/chat_soon_e/ui/FolderContentRVAdapter$MyClickListener;)V", "chatList", "Ljava/util/ArrayList;", "Lcom/chat_soon_e/chat_soon_e/data/entities/Chat;", "getChatList", "()Ljava/util/ArrayList;", "setChatList", "(Ljava/util/ArrayList;)V", "popup", "Landroid/widget/PopupMenu;", "addItem", "", "chat", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "removeChat", "MyClickListener", "ViewHolder", "app_debug"})
public final class FolderContentRVAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.chat_soon_e.chat_soon_e.ui.FolderContentRVAdapter.ViewHolder> {
    private final com.chat_soon_e.chat_soon_e.ui.FolderContentActivity mContext = null;
    private final com.chat_soon_e.chat_soon_e.ui.FolderContentRVAdapter.MyClickListener mItemClickListener = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.chat_soon_e.chat_soon_e.data.entities.Chat> chatList;
    private android.widget.PopupMenu popup;
    
    public FolderContentRVAdapter(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.ui.FolderContentActivity mContext, @org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.ui.FolderContentRVAdapter.MyClickListener mItemClickListener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.chat_soon_e.chat_soon_e.data.entities.Chat> getChatList() {
        return null;
    }
    
    public final void setChatList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.chat_soon_e.chat_soon_e.data.entities.Chat> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.chat_soon_e.chat_soon_e.ui.FolderContentRVAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup viewGroup, int viewType) {
        return null;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.ui.FolderContentRVAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    private final void removeChat(int position) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void addItem(@org.jetbrains.annotations.NotNull()
    java.util.List<com.chat_soon_e.chat_soon_e.data.entities.Chat> chat) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/FolderContentRVAdapter$MyClickListener;", "", "onChatLongClick", "", "popupMenu", "Landroid/widget/PopupMenu;", "onRemoveChat", "app_debug"})
    public static abstract interface MyClickListener {
        
        public abstract void onRemoveChat();
        
        public abstract void onChatLongClick(@org.jetbrains.annotations.NotNull()
        android.widget.PopupMenu popupMenu);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/FolderContentRVAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/chat_soon_e/chat_soon_e/databinding/ItemChatDefaultBinding;", "(Lcom/chat_soon_e/chat_soon_e/ui/FolderContentRVAdapter;Lcom/chat_soon_e/chat_soon_e/databinding/ItemChatDefaultBinding;)V", "getBinding", "()Lcom/chat_soon_e/chat_soon_e/databinding/ItemChatDefaultBinding;", "bind", "", "chat", "Lcom/chat_soon_e/chat_soon_e/data/entities/Chat;", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.chat_soon_e.chat_soon_e.databinding.ItemChatDefaultBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.chat_soon_e.chat_soon_e.databinding.ItemChatDefaultBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.chat_soon_e.chat_soon_e.databinding.ItemChatDefaultBinding getBinding() {
            return null;
        }
        
        @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.chat_soon_e.chat_soon_e.data.entities.Chat chat) {
        }
    }
}