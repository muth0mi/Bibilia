package com.ryanada.bibiliatakatifu.books;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001c"}, d2 = {"Lcom/ryanada/bibiliatakatifu/books/ActivityBooks;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/google/android/material/navigation/NavigationView$OnNavigationItemSelectedListener;", "()V", "binding", "Lcom/ryanada/bibiliatakatifu/databinding/ActivityBooksBinding;", "getBinding", "()Lcom/ryanada/bibiliatakatifu/databinding/ActivityBooksBinding;", "setBinding", "(Lcom/ryanada/bibiliatakatifu/databinding/ActivityBooksBinding;)V", "bookSearcher", "Landroidx/appcompat/widget/SearchView$OnQueryTextListener;", "getBookSearcher", "()Landroidx/appcompat/widget/SearchView$OnQueryTextListener;", "booksAdapter", "Lcom/ryanada/bibiliatakatifu/books/AdapterRecyclerview;", "getBooksAdapter", "()Lcom/ryanada/bibiliatakatifu/books/AdapterRecyclerview;", "setBooksAdapter", "(Lcom/ryanada/bibiliatakatifu/books/AdapterRecyclerview;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNavigationItemSelected", "", "item", "Landroid/view/MenuItem;", "app_release"})
public final class ActivityBooks extends androidx.appcompat.app.AppCompatActivity implements com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener {
    @org.jetbrains.annotations.NotNull()
    public com.ryanada.bibiliatakatifu.databinding.ActivityBooksBinding binding;
    @org.jetbrains.annotations.NotNull()
    public com.ryanada.bibiliatakatifu.books.AdapterRecyclerview booksAdapter;
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