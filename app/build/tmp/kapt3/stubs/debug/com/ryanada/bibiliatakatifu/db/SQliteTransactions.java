package com.ryanada.bibiliatakatifu.db;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0011j\b\u0012\u0004\u0012\u00020\u0017`\u00132\u0006\u0010\u0018\u001a\u00020\u0012J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u001e\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u0011j\b\u0012\u0004\u0012\u00020\u001c`\u00132\u0006\u0010\u001d\u001a\u00020\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/ryanada/bibiliatakatifu/db/SQliteTransactions;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "KEY_BOOKS", "", "KEY_B_STATE", "KEY_CHAPTERS", "KEY_COLORCODE", "KEY_GENERATION", "KEY_ID", "KEY_NOTES", "KEY_VERSES", "KEY_V_NO", "TABLE_BIBLE", "getBooks", "Ljava/util/ArrayList;", "Lcom/ryanada/bibiliatakatifu/objects/Book;", "Lkotlin/collections/ArrayList;", "testament", "Lcom/ryanada/bibiliatakatifu/objects/Testament;", "getChapters", "Lcom/ryanada/bibiliatakatifu/objects/Chapter;", "book", "getDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "getVerses", "Lcom/ryanada/bibiliatakatifu/objects/Verse;", "chapter", "app_debug"})
public final class SQliteTransactions {
    private final java.lang.String TABLE_BIBLE = "BIBLE_TABLE";
    private final java.lang.String KEY_ID = "ID";
    private final java.lang.String KEY_BOOKS = "BOOKS";
    private final java.lang.String KEY_CHAPTERS = "CHAPTERS";
    private final java.lang.String KEY_V_NO = "V_NO";
    private final java.lang.String KEY_VERSES = "VERSES";
    private final java.lang.String KEY_NOTES = "NOTES";
    private final java.lang.String KEY_GENERATION = "GENERATION";
    private final java.lang.String KEY_B_STATE = "B_STATE";
    private final java.lang.String KEY_COLORCODE = "COLORCODE";
    private final android.app.Activity activity = null;
    
    private final android.database.sqlite.SQLiteDatabase getDatabase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.ryanada.bibiliatakatifu.objects.Book> getBooks(@org.jetbrains.annotations.NotNull()
    com.ryanada.bibiliatakatifu.objects.Testament testament) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.ryanada.bibiliatakatifu.objects.Chapter> getChapters(@org.jetbrains.annotations.NotNull()
    com.ryanada.bibiliatakatifu.objects.Book book) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.ryanada.bibiliatakatifu.objects.Verse> getVerses(@org.jetbrains.annotations.NotNull()
    com.ryanada.bibiliatakatifu.objects.Chapter chapter) {
        return null;
    }
    
    public SQliteTransactions(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        super();
    }
}