package com.chat_soon_e.re_chat.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&\u00a8\u0006\n"}, d2 = {"Lcom/chat_soon_e/re_chat/ui/SignUpView;", "", "onSignUpFailure", "", "code", "", "message", "", "onSignUpLoading", "onSignUpSuccess", "app_debug"})
public abstract interface SignUpView {
    
    public abstract void onSignUpLoading();
    
    public abstract void onSignUpSuccess();
    
    public abstract void onSignUpFailure(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String message);
}