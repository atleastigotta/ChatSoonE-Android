package com.chat_soon_e.chat_soon_e.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001f B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J \u0010\u0011\u001a\u00020\u00122\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\u0013H\u0007J\b\u0010\u0014\u001a\u00020\tH\u0016J\u001c\u0010\u0015\u001a\u00020\u00122\n\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\tH\u0016J\u001c\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\tH\u0016J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\tH\u0002J\u000e\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/MyFolderRVAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/chat_soon_e/chat_soon_e/ui/MyFolderRVAdapter$ViewHolder;", "mContext", "Lcom/chat_soon_e/chat_soon_e/ui/MyFolderActivity;", "(Lcom/chat_soon_e/chat_soon_e/ui/MyFolderActivity;)V", "binding", "Lcom/chat_soon_e/chat_soon_e/databinding/ItemMyFolderBinding;", "currentPosition", "", "folderList", "Ljava/util/ArrayList;", "Lcom/chat_soon_e/chat_soon_e/data/entities/Folder;", "mItemClickListener", "Lcom/chat_soon_e/chat_soon_e/ui/MyFolderRVAdapter$MyItemClickListener;", "popup", "Landroid/widget/PopupMenu;", "addFolderList", "", "Lkotlin/collections/ArrayList;", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "removeFolder", "setMyItemClickListener", "itemClickListener", "MyItemClickListener", "ViewHolder", "app_debug"})
public final class MyFolderRVAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.chat_soon_e.chat_soon_e.ui.MyFolderRVAdapter.ViewHolder> {
    private final com.chat_soon_e.chat_soon_e.ui.MyFolderActivity mContext = null;
    private final java.util.ArrayList<com.chat_soon_e.chat_soon_e.data.entities.Folder> folderList = null;
    private android.widget.PopupMenu popup;
    private com.chat_soon_e.chat_soon_e.databinding.ItemMyFolderBinding binding;
    private int currentPosition = 0;
    private com.chat_soon_e.chat_soon_e.ui.MyFolderRVAdapter.MyItemClickListener mItemClickListener;
    
    public MyFolderRVAdapter(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.ui.MyFolderActivity mContext) {
        super();
    }
    
    public final void setMyItemClickListener(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.ui.MyFolderRVAdapter.MyItemClickListener itemClickListener) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.chat_soon_e.chat_soon_e.ui.MyFolderRVAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup viewGroup, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.ui.MyFolderRVAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void addFolderList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.chat_soon_e.chat_soon_e.data.entities.Folder> folderList) {
    }
    
    private final void removeFolder(int position) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0007H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0007H&\u00a8\u0006\u0011"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/MyFolderRVAdapter$MyItemClickListener;", "", "onFolderClick", "", "view", "Landroid/view/View;", "position", "", "onFolderLongClick", "popup", "Landroid/widget/PopupMenu;", "onFolderNameLongClick", "binding", "Lcom/chat_soon_e/chat_soon_e/databinding/ItemMyFolderBinding;", "onHideFolder", "idx", "onRemoveFolder", "app_debug"})
    public static abstract interface MyItemClickListener {
        
        public abstract void onRemoveFolder(int idx);
        
        public abstract void onHideFolder(int idx);
        
        public abstract void onFolderNameLongClick(@org.jetbrains.annotations.NotNull()
        com.chat_soon_e.chat_soon_e.databinding.ItemMyFolderBinding binding, int position);
        
        public abstract void onFolderClick(@org.jetbrains.annotations.NotNull()
        android.view.View view, int position);
        
        public abstract void onFolderLongClick(@org.jetbrains.annotations.NotNull()
        android.widget.PopupMenu popup);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/MyFolderRVAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/chat_soon_e/chat_soon_e/databinding/ItemMyFolderBinding;", "(Lcom/chat_soon_e/chat_soon_e/ui/MyFolderRVAdapter;Lcom/chat_soon_e/chat_soon_e/databinding/ItemMyFolderBinding;)V", "getBinding", "()Lcom/chat_soon_e/chat_soon_e/databinding/ItemMyFolderBinding;", "bind", "", "folder", "Lcom/chat_soon_e/chat_soon_e/data/entities/Folder;", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.chat_soon_e.chat_soon_e.databinding.ItemMyFolderBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.chat_soon_e.chat_soon_e.databinding.ItemMyFolderBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.chat_soon_e.chat_soon_e.databinding.ItemMyFolderBinding getBinding() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.chat_soon_e.chat_soon_e.data.entities.Folder folder) {
        }
    }
}