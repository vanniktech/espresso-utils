package com.vanniktech.espresso.core.utils;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.vanniktech.espresso.core.utils.test.R;

public final class TextColorMatcherActivity extends Activity {
  static final int VIEW_ID = 1234;

  @Override protected void onCreate(@Nullable final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    final TextView textView = new TextView(this);
    //noinspection ResourceType
    textView.setId(VIEW_ID);
    textView.setTextColor(ContextCompat.getColor(this, R.color.red));
    setContentView(textView);
  }
}
