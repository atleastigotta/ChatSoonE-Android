package com.chat_soon_e.re_chat.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0017\u0018B\u0005\u00a2\u0006\u0002\u0010\u0003J \u0010\t\u001a\u00020\n2\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u000bH\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\n2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/chat_soon_e/re_chat/ui/FolderListRVAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/chat_soon_e/re_chat/ui/FolderListRVAdapter$ViewHolder;", "()V", "folderList", "Ljava/util/ArrayList;", "Lcom/chat_soon_e/re_chat/data/entities/Folder;", "mItemClickListener", "Lcom/chat_soon_e/re_chat/ui/FolderListRVAdapter$MyItemClickListener;", "addFolderList", "", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "setMyItemClickListener", "itemClickListener", "MyItemClickListener", "ViewHolder", "app_debug"})
public final class FolderListRVAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.chat_soon_e.re_chat.ui.FolderListRVAdapter.ViewHolder> {
    private final java.util.ArrayList<com.chat_soon_e.re_chat.data.entities.Folder> folderList = null;
    private com.chat_soon_e.re_chat.ui.FolderListRVAdapter.MyItemClickListener mItemClickListener;
    
    public FolderListRVAdapter() {
        super();
    }
    
    public final void setMyItemClickListener(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.re_chat.ui.FolderListRVAdapter.MyItemClickListener itemClickListener) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.chat_soon_e.re_chat.ui.FolderListRVAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup viewGroup, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.re_chat.ui.FolderListRVAdapter.ViewHolder holder, int position) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void addFolderList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.chat_soon_e.re_chat.data.entities.Folder> folderList) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/chat_soon_e/re_chat/ui/FolderListRVAdapter$MyItemClickListener;", "", "onFolderClick", "", "itemBinding", "Lcom/chat_soon_e/re_chat/databinding/ItemFolderListBinding;", "itemPosition", "", "app_debug"})
    public static abstract interface MyItemClickListener {
        
        public abstract void onFolderClick(@org.jetbrains.annotations.NotNull()
        com.chat_soon_e.re_chat.databinding.ItemFolderListBinding itemBinding, int itemPosition);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/chat_soon_e/re_chat/ui/FolderListRVAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/chat_soon_e/re_chat/databinding/ItemFolderListBinding;", "(Lcom/chat_soon_e/re_chat/ui/FolderListRVAdapter;Lcom/chat_soon_e/re_chat/databinding/ItemFolderListBinding;)V", "getBinding", "()Lcom/chat_soon_e/re_chat/databinding/ItemFolderListBinding;", "bind", "", "folder", "Lcom/chat_soon_e/re_chat/data/entities/Folder;", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.chat_soon_e.re_chat.databinding.ItemFolderListBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.chat_soon_e.re_chat.databinding.ItemFolderListBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.chat_soon_e.re_chat.databinding.ItemFolderListBinding getBinding() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.chat_soon_e.re_chat.data.entities.Folder folder) {
        }
    }
}