package com.vanniktech.espresso.core.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;

public final class ViewIndexMatcherActivity extends Activity {
  @Override @SuppressLint("SetTextI18n") protected void onCreate(@Nullable final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    final TextView textView1 = new TextView(this);
    textView1.setText("Test");
    textView1.setTag(1);

    final TextView textView2 = new TextView(this);
    textView2.setText("Test");
    textView2.setTag(2);

    final LinearLayout linearLayout = new LinearLayout(this);
    linearLayout.addView(textView1);
    linearLayout.addView(textView2);
    setContentView(linearLayout);
  }
}
