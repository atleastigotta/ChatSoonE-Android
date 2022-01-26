package com.chat_soon_e.chat_soon_e.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0011\u0012B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/MyFolderActivity;", "Lcom/chat_soon_e/chat_soon_e/ui/BaseActivity;", "Lcom/chat_soon_e/chat_soon_e/databinding/ActivityMyFolderBinding;", "()V", "folderDB", "Lcom/chat_soon_e/chat_soon_e/data/local/AppDatabase;", "folderList", "Ljava/util/ArrayList;", "Lcom/chat_soon_e/chat_soon_e/data/entities/Folder;", "folderRVAdapter", "Lcom/chat_soon_e/chat_soon_e/ui/MyFolderRVAdapter;", "initAfterBinding", "", "initClickListener", "initFolderList", "initRecyclerView", "onStart", "PopupFolderMenuOptionListener", "PopupMenuEditListener", "app_debug"})
public final class MyFolderActivity extends com.chat_soon_e.chat_soon_e.ui.BaseActivity<com.chat_soon_e.chat_soon_e.databinding.ActivityMyFolderBinding> {
    private com.chat_soon_e.chat_soon_e.data.local.AppDatabase folderDB;
    private com.chat_soon_e.chat_soon_e.ui.MyFolderRVAdapter folderRVAdapter;
    private java.util.ArrayList<com.chat_soon_e.chat_soon_e.data.entities.Folder> folderList;
    
    public MyFolderActivity() {
        super(null);
    }
    
    @java.lang.Override()
    protected void initAfterBinding() {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    private final void initFolderList() {
    }
    
    private final void initRecyclerView() {
    }
    
    private final void initClickListener() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/MyFolderActivity$PopupFolderMenuOptionListener;", "Landroid/widget/PopupMenu$OnMenuItemClickListener;", "(Lcom/chat_soon_e/chat_soon_e/ui/MyFolderActivity;)V", "onMenuItemClick", "", "item", "Landroid/view/MenuItem;", "app_debug"})
    public final class PopupFolderMenuOptionListener implements android.widget.PopupMenu.OnMenuItemClickListener {
        
        public PopupFolderMenuOptionListener() {
            super();
        }
        
        @java.lang.Override()
        public boolean onMenuItemClick(@org.jetbrains.annotations.Nullable()
        android.view.MenuItem item) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/MyFolderActivity$PopupMenuEditListener;", "Landroid/widget/PopupMenu$OnMenuItemClickListener;", "(Lcom/chat_soon_e/chat_soon_e/ui/MyFolderActivity;)V", "onMenuItemClick", "", "item", "Landroid/view/MenuItem;", "app_debug"})
    public final class PopupMenuEditListener implements android.widget.PopupMenu.OnMenuItemClickListener {
        
        public PopupMenuEditListener() {
            super();
        }
        
        @java.lang.Override()
        public boolean onMenuItemClick(@org.jetbrains.annotations.Nullable()
        android.view.MenuItem item) {
            return false;
        }
    }
}