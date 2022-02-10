package com.chat_soon_e.chat_soon_e.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001,B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J0\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\u001aH\u0007J\b\u0010\u001b\u001a\u00020\u0015H\u0014J\b\u0010\u001c\u001a\u00020\u0015H\u0002J\b\u0010\u001d\u001a\u00020\u0015H\u0003J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\b\u0010\u001f\u001a\u00020\u0015H\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020!H\u0002J\u0010\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\'H\u0003J\b\u0010(\u001a\u00020\u0015H\u0003J\f\u0010)\u001a\u00020**\u00020+H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/MyFolderActivity;", "Lcom/chat_soon_e/chat_soon_e/ui/BaseActivity;", "Lcom/chat_soon_e/chat_soon_e/databinding/ActivityMyFolderBinding;", "Lcom/google/android/material/navigation/NavigationView$OnNavigationItemSelectedListener;", "()V", "database", "Lcom/chat_soon_e/chat_soon_e/data/local/AppDatabase;", "folderList", "Ljava/util/ArrayList;", "Lcom/chat_soon_e/chat_soon_e/data/entities/Folder;", "folderRVAdapter", "Lcom/chat_soon_e/chat_soon_e/ui/MyFolderRVAdapter;", "iconList", "Lcom/chat_soon_e/chat_soon_e/data/entities/Icon;", "iconRVAdapter", "Lcom/chat_soon_e/chat_soon_e/ui/ChangeIconRVAdapter;", "itemBinding", "Lcom/chat_soon_e/chat_soon_e/databinding/ItemMyFolderBinding;", "mPopupWindow", "Landroid/widget/PopupWindow;", "changeFolderName", "", "changeIcon", "position", "", "folderListFromAdapter", "Lkotlin/collections/ArrayList;", "initAfterBinding", "initClickListener", "initDrawerLayout", "initRecyclerView", "onBackPressed", "onNavigationItemSelected", "", "item", "Landroid/view/MenuItem;", "permissionGrantred", "setFolderIcon", "name", "", "setFolderName", "currentWindowMetricsPointCompat", "Landroid/graphics/Point;", "Landroid/view/WindowManager;", "PopupWindowDismissListener", "app_debug"})
public final class MyFolderActivity extends com.chat_soon_e.chat_soon_e.ui.BaseActivity<com.chat_soon_e.chat_soon_e.databinding.ActivityMyFolderBinding> implements com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener {
    private com.chat_soon_e.chat_soon_e.data.local.AppDatabase database;
    private com.chat_soon_e.chat_soon_e.ui.MyFolderRVAdapter folderRVAdapter;
    private com.chat_soon_e.chat_soon_e.ui.ChangeIconRVAdapter iconRVAdapter;
    private java.util.ArrayList<com.chat_soon_e.chat_soon_e.data.entities.Folder> folderList;
    private java.util.ArrayList<com.chat_soon_e.chat_soon_e.data.entities.Icon> iconList;
    private android.widget.PopupWindow mPopupWindow;
    private com.chat_soon_e.chat_soon_e.databinding.ItemMyFolderBinding itemBinding;
    
    public MyFolderActivity() {
        super(null);
    }
    
    @java.lang.Override()
    protected void initAfterBinding() {
    }
    
    private final void initRecyclerView() {
    }
    
    @android.annotation.SuppressLint(value = {"UseSwitchCompatOrMaterialCode"})
    private final void initDrawerLayout() {
    }
    
    private final boolean permissionGrantred() {
        return false;
    }
    
    @java.lang.Override()
    public boolean onNavigationItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    private final void initClickListener() {
    }
    
    @android.annotation.SuppressLint(value = {"InflateParams", "ClickableViewAccessibility"})
    public final void changeFolderName(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.databinding.ItemMyFolderBinding itemBinding) {
    }
    
    @android.annotation.SuppressLint(value = {"InflateParams", "ClickableViewAccessibility"})
    public final void changeIcon(@org.jetbrains.annotations.NotNull()
    com.chat_soon_e.chat_soon_e.databinding.ItemMyFolderBinding itemBinding, int position, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.chat_soon_e.chat_soon_e.data.entities.Folder> folderListFromAdapter) {
    }
    
    @android.annotation.SuppressLint(value = {"InflateParams"})
    private final void setFolderName() {
    }
    
    @android.annotation.SuppressLint(value = {"InflateParams"})
    private final void setFolderIcon(java.lang.String name) {
    }
    
    private final android.graphics.Point currentWindowMetricsPointCompat(android.view.WindowManager $this$currentWindowMetricsPointCompat) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/MyFolderActivity$PopupWindowDismissListener;", "Landroid/widget/PopupWindow$OnDismissListener;", "(Lcom/chat_soon_e/chat_soon_e/ui/MyFolderActivity;)V", "onDismiss", "", "app_debug"})
    public final class PopupWindowDismissListener implements android.widget.PopupWindow.OnDismissListener {
        
        public PopupWindowDismissListener() {
            super();
        }
        
        @java.lang.Override()
        public void onDismiss() {
        }
    }
}