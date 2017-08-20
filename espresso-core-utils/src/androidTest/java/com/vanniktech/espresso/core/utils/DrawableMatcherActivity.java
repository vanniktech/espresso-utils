package com.vanniktech.espresso.core.utils;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

public final class DrawableMatcherActivity extends Activity {
  static final int VIEW_ID = 1234;

  ImageView imageView;

  @Override protected void onCreate(@Nullable final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    imageView = new ImageView(this);
    //noinspection ResourceType
    imageView.setId(VIEW_ID);
    setContentView(imageView);
  }
}
