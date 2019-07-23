package com.ryanada.bibiliatakatifu.databinding;
import com.ryanada.bibiliatakatifu.R;
import com.ryanada.bibiliatakatifu.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class RowVerseBindingImpl extends RowVerseBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final com.google.android.material.card.MaterialCardView mboundView0;
    @NonNull
    private final android.widget.TextView mboundView2;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public RowVerseBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private RowVerseBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[1]
            );
        this.mboundView0 = (com.google.android.material.card.MaterialCardView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.tvVerseNumber.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.verse == variableId) {
            setVerse((com.ryanada.bibiliatakatifu.objects.Verse) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setVerse(@Nullable com.ryanada.bibiliatakatifu.objects.Verse Verse) {
        this.mVerse = Verse;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.verse);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.ryanada.bibiliatakatifu.objects.Verse verse = mVerse;
        java.lang.String verseVerseNumber = null;
        java.lang.String verseVerse = null;
        java.lang.String javaLangStringTVerseVerse = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (verse != null) {
                    // read verse.verseNumber
                    verseVerseNumber = verse.getVerseNumber();
                    // read verse.verse
                    verseVerse = verse.getVerse();
                }


                // read ("\t  ") + (verse.verse)
                javaLangStringTVerseVerse = ("\t  ") + (verseVerse);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, javaLangStringTVerseVerse);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvVerseNumber, verseVerseNumber);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): verse
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}