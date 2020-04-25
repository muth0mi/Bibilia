package io.muth0mi.bibilia.books;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u001e\u0010\u0015\u001a\u00020\u000e2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0016j\b\u0012\u0004\u0012\u00020\n`\u0017R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lio/muth0mi/bibilia/books/AdapterRecyclerview;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lio/muth0mi/bibilia/books/AdapterRecyclerview$BookRow;", "activityBooks", "Lio/muth0mi/bibilia/books/ActivityBooks;", "(Lio/muth0mi/bibilia/books/ActivityBooks;)V", "getActivityBooks", "()Lio/muth0mi/bibilia/books/ActivityBooks;", "books", "", "Lio/muth0mi/bibilia/objects/Book;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setBooks", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "BookRow", "app_release"})
public final class AdapterRecyclerview extends androidx.recyclerview.widget.RecyclerView.Adapter<io.muth0mi.bibilia.books.AdapterRecyclerview.BookRow> {
    private java.util.List<io.muth0mi.bibilia.objects.Book> books;
    @org.jetbrains.annotations.NotNull()
    private final io.muth0mi.bibilia.books.ActivityBooks activityBooks = null;
    
    public final void setBooks(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<io.muth0mi.bibilia.objects.Book> books) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.muth0mi.bibilia.books.AdapterRecyclerview.BookRow onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    io.muth0mi.bibilia.books.AdapterRecyclerview.BookRow holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.muth0mi.bibilia.books.ActivityBooks getActivityBooks() {
        return null;
    }
    
    public AdapterRecyclerview(@org.jetbrains.annotations.NotNull()
    io.muth0mi.bibilia.books.ActivityBooks activityBooks) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lio/muth0mi/bibilia/books/AdapterRecyclerview$BookRow;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lio/muth0mi/bibilia/books/AdapterRecyclerview;Landroid/view/View;)V", "binding", "Lio/muth0mi/bibilia/databinding/RowBookBinding;", "bind", "", "book", "Lio/muth0mi/bibilia/objects/Book;", "app_release"})
    public final class BookRow extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final io.muth0mi.bibilia.databinding.RowBookBinding binding = null;
        
        @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.M)
        public final void bind(@org.jetbrains.annotations.NotNull()
        io.muth0mi.bibilia.objects.Book book) {
        }
        
        public BookRow(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
}