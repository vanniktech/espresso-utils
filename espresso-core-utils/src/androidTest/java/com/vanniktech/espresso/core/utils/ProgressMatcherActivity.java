package com.vanniktech.espresso.core.utils;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ProgressBar;

public final class ProgressMatcherActivity extends Activity {
  static final int VIEW_ID = 1234;

  @Override protected void onCreate(@Nullable final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    final ProgressBar progressBar = new ProgressBar(this, null, 0); // Explicit no defStyleAttr.
    //noinspection ResourceType
    progressBar.setId(VIEW_ID);
    progressBar.setProgress(1);
    setContentView(progressBar);
  }
}
