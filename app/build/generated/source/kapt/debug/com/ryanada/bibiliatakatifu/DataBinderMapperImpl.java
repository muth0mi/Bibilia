package com.ryanada.bibiliatakatifu;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.ryanada.bibiliatakatifu.databinding.ActivityMain2BindingImpl;
import com.ryanada.bibiliatakatifu.databinding.ActivityMainBindingImpl;
import com.ryanada.bibiliatakatifu.databinding.RowBookBindingImpl;
import com.ryanada.bibiliatakatifu.databinding.RowChapterBindingImpl;
import com.ryanada.bibiliatakatifu.databinding.RowVerseBindingImpl;
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
  private static final int LAYOUT_ACTIVITYMAIN = 1;

  private static final int LAYOUT_ACTIVITYMAIN2 = 2;

  private static final int LAYOUT_ROWBOOK = 3;

  private static final int LAYOUT_ROWCHAPTER = 4;

  private static final int LAYOUT_ROWVERSE = 5;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(5);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.ryanada.bibiliatakatifu.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.ryanada.bibiliatakatifu.R.layout.activity_main2, LAYOUT_ACTIVITYMAIN2);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.ryanada.bibiliatakatifu.R.layout.row_book, LAYOUT_ROWBOOK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.ryanada.bibiliatakatifu.R.layout.row_chapter, LAYOUT_ROWCHAPTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.ryanada.bibiliatakatifu.R.layout.row_verse, LAYOUT_ROWVERSE);
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
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAIN2: {
          if ("layout/activity_main2_0".equals(tag)) {
            return new ActivityMain2BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main2 is invalid. Received: " + tag);
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
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(5);

    static {
      sKeys.put("layout/activity_main_0", com.ryanada.bibiliatakatifu.R.layout.activity_main);
      sKeys.put("layout/activity_main2_0", com.ryanada.bibiliatakatifu.R.layout.activity_main2);
      sKeys.put("layout/row_book_0", com.ryanada.bibiliatakatifu.R.layout.row_book);
      sKeys.put("layout/row_chapter_0", com.ryanada.bibiliatakatifu.R.layout.row_chapter);
      sKeys.put("layout/row_verse_0", com.ryanada.bibiliatakatifu.R.layout.row_verse);
    }
  }
}
