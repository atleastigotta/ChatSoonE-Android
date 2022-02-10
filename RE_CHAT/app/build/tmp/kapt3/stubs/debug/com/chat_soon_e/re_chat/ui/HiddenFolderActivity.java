package com.chat_soon_e.re_chat.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J0\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\u0019H\u0007J\b\u0010\u001a\u001a\u00020\u0014H\u0014J\b\u0010\u001b\u001a\u00020\u0014H\u0002J\b\u0010\u001c\u001a\u00020\u0014H\u0002J\b\u0010\u001d\u001a\u00020\u0014H\u0016J\f\u0010\u001e\u001a\u00020\u001f*\u00020 H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/chat_soon_e/re_chat/ui/HiddenFolderActivity;", "Lcom/chat_soon_e/re_chat/ui/BaseActivity;", "Lcom/chat_soon_e/re_chat/databinding/ActivityHiddenFolderBinding;", "()V", "database", "Lcom/chat_soon_e/re_chat/data/local/AppDatabase;", "folderList", "Ljava/util/ArrayList;", "Lcom/chat_soon_e/re_chat/data/entities/Folder;", "hiddenFolderRVAdapter", "Lcom/chat_soon_e/re_chat/ui/HiddenFolderRVAdapter;", "iconList", "Lcom/chat_soon_e/re_chat/data/entities/Icon;", "iconRVAdapter", "Lcom/chat_soon_e/re_chat/ui/ChangeIconRVAdapter;", "itemHiddenFolderBinding", "Lcom/chat_soon_e/re_chat/databinding/ItemHiddenFolderBinding;", "mPopupWindow", "Landroid/widget/PopupWindow;", "changeFolderName", "", "changeIcon", "position", "", "folderListFromAdapter", "Lkotlin/collections/ArrayList;", "initAfterBinding", "initClickListener", "initFolder", "onBackPressed", "currentWindowMetricsPointCompat", "Landroid/graphics/Point;", "Landroid/view/WindowManager;", "PopupWindowDismissListener", "app_debug"})
public final class HiddenFolderActivity extends com.chat_soon_e.re_chat.ui.BaseActivity<com.chat_soon_e.re_chat.databinding.ActivityHiddenFolderBinding> {
    private com.chat_soon_e.re_chat.data.local.AppDatabase database;
    private com.chat_soon_e.re_chat.ui.HiddenFolderRVAdapter hiddenFolderRVAdapter;
    private com.chat_soon_e.re_chat.ui.ChangeIconRVAdapter iconRVAdapter;
    private java.util.ArrayList<com.chat_soon_e.re_chat.data.entities.Folder> folderList;
    private java.util.ArrayList<com.chat_soon_e.re_chat.data.entities.Icon> iconList;
    private android.widget.PopupWindow mPopupWindow;
    private com.chat_soon_e.re_chat.databinding.ItemHiddenFolderBinding itemHiddenFolderBinding;
    
    public HiddenFolderActivity() {
        super(null);
    }
    
    @java.lang.Override()
    protected void initAfterBinding() {
    }
    
    private final void initFolder() {
    }
    
    private final void initClickListener() {
    }
    
    @android.annotation.SuppressLint(value = {"InflateParams"})
    public final void changeFolderName(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.re_chat.databinding.ItemHiddenFolderBinding itemHiddenFolderBinding) {
    }
    
    @android.annotation.SuppressLint(value = {"InflateParams"})
    public final void changeIcon(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.re_chat.databinding.ItemHiddenFolderBinding itemHiddenFolderBinding, int position, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.chat_soon_e.re_chat.data.entities.Folder> folderListFromAdapter) {
    }
    
    private final android.graphics.Point currentWindowMetricsPointCompat(android.view.WindowManager $this$currentWindowMetricsPointCompat) {
        return null;
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/chat_soon_e/re_chat/ui/HiddenFolderActivity$PopupWindowDismissListener;", "Landroid/widget/PopupWindow$OnDismissListener;", "(Lcom/chat_soon_e/re_chat/ui/HiddenFolderActivity;)V", "onDismiss", "", "app_debug"})
    public final class PopupWindowDismissListener implements android.widget.PopupWindow.OnDismissListener {
        
        public PopupWindowDismissListener() {
            super();
        }
        
        @java.lang.Override()
        public void onDismiss() {
        }
    }
}