package com.ryanada.bibiliatakatifu.books;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006#"}, d2 = {"Lcom/ryanada/bibiliatakatifu/books/ActivityBooks;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/google/android/material/navigation/NavigationView$OnNavigationItemSelectedListener;", "()V", "binding", "Lcom/ryanada/bibiliatakatifu/databinding/ActivityBooksBinding;", "getBinding", "()Lcom/ryanada/bibiliatakatifu/databinding/ActivityBooksBinding;", "setBinding", "(Lcom/ryanada/bibiliatakatifu/databinding/ActivityBooksBinding;)V", "bookSearcher", "Landroidx/appcompat/widget/SearchView$OnQueryTextListener;", "getBookSearcher", "()Landroidx/appcompat/widget/SearchView$OnQueryTextListener;", "books", "Ljava/util/ArrayList;", "Lcom/ryanada/bibiliatakatifu/objects/Book;", "getBooks", "()Ljava/util/ArrayList;", "setBooks", "(Ljava/util/ArrayList;)V", "booksAdapter", "Lcom/ryanada/bibiliatakatifu/books/AdapterRecyclerview;", "getBooksAdapter", "()Lcom/ryanada/bibiliatakatifu/books/AdapterRecyclerview;", "setBooksAdapter", "(Lcom/ryanada/bibiliatakatifu/books/AdapterRecyclerview;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNavigationItemSelected", "", "item", "Landroid/view/MenuItem;", "app_release"})
public final class ActivityBooks extends androidx.appcompat.app.AppCompatActivity implements com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener {
    @org.jetbrains.annotations.NotNull()
    public com.ryanada.bibiliatakatifu.databinding.ActivityBooksBinding binding;
    @org.jetbrains.annotations.NotNull()
    public com.ryanada.bibiliatakatifu.books.AdapterRecyclerview booksAdapter;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.ryanada.bibiliatakatifu.objects.Book> books;
    @org.jetbrains.annotations.NotNull()
    private final androidx.appcompat.widget.SearchView.OnQueryTextListener bookSearcher = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.ryanada.bibiliatakatifu.databinding.ActivityBooksBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.ryanada.bibiliatakatifu.databinding.ActivityBooksBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ryanada.bibiliatakatifu.books.AdapterRecyclerview getBooksAdapter() {
        return null;
    }
    
    public final void setBooksAdapter(@org.jetbrains.annotations.NotNull()
    com.ryanada.bibiliatakatifu.books.AdapterRecyclerview p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.ryanada.bibiliatakatifu.objects.Book> getBooks() {
        return null;
    }
    
    public final void setBooks(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.ryanada.bibiliatakatifu.objects.Book> p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.appcompat.widget.SearchView.OnQueryTextListener getBookSearcher() {
        return null;
    }
    
    @java.lang.Override()
    public boolean onNavigationItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    public ActivityBooks() {
        super();
    }
}