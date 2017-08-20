package com.vanniktech.espresso.core.utils;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

public final class CurrentItemMatcherActivity extends Activity {
  static final int VIEW_ID = 1234;

  @Override protected void onCreate(@Nullable final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    final ViewPager viewPager = new ViewPager(this);
    //noinspection ResourceType
    viewPager.setId(VIEW_ID);
    viewPager.setCurrentItem(0);
    setContentView(viewPager);
  }
}
