package com.chat_soon_e.chat_soon_e.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0010H$J\u0012\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019J\u0014\u0010\u001a\u001a\u00020\u00102\f\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001cJ\u0014\u0010\u001d\u001a\u00020\u00102\f\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001cR \u0010\t\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u0000@BX\u0084.\u00a2\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/ui/BaseActivity;", "T", "Landroidx/viewbinding/ViewBinding;", "Landroidx/appcompat/app/AppCompatActivity;", "inflate", "Lkotlin/Function1;", "Landroid/view/LayoutInflater;", "(Lkotlin/jvm/functions/Function1;)V", "<set-?>", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "Landroidx/viewbinding/ViewBinding;", "imm", "Landroid/view/inputmethod/InputMethodManager;", "hideKeyboard", "", "v", "Landroid/view/View;", "initAfterBinding", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showToast", "message", "", "startActivityWithClear", "activity", "Ljava/lang/Class;", "startNextActivity", "app_debug"})
public abstract class BaseActivity<T extends androidx.viewbinding.ViewBinding> extends androidx.appcompat.app.AppCompatActivity {
    private final kotlin.jvm.functions.Function1<android.view.LayoutInflater, T> inflate = null;
    private T binding;
    private android.view.inputmethod.InputMethodManager imm;
    
    public BaseActivity(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.view.LayoutInflater, ? extends T> inflate) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final T getBinding() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    protected abstract void initAfterBinding();
    
    public final void showToast(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public final void startNextActivity(@org.jetbrains.annotations.Nullable()
    java.lang.Class<?> activity) {
    }
    
    public final void startActivityWithClear(@org.jetbrains.annotations.Nullable()
    java.lang.Class<?> activity) {
    }
    
    public final void hideKeyboard(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
}