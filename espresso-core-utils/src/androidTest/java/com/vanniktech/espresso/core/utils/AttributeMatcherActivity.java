package com.vanniktech.espresso.core.utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public final class AttributeMatcherActivity extends AppCompatActivity {
  static final int VIEW_ID = 1234;

  @Override protected void onCreate(@Nullable final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    final TextView textView = new TextView(this);
    //noinspection ResourceType
    textView.setId(VIEW_ID);
    setContentView(textView);
  }
}
