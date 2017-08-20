package com.vanniktech.espresso.core.utils;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;
import com.vanniktech.espresso.core.utils.test.R;

public final class HintTextColorMatcherActivity extends Activity {
  static final int VIEW_ID = 1234;

  @Override protected void onCreate(@Nullable final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    final TextView textView = new TextView(this);
    //noinspection ResourceType
    textView.setId(VIEW_ID);
    textView.setHintTextColor(ContextCompat.getColor(this, R.color.red));
    setContentView(textView);
  }
}
