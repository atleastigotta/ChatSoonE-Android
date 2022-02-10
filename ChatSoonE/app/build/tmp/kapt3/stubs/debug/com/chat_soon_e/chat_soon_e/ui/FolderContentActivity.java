package com.chat_soon_e.chat_soon_e.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/FolderContentActivity;", "Lcom/chat_soon_e/chat_soon_e/ui/BaseActivity;", "Lcom/chat_soon_e/chat_soon_e/databinding/ActivityFolderContentBinding;", "()V", "chatList", "Ljava/util/ArrayList;", "Lcom/chat_soon_e/chat_soon_e/data/entities/Chat;", "Lkotlin/collections/ArrayList;", "data", "Lcom/chat_soon_e/chat_soon_e/data/entities/FolderContent;", "getData", "()Lcom/chat_soon_e/chat_soon_e/data/entities/FolderContent;", "setData", "(Lcom/chat_soon_e/chat_soon_e/data/entities/FolderContent;)V", "database", "Lcom/chat_soon_e/chat_soon_e/data/local/AppDatabase;", "folderContentRVAdapter", "Lcom/chat_soon_e/chat_soon_e/ui/FolderContentRVAdapter;", "initAfterBinding", "", "initClickListener", "initData", "initRecyclerView", "app_debug"})
public final class FolderContentActivity extends com.chat_soon_e.chat_soon_e.ui.BaseActivity<com.chat_soon_e.chat_soon_e.databinding.ActivityFolderContentBinding> {
    private com.chat_soon_e.chat_soon_e.data.local.AppDatabase database;
    private java.util.ArrayList<com.chat_soon_e.chat_soon_e.data.entities.Chat> chatList;
    private com.chat_soon_e.chat_soon_e.ui.FolderContentRVAdapter folderContentRVAdapter;
    public com.chat_soon_e.chat_soon_e.data.entities.FolderContent data;
    
    public FolderContentActivity() {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.chat_soon_e.chat_soon_e.data.entities.FolderContent getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.data.entities.FolderContent p0) {
    }
    
    @java.lang.Override()
    protected void initAfterBinding() {
    }
    
    private final void initData() {
    }
    
    private final void initRecyclerView() {
    }
    
    private final void initClickListener() {
    }
}