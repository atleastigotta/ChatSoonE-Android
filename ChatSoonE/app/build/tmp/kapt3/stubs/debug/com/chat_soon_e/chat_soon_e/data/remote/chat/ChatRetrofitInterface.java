package com.chat_soon_e.chat_soon_e.data.remote.chat;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\'J5\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\rH\'\u00a2\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0013\u001a\u00020\u0006H\'\u00a8\u0006\u0014"}, d2 = {"Lcom/chat_soon_e/chat_soon_e/data/remote/chat/ChatRetrofitInterface;", "", "addChat", "Lretrofit2/Call;", "Lcom/chat_soon_e/chat_soon_e/data/remote/chat/AddChatResponse;", "kakaoUserIdx", "", "chat", "Lcom/chat_soon_e/chat_soon_e/data/entities/Chat;", "getChat", "Lcom/chat_soon_e/chat_soon_e/data/remote/chat/ChatResponse;", "otherUserIdx", "groupName", "", "(ILjava/lang/Integer;Ljava/lang/String;)Lretrofit2/Call;", "getChatList", "Lcom/chat_soon_e/chat_soon_e/data/remote/chat/ChatListResponse;", "getFolderChat", "Lcom/chat_soon_e/chat_soon_e/data/remote/chat/FolderChatResponse;", "folderIdx", "app_debug"})
public abstract interface ChatRetrofitInterface {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/app/chatlist/{kakaoUserIdx}")
    public abstract retrofit2.Call<com.chat_soon_e.chat_soon_e.data.remote.chat.AddChatResponse> addChat(@retrofit2.http.Path(value = "kakaoUserIdx")
    int kakaoUserIdx, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.chat_soon_e.chat_soon_e.data.entities.Chat chat);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/app/chatlist/{kakaoUserIdx}")
    public abstract retrofit2.Call<com.chat_soon_e.chat_soon_e.data.remote.chat.ChatListResponse> getChatList(@retrofit2.http.Path(value = "kakaoUserIdx")
    int kakaoUserIdx);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/app/chat/{kakaoUserIdx}")
    public abstract retrofit2.Call<com.chat_soon_e.chat_soon_e.data.remote.chat.ChatResponse> getChat(@retrofit2.http.Path(value = "kakaoUserIdx")
    int kakaoUserIdx, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "otherUserIdx")
    java.lang.Integer otherUserIdx, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "groupName")
    java.lang.String groupName);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/app/chat-folder/{kakaoUserIdx}")
    public abstract retrofit2.Call<com.chat_soon_e.chat_soon_e.data.remote.chat.FolderChatResponse> getFolderChat(@retrofit2.http.Path(value = "kakaoUserIdx")
    int kakaoUserIdx, @retrofit2.http.Query(value = "folderIdx")
    int folderIdx);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
    }
}