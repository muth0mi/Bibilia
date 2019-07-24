package com.ryanada.bibiliatakatifu.databinding;
import com.ryanada.bibiliatakatifu.R;
import com.ryanada.bibiliatakatifu.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityVersesBindingImpl extends ActivityVersesBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.ll, 2);
        sViewsWithIds.put(R.id.tvChapter, 3);
        sViewsWithIds.put(R.id.svSearch, 4);
        sViewsWithIds.put(R.id.gridview, 5);
        sViewsWithIds.put(R.id.tvNoResults, 6);
        sViewsWithIds.put(R.id.rvVerses, 7);
        sViewsWithIds.put(R.id.btnPrev, 8);
        sViewsWithIds.put(R.id.btnNext, 9);
    }
    // views
    @NonNull
    private final androidx.coordinatorlayout.widget.CoordinatorLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityVersesBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }
    private ActivityVersesBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.button.MaterialButton) bindings[9]
            , (com.google.android.material.button.MaterialButton) bindings[8]
            , (android.widget.GridView) bindings[5]
            , (android.widget.LinearLayout) bindings[2]
            , (androidx.recyclerview.widget.RecyclerView) bindings[7]
            , (androidx.appcompat.widget.SearchView) bindings[4]
            , (androidx.appcompat.widget.Toolbar) bindings[1]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[6]
            );
        this.mboundView0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.toolBar.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
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
        if (BR.title == variableId) {
            setTitle((java.lang.String) variable);
        }
        else if (BR.subtitle == variableId) {
            setSubtitle((java.lang.String) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setTitle(@Nullable java.lang.String Title) {
        this.mTitle = Title;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.title);
        super.requestRebind();
    }
    public void setSubtitle(@Nullable java.lang.String Subtitle) {
        this.mSubtitle = Subtitle;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.subtitle);
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
        java.lang.String title = mTitle;
        java.lang.String subtitle = mSubtitle;

        if ((dirtyFlags & 0x5L) != 0) {
        }
        if ((dirtyFlags & 0x6L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            this.toolBar.setSubtitle(subtitle);
        }
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            this.toolBar.setTitle(title);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): title
        flag 1 (0x2L): subtitle
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}