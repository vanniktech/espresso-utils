package com.vanniktech.espresso.core.utils;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

public final class AppendTextActionActivity extends Activity {
  static final int VIEW_ID = 1234;

  @Override protected void onCreate(@Nullable final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    final TextView textView = new TextView(this);
    //noinspection ResourceType
    textView.setId(VIEW_ID);
    //noinspection AndroidLintSetTextI18n
    textView.setText("Test");
    setContentView(textView);
  }
}
