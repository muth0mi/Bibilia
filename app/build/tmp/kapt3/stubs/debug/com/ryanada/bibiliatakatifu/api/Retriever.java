package com.ryanada.bibiliatakatifu.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0006J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0006R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\b\u00a8\u0006\u0019"}, d2 = {"Lcom/ryanada/bibiliatakatifu/api/Retriever;", "", "context", "Lcom/ryanada/bibiliatakatifu/books/MainActivity;", "(Lcom/ryanada/bibiliatakatifu/books/MainActivity;)V", "apiKey", "", "getApiKey", "()Ljava/lang/String;", "baseUrl", "getBaseUrl", "contentType", "getContentType", "getContext", "()Lcom/ryanada/bibiliatakatifu/books/MainActivity;", "version", "getVersion", "getBooks", "", "getChapters", "bookId", "getVerseContents", "verseId", "getVerses", "chapterId", "app_debug"})
public final class Retriever {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String apiKey = "14ffdc4cd88203ca1a99b3fdcfad9c83";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String contentType = "json";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String baseUrl = "https://api.scripture.api.bible/v1/bibles";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String version = "/de4e12af7f28f599-01";
    @org.jetbrains.annotations.NotNull()
    private final com.ryanada.bibiliatakatifu.books.MainActivity context = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getApiKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContentType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBaseUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getVersion() {
        return null;
    }
    
    public final void getBooks() {
    }
    
    public final void getChapters(@org.jetbrains.annotations.NotNull()
    java.lang.String bookId) {
    }
    
    public final void getVerses(@org.jetbrains.annotations.NotNull()
    java.lang.String chapterId) {
    }
    
    public final void getVerseContents(@org.jetbrains.annotations.NotNull()
    java.lang.String verseId) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ryanada.bibiliatakatifu.books.MainActivity getContext() {
        return null;
    }
    
    public Retriever(@org.jetbrains.annotations.NotNull()
    com.ryanada.bibiliatakatifu.books.MainActivity context) {
        super();
    }
}