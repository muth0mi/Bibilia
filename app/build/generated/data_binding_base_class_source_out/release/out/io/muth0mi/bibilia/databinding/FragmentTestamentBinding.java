// Generated by data binding compiler. Do not edit!
package io.muth0mi.bibilia.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import io.muth0mi.bibilia.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentTestamentBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView rvBooks;

  protected FragmentTestamentBinding(Object _bindingComponent, View _root, int _localFieldCount,
      RecyclerView rvBooks) {
    super(_bindingComponent, _root, _localFieldCount);
    this.rvBooks = rvBooks;
  }

  @NonNull
  public static FragmentTestamentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_testament, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentTestamentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentTestamentBinding>inflateInternal(inflater, R.layout.fragment_testament, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentTestamentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_testament, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentTestamentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentTestamentBinding>inflateInternal(inflater, R.layout.fragment_testament, null, false, component);
  }

  public static FragmentTestamentBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentTestamentBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentTestamentBinding)bind(component, view, R.layout.fragment_testament);
  }
}
