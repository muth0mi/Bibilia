package com.ryanada.bibiliatakatifu.versesContent;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u001e\u0010\u0015\u001a\u00020\u000e2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/ryanada/bibiliatakatifu/versesContent/Adapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ryanada/bibiliatakatifu/versesContent/Adapter$VerseRow;", "activity", "Lcom/ryanada/bibiliatakatifu/versesContent/Main2Activity;", "(Lcom/ryanada/bibiliatakatifu/versesContent/Main2Activity;)V", "getActivity", "()Lcom/ryanada/bibiliatakatifu/versesContent/Main2Activity;", "verses", "Ljava/util/ArrayList;", "Lcom/ryanada/bibiliatakatifu/objects/VerseContent;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setVerses", "Lkotlin/collections/ArrayList;", "VerseRow", "app_debug"})
public final class Adapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.ryanada.bibiliatakatifu.versesContent.Adapter.VerseRow> {
    private java.util.ArrayList<com.ryanada.bibiliatakatifu.objects.VerseContent> verses;
    @org.jetbrains.annotations.NotNull()
    private final com.ryanada.bibiliatakatifu.versesContent.Main2Activity activity = null;
    
    public final void setVerses(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.ryanada.bibiliatakatifu.objects.VerseContent> verses) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.ryanada.bibiliatakatifu.versesContent.Adapter.VerseRow onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.ryanada.bibiliatakatifu.versesContent.Adapter.VerseRow holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ryanada.bibiliatakatifu.versesContent.Main2Activity getActivity() {
        return null;
    }
    
    public Adapter(@org.jetbrains.annotations.NotNull()
    com.ryanada.bibiliatakatifu.versesContent.Main2Activity activity) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/ryanada/bibiliatakatifu/versesContent/Adapter$VerseRow;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/ryanada/bibiliatakatifu/versesContent/Adapter;Landroid/view/View;)V", "binding", "Lcom/ryanada/bibiliatakatifu/databinding/RowVerseBinding;", "bind", "", "verse", "Lcom/ryanada/bibiliatakatifu/objects/VerseContent;", "app_debug"})
    public final class VerseRow extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.ryanada.bibiliatakatifu.databinding.RowVerseBinding binding = null;
        
        @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.M)
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.ryanada.bibiliatakatifu.objects.VerseContent verse) {
        }
        
        public VerseRow(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
}