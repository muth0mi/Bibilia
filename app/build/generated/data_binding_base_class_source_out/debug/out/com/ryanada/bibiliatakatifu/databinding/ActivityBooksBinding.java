// Generated by data binding compiler. Do not edit!
package com.ryanada.bibiliatakatifu.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import com.ryanada.bibiliatakatifu.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityBooksBinding extends ViewDataBinding {
  @NonNull
  public final DrawerLayout drawerLayout;

  @NonNull
  public final ActivityBooksAppbarBinding include;

  @NonNull
  public final NavigationView navView;

  protected ActivityBooksBinding(Object _bindingComponent, View _root, int _localFieldCount,
      DrawerLayout drawerLayout, ActivityBooksAppbarBinding include, NavigationView navView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.drawerLayout = drawerLayout;
    this.include = include;
    setContainedBinding(this.include);
    this.navView = navView;
  }

  @NonNull
  public static ActivityBooksBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_books, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityBooksBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityBooksBinding>inflateInternal(inflater, R.layout.activity_books, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityBooksBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_books, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityBooksBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityBooksBinding>inflateInternal(inflater, R.layout.activity_books, null, false, component);
  }

  public static ActivityBooksBinding bind(@NonNull View view) {
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
  public static ActivityBooksBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityBooksBinding)bind(component, view, R.layout.activity_books);
  }
}
