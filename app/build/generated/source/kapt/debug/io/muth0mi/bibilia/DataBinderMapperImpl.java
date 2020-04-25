package com.ryanada.bibilia;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.ryanada.bibilia.databinding.ActivityBooksAppbarBindingImpl;
import com.ryanada.bibilia.databinding.ActivityBooksBindingImpl;
import com.ryanada.bibilia.databinding.ActivityVersesBindingImpl;
import com.ryanada.bibilia.databinding.FragmentTestamentBindingImpl;
import com.ryanada.bibilia.databinding.RowBookBindingImpl;
import com.ryanada.bibilia.databinding.RowChapterBindingImpl;
import com.ryanada.bibilia.databinding.RowVerseBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYBOOKS = 1;

  private static final int LAYOUT_ACTIVITYBOOKSAPPBAR = 2;

  private static final int LAYOUT_ACTIVITYVERSES = 3;

  private static final int LAYOUT_FRAGMENTTESTAMENT = 4;

  private static final int LAYOUT_ROWBOOK = 5;

  private static final int LAYOUT_ROWCHAPTER = 6;

  private static final int LAYOUT_ROWVERSE = 7;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(7);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.ryanada.bibilia.R.layout.activity_books, LAYOUT_ACTIVITYBOOKS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.ryanada.bibilia.R.layout.activity_books_appbar, LAYOUT_ACTIVITYBOOKSAPPBAR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.ryanada.bibilia.R.layout.activity_verses, LAYOUT_ACTIVITYVERSES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.ryanada.bibilia.R.layout.fragment_testament, LAYOUT_FRAGMENTTESTAMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.ryanada.bibilia.R.layout.row_book, LAYOUT_ROWBOOK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.ryanada.bibilia.R.layout.row_chapter, LAYOUT_ROWCHAPTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.ryanada.bibilia.R.layout.row_verse, LAYOUT_ROWVERSE);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYBOOKS: {
          if ("layout/activity_books_0".equals(tag)) {
            return new ActivityBooksBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_books is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYBOOKSAPPBAR: {
          if ("layout/activity_books_appbar_0".equals(tag)) {
            return new ActivityBooksAppbarBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_books_appbar is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYVERSES: {
          if ("layout/activity_verses_0".equals(tag)) {
            return new ActivityVersesBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_verses is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTTESTAMENT: {
          if ("layout/fragment_testament_0".equals(tag)) {
            return new FragmentTestamentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_testament is invalid. Received: " + tag);
        }
        case  LAYOUT_ROWBOOK: {
          if ("layout/row_book_0".equals(tag)) {
            return new RowBookBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for row_book is invalid. Received: " + tag);
        }
        case  LAYOUT_ROWCHAPTER: {
          if ("layout/row_chapter_0".equals(tag)) {
            return new RowChapterBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for row_chapter is invalid. Received: " + tag);
        }
        case  LAYOUT_ROWVERSE: {
          if ("layout/row_verse_0".equals(tag)) {
            return new RowVerseBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for row_verse is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(6);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "book");
      sKeys.put(2, "chapterNumber");
      sKeys.put(3, "subtitle");
      sKeys.put(4, "title");
      sKeys.put(5, "verse");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(7);

    static {
      sKeys.put("layout/activity_books_0", com.ryanada.bibilia.R.layout.activity_books);
      sKeys.put("layout/activity_books_appbar_0", com.ryanada.bibilia.R.layout.activity_books_appbar);
      sKeys.put("layout/activity_verses_0", com.ryanada.bibilia.R.layout.activity_verses);
      sKeys.put("layout/fragment_testament_0", com.ryanada.bibilia.R.layout.fragment_testament);
      sKeys.put("layout/row_book_0", com.ryanada.bibilia.R.layout.row_book);
      sKeys.put("layout/row_chapter_0", com.ryanada.bibilia.R.layout.row_chapter);
      sKeys.put("layout/row_verse_0", com.ryanada.bibilia.R.layout.row_verse);
    }
  }
}
