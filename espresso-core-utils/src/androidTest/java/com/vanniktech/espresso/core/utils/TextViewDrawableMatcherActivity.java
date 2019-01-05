package com.vanniktech.espresso.core.utils;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.widget.TextView;

public final class TextViewDrawableMatcherActivity extends Activity {
  static final int VIEW_ID = 1234;

  TextView textView;

  @Override protected void onCreate(@Nullable final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    textView = new TextView(this);
    //noinspection ResourceType
    textView.setId(VIEW_ID);
    setContentView(textView);
  }
}
